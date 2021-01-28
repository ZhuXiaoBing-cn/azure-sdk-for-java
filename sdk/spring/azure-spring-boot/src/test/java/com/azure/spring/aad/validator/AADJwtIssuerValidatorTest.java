// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.aad.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.azure.spring.aad.AADTrustedIssuerRepository;
import com.azure.spring.autoconfigure.aad.AADAuthenticationProperties;
import com.azure.spring.autoconfigure.aad.AADTokenClaim;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class AADJwtIssuerValidatorTest {

    final AADAuthenticationProperties aadAuthenticationProperties = mock(AADAuthenticationProperties.class);
    final Jwt jwt = mock(Jwt.class);
    private AADTrustedIssuerRepository aadTrustedIssuerRepository = mock(AADTrustedIssuerRepository.class);
    @Test
    public void testIssuerSuccessVerify() {
        Set<String> trustedIssuers = new HashSet<>();
        trustedIssuers.add("https://sts.windows.net/fake-tenant-id/v1.0");
        trustedIssuers.add("https://sts.windows.net/fake-tenant-id/v2.0");
        when(aadAuthenticationProperties.getTenantId()).thenReturn("fake-tenant-id");
        when(jwt.getClaim(AADTokenClaim.ISS)).thenReturn("https://sts.windows.net/fake-tenant-id/v2.0");
        when(aadTrustedIssuerRepository.getTrustedIssuers()).thenReturn(trustedIssuers);

        AADJwtIssuerValidator validator = new AADJwtIssuerValidator(aadTrustedIssuerRepository.getTrustedIssuers());
        OAuth2TokenValidatorResult result = validator.validate(jwt);
        assertThat(result).isNotNull();
        assertThat(result.getErrors()).isEmpty();
    }

    @Test
    public void testIssuerFailureVerify() {
        Set<String> trustedIssuers = new HashSet<>();
        trustedIssuers.add("https://sts.windows.net/fake-tenant-id/v1.0");
        trustedIssuers.add("https://sts.windows.net/fake-tenant-id/v2.0");
        when(aadAuthenticationProperties.getTenantId()).thenReturn("common");
        when(jwt.getClaim(AADTokenClaim.ISS)).thenReturn("https://sts.failure.net/fake-tenant-id/v2.0");
        when(aadTrustedIssuerRepository.getTrustedIssuers()).thenReturn(trustedIssuers);

        AADJwtIssuerValidator validator = new AADJwtIssuerValidator(aadTrustedIssuerRepository.getTrustedIssuers());
        OAuth2TokenValidatorResult result = validator.validate(jwt);
        assertThat(result).isNotNull();
        assertThat(result.getErrors()).isNotEmpty();
    }

}
