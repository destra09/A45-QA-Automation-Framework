import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongNotification = "Added 1 song into";

        //helper/reusable methods
        driver.manage().window().maximize();
        navigateToPage();
        provideEmail("denise.estrada@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //Wait and check for log in
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/home");

        searchSong("ketsa");
        searchViewAllResults();
        selectFirstSongResult();
        clickAddToBtn();
        selectPlaylist();

        Assert.assertTrue(getNotificationMessage().contains(newSongNotification));

    }

}
