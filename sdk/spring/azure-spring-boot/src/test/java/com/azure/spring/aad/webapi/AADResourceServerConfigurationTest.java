// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.aad.webapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.azure.spring.aad.AADTrustedIssuerRepository;
import com.azure.spring.aad.webapi.AADResourceServerConfiguration.DefaultAzureOAuth2ResourceServerWebSecurityConfigurerAdapter;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;

public class AADResourceServerConfigurationTest {

    private final WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
        .withPropertyValues("azure.activedirectory.user-group.allowed-groups=User");

    private AADTrustedIssuerRepository aadTrustedIssuerRepository = mock(AADTrustedIssuerRepository.class);

    @Test
    public void testNotExistBearerTokenAuthenticationToken() {
        this.contextRunner
            .withUserConfiguration(AADResourceServerConfiguration.class)
            .withClassLoader(new FilteredClassLoader(BearerTokenAuthenticationToken.class))
            .run(context -> {
                assertThat(context).doesNotHaveBean("jwtDecoderByJwkKeySetUri");
            });
    }

    @Test
    public void testCreateJwtDecoderByJwkKeySetUri() {
        this.contextRunner
            .withUserConfiguration(AADResourceServerConfiguration.class)
            .run(context -> {
                final JwtDecoder jwtDecoder = context.getBean(JwtDecoder.class);
                assertThat(jwtDecoder).isNotNull();
                assertThat(jwtDecoder).isExactlyInstanceOf(NimbusJwtDecoder.class);
            });
    }

    @Test
    public void testNotAudienceDefaultValidator() {
        when(aadTrustedIssuerRepository.getTrustedIssuers()).thenReturn(new HashSet<>());
        this.contextRunner
            .withUserConfiguration(AADResourceServerConfiguration.class)
            .run(context -> {
                AADResourceServerConfiguration bean = context
                    .getBean(AADResourceServerConfiguration.class);
                List<OAuth2TokenValidator<Jwt>> defaultValidator = bean
                    .createDefaultValidator(aadTrustedIssuerRepository);
                assertThat(defaultValidator).isNotNull();
                assertThat(defaultValidator).hasSize(1);
            });
    }

    @Test
    public void testExistAudienceDefaultValidator() {
        when(aadTrustedIssuerRepository.getTrustedIssuers()).thenReturn(new HashSet<>());
        this.contextRunner
            .withUserConfiguration(AADResourceServerConfiguration.class)
            .withPropertyValues("azure.activedirectory.app-id-uri=fake-app-id-uri")
            .run(context -> {
                AADResourceServerConfiguration bean = context
                    .getBean(AADResourceServerConfiguration.class);
                List<OAuth2TokenValidator<Jwt>> defaultValidator = bean
                    .createDefaultValidator(aadTrustedIssuerRepository);
                assertThat(defaultValidator).isNotNull();
            });
    }

    @Test
    public void testCreateWebSecurityConfigurerAdapter() {
        this.contextRunner
            .withUserConfiguration(AADResourceServerConfiguration.class)
            .run(context -> {
                WebSecurityConfigurerAdapter webSecurityConfigurerAdapter = context
                    .getBean(DefaultAzureOAuth2ResourceServerWebSecurityConfigurerAdapter.class);
                assertThat(webSecurityConfigurerAdapter).isNotNull();
            });
    }

}
