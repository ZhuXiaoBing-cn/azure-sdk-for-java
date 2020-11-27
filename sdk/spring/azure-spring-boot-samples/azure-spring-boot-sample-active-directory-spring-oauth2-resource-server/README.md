# OAuth 2.0 Sample for Azure AD Spring Boot Starter Resource Server library for Java

## Key concepts
This sample illustrates how to protect an Java web API by restricting access to its resources to authorized accounts only.
Obtain Bearer Token in the request head of resources and carry out analysis and verification. After verification,
injects AzureOAuth2AuthenticatedPrincipal object that is associated with the thread of the current user request. 
token claimsset, JWS headers etc. are accessible from the object which can be used for role based authorization.


## Getting started

To run this sample, you'll need:

- JDK 1.8 and above
- [Maven](https://maven.apache.org/) 3.0 and above
- An Internet connection
- A Windows machine (necessary if you want to run the app on Windows)
- An OS X machine (necessary if you want to run the app on Mac)
- A Linux machine (necessary if you want to run the app on Linux)
- An Azure Active Directory (Azure AD) tenant. For more information on how to get an Azure AD tenant, see [How to get an Azure AD tenant](https://azure.microsoft.com/documentation/articles/active-directory-howto-tenant/)
- 在 Azure Active Directory 中 your web API in App registrations in the Azure portal.
- 有一个web app 程序，Go to the Azure portal - App registrations quickstart experience.
## Examples

### Configure application.properties

```properties
azure.activedirectory.app-id-uri=xxxxxxxx-app-id-uri-xxxxxxxxxx
azure.activedirectory.session-stateless=true
#使用一个没有被占用的端口
server.port=8081
```

### Run with Maven 
First, we need to ensure that this [instruction] is completed before run.
```shell
# Under sdk/spring project root directory
mvn clean install -DskipTests
cd azure-spring-boot-samples/azure-spring-boot-sample-active-directory-spring-oauth2-resource-server
mvn spring-boot:run
```

### 启动web app

Access a URL in the browser that requires you to go to webAPI for a resource.

### Check authorization

1. Access `group1 Message` link, should success
2. Access `group2 Message` link, should fail with forbidden error message

## Troubleshooting

## Next steps
## Contributing
<!-- LINKS -->
[instruction]: https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/spring/CONTRIBUTING.md#building-from-source