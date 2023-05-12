import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        driver.manage().window().maximize();
        String deletedPlaylistMsg = "Deleted playlist";

        provideEmail("denise.estrada@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        openPlaylist();
        clickDeletePlaylistBtn();
        confirmDeletePlaylistPopup();
        getDeletedPlaylistMsg();

    }

}
