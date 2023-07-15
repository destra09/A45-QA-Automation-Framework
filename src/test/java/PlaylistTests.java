import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.HomePage;
import webPages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        driver.manage().window().maximize();
        playlistName = "PlaylistTest";

        //GIVEN
        loginPage.provideEmail("denise.estrada@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();

        //WHEN
        homePage.doubleClickSelectedPlaylist();
        homePage.enterNewPlaylistName(playlistName);

        //THEN
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
