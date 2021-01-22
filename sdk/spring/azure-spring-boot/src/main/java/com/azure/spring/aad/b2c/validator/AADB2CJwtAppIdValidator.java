package com.azure.spring.aad.b2c.validator;

import com.azure.spring.aad.webapi.validator.AADJwtClaimValidator;
import com.azure.spring.autoconfigure.aad.AADTokenClaim;
import java.util.Set;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.Assert;

/**
 * Validates the "azp" claim in a {@link Jwt}, that is matches a configured value.
 */
public class AADB2CJwtAppIdValidator implements OAuth2TokenValidator<Jwt> {

    private final AADJwtClaimValidator<Set<String>> validator;

    /**
     * Constructs a {@link AADB2CJwtAppIdValidator} using the provided parameters
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public AADB2CJwtAppIdValidator(Set<String> aclLists) {
        if (!aclLists.isEmpty()) {
            this.validator = new AADJwtClaimValidator<>(AADTokenClaim.APPID, appId -> {
                if (appId == null) {
                    return true;
                }
                return aclLists.contains(appId);
            });
        } else {
            this.validator = new AADJwtClaimValidator<>(AADTokenClaim.APPID, appId -> true);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        Assert.notNull(token, "token cannot be null");
        return this.validator.validate(token);
    }
}
