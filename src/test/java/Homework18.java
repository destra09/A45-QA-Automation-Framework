import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        driver.manage().window().maximize();
        navigateToPage();
        provideEmail("denise.estrada@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        playNextSong();
        Assert.assertTrue(songPlayingCheck());
    }

}
