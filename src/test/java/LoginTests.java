import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.HomePage;
import webPages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (enabled = true, priority = 0, description = "Login with valid email and valid password")
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //GIVEN
        loginPage.provideEmail("denise.estrada@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //THEN
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test (enabled = true, priority = 1, description = "Login with invalid email and valid password")
    public void LoginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        //GIVEN
        loginPage.provideEmail("test@email")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //THEN
        Assert.assertTrue(loginPage.getKoelImg().isDisplayed());
    }

    @Test (enabled = true, priority = 2, description = "Login with invalid email and valid password")
    public void loginValidEmailEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        //GIVEN
        loginPage.provideEmail("test@email.com")
                .providePassword("")
                .clickSubmit();

        //THEN
        Assert.assertTrue(loginPage.getKoelImg().isDisplayed());
    }
}
