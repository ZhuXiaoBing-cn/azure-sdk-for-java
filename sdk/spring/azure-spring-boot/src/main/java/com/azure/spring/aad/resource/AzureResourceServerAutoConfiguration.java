package com.azure.spring.aad.resource;


import com.azure.spring.aad.implementation.IdentityEndpoints;
import com.azure.spring.aad.resource.validator.AzureJwtAudienceValidator;
import com.azure.spring.aad.resource.validator.AzureJwtIssuerValidator;
import com.azure.spring.aad.resource.validator.AzureJwtTenantValidator;
import com.azure.spring.autoconfigure.aad.AADAuthenticationProperties;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.util.StringUtils;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AADAuthenticationProperties.class)
@ConditionalOnClass(name = {"org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken"})
public class AzureResourceServerAutoConfiguration {

    @Autowired
    private AADAuthenticationProperties aadAuthenticationProperties;

    @Bean
    @ConditionalOnMissingBean(JwtDecoder.class)
    JwtDecoder jwtDecoderByJwkKeySetUri() {
        if (StringUtils.isEmpty(aadAuthenticationProperties.getTenantId())) {
            aadAuthenticationProperties.setTenantId("common");
        }
        IdentityEndpoints endpoints = new IdentityEndpoints(aadAuthenticationProperties.getUri());
        NimbusJwtDecoder nimbusJwtDecoder = NimbusJwtDecoder
            .withJwkSetUri(endpoints.jwkSetEndpoint(aadAuthenticationProperties.getTenantId())).build();
        List<OAuth2TokenValidator<Jwt>> validators = createDefaultValidator();
        nimbusJwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(validators));
        return nimbusJwtDecoder;
    }

    //TODO There can be other jwtDecoder generation methods

    private List<OAuth2TokenValidator<Jwt>> createDefaultValidator() {
        List<OAuth2TokenValidator<Jwt>> validators = new ArrayList<>();
        if (!StringUtils.isEmpty(aadAuthenticationProperties.getClientId()) || !StringUtils
            .isEmpty(aadAuthenticationProperties.getAppIdUri())) {
            List<String> validAudiences = new ArrayList<>();
            validAudiences.add(aadAuthenticationProperties.getClientId());
            validAudiences.add(aadAuthenticationProperties.getAppIdUri());
            validators.add(new AzureJwtAudienceValidator(validAudiences));
        }
        validators.add(new AzureJwtTenantValidator(aadAuthenticationProperties.getTenantId(),
            aadAuthenticationProperties.getAllowedTenantIds()));
        validators.add(new AzureJwtIssuerValidator(aadAuthenticationProperties.getTenantId(),
            aadAuthenticationProperties.getAllowedTenantIds()));
        validators.add(new JwtTimestampValidator());
        return validators;
    }

}
