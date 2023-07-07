import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.HomePage;
import webPages.LoginPage;

public class Homework23 extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //GIVEN
        loginPage.provideEmail("denise.estrada@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void LoginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //GIVEN
        loginPage.provideEmail("test@email")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //THEN
        Assert.assertTrue(loginPage.getKoelImg().isDisplayed());
    }
}
