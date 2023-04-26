import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test (enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(){

        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://testpro.io/
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPasswordTest(){
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public static void loginValidEmailEmptyPasswordTest() {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }
    public static void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
//        Assert.assertEquals(avatarIcon.isDisplayed(), true);
    }
}
