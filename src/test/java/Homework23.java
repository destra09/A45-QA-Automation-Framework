import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //GIVEN
        loginPage.provideEmail("denise.estrada@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
