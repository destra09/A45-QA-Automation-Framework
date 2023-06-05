import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //GIVEN
        loginPage.login();

        //THEN
       Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
