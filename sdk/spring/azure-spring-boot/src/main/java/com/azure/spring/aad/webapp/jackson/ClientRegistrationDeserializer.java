// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.aad.webapp.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.io.IOException;

import static com.azure.spring.aad.webapp.jackson.JsonNodeUtils.MAP_TYPE_REFERENCE;
import static com.azure.spring.aad.webapp.jackson.JsonNodeUtils.SET_TYPE_REFERENCE;
import static com.azure.spring.aad.webapp.jackson.JsonNodeUtils.findObjectNode;
import static com.azure.spring.aad.webapp.jackson.JsonNodeUtils.findStringValue;
import static com.azure.spring.aad.webapp.jackson.JsonNodeUtils.findValue;

/**
 * A {@code JsonDeserializer} for {@link ClientRegistration}.
 *
 * @see ClientRegistration
 * @see ClientRegistrationMixin
 */
final class ClientRegistrationDeserializer extends JsonDeserializer<ClientRegistration> {
    private static final StdConverter<JsonNode, ClientAuthenticationMethod> CLIENT_AUTHENTICATION_METHOD_CONVERTER =
        new StdConverters.ClientAuthenticationMethodConverter();
    private static final StdConverter<JsonNode, AuthorizationGrantType> AUTHORIZATION_GRANT_TYPE_CONVERTER =
        new StdConverters.AuthorizationGrantTypeConverter();
    private static final StdConverter<JsonNode, AuthenticationMethod> AUTHENTICATION_METHOD_CONVERTER =
        new StdConverters.AuthenticationMethodConverter();

    @Override
    public ClientRegistration deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode clientRegistrationNode = mapper.readTree(parser);
        JsonNode providerDetailsNode = findObjectNode(clientRegistrationNode, "providerDetails");
        JsonNode userInfoEndpointNode = findObjectNode(providerDetailsNode, "userInfoEndpoint");

        return ClientRegistration
            .withRegistrationId(findStringValue(clientRegistrationNode, "registrationId"))
            .clientId(findStringValue(clientRegistrationNode, "clientId"))
            .clientSecret(findStringValue(clientRegistrationNode, "clientSecret"))
            .clientAuthenticationMethod(
                CLIENT_AUTHENTICATION_METHOD_CONVERTER.convert(
                    findObjectNode(clientRegistrationNode, "clientAuthenticationMethod")))
            .authorizationGrantType(
                AUTHORIZATION_GRANT_TYPE_CONVERTER.convert(
                    findObjectNode(clientRegistrationNode, "authorizationGrantType")))
            .redirectUriTemplate(findStringValue(clientRegistrationNode, "redirectUriTemplate"))
            .scope(findValue(clientRegistrationNode, "scopes", SET_TYPE_REFERENCE, mapper))
            .clientName(findStringValue(clientRegistrationNode, "clientName"))
            .authorizationUri(findStringValue(providerDetailsNode, "authorizationUri"))
            .tokenUri(findStringValue(providerDetailsNode, "tokenUri"))
            .userInfoUri(findStringValue(userInfoEndpointNode, "uri"))
            .userInfoAuthenticationMethod(
                AUTHENTICATION_METHOD_CONVERTER.convert(
                    findObjectNode(userInfoEndpointNode, "authenticationMethod")))
            .userNameAttributeName(findStringValue(userInfoEndpointNode, "userNameAttributeName"))
            .jwkSetUri(findStringValue(providerDetailsNode, "jwkSetUri"))
            .providerConfigurationMetadata(findValue(providerDetailsNode,
                "configurationMetadata", MAP_TYPE_REFERENCE, mapper))
            .build();
    }
}
