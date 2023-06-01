import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        driver.manage().window().maximize();
        playlistName = "PlaylistTest1";

        //GIVEN
        provideEmail("denise.estrada@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //WHEN
        //doubleClickSelectedPlaylist();
        //enterNewPlaylistName();

        //THEN
       //Assert.assertTrue(doesPlaylistExist());
    }
}
