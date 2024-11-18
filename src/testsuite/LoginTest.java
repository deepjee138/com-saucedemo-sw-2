package testsuite;
/**
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify the text “Products”
 *
 * 2 verifyThatSixProductsAreDisplayedOnPage()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify that six products are displayed
 * on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” for the username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //*Enter “secret_sauce” for the password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //* Click on the ‘Login’ button
        driver.findElement(By.id("login-button")).click();
        //* Verify the text “Products”
        String expectedResult="Products";
        WebElement text=driver.findElement(By.className("title"));
        String actualResult=text.getText();
        Assert.assertEquals("Not display",expectedResult,actualResult);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” for the username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //*Enter “secret_sauce” for the password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //* Click on the ‘Login’ button
        driver.findElement(By.id("login-button")).click();
        // Verify that six products are displayed  on page
      List<WebElement> productList=driver.findElements(By.xpath("//div[@class='inventory_item']"));
      int expectedProduct=6;
      Assert.assertEquals("6 Product are not displed",expectedProduct,productList.size());



    }
@After
    public void tearDown() {
         closeBrowser();
    }
}




