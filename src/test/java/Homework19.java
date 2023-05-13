import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        driver.manage().window().maximize();

        //GIVEN
        provideEmail("denise.estrada@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //WHEN
        openPlaylist();
        clickDeletePlaylistBtn();
        confirmDeletePlaylistPopup();
        getDeletedPlaylistMsg();

        //THEN
        Assert.assertTrue(getDeletedPlaylistMsg().contains("Deleted playlist"));
    }

}
