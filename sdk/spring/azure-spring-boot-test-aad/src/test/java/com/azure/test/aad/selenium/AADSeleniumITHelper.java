package com.azure.test.aad.selenium;

import static com.azure.spring.test.aad.EnvironmentVariables.AAD_MULTI_TENANT_CLIENT_ID;
import static com.azure.spring.test.aad.EnvironmentVariables.AAD_MULTI_TENANT_CLIENT_SECRET;
import static com.azure.spring.test.aad.EnvironmentVariables.AAD_TENANT_ID_1;
import static com.azure.spring.test.aad.EnvironmentVariables.AAD_USER_NAME_1;
import static com.azure.spring.test.aad.EnvironmentVariables.AAD_USER_PASSWORD_1;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import com.azure.test.aad.common.SeleniumITHelper;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AADSeleniumITHelper extends SeleniumITHelper {

    private String username;
    private String password;

    static {
        DEFAULT_PROPERTIES.put("azure.activedirectory.tenant-id", AAD_TENANT_ID_1);
        DEFAULT_PROPERTIES.put("azure.activedirectory.client-id", AAD_MULTI_TENANT_CLIENT_ID);
        DEFAULT_PROPERTIES.put("azure.activedirectory.client-secret", AAD_MULTI_TENANT_CLIENT_SECRET);
        DEFAULT_PROPERTIES.put("azure.activedirectory.user-group.allowed-groups", "group1");
        DEFAULT_PROPERTIES.put("azure.activedirectory.post-logout-redirect-uri", "http://localhost:${server.port}");
    }

    public AADSeleniumITHelper(Class<?> appClass, Map<String, String> properties) {
        username = AAD_USER_NAME_1;
        password = AAD_USER_PASSWORD_1;
        createDriver();
        createAppRunner(appClass, properties);
    }

    public void login() {
        driver.get(app.root() + "oauth2/authorization/azure");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt"))).sendKeys(username + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd"))).sendKeys(password + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
    }

    public String httpGet(String endpoint) {
        driver.get((app.root() + endpoint));
        return wait.until(presenceOfElementLocated(By.tagName("body"))).getText();
    }

    public void logoutTest() {
        driver.get(app.root() + "logout");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        String cssSelector = "div[data-test-id='" + username + "']";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();
        String id = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[tabindex='0']")))
            .getAttribute("data-test-id");
        Assert.assertEquals(username, id);
    }

}
