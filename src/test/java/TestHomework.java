import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomework extends BaseTest{

    @Test
    public void testMethod() throws InterruptedException {
        String playlistName = "kz-new playlist";

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("Pluto");

        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();
        Thread.sleep(2000);

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSong.click();
        Thread.sleep(2000);

        WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        addToButton.click();
        Thread.sleep(1000);

        // search the playlist and click
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"));
        playlist.click();

        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"kz-new playlist.\"");
    }
}
