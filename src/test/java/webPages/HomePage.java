package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webPages.BasePage;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;

    @FindBy(css = ".playlist:nth-child(3)")
    WebElement selectListedPlaylist;

    @FindBy(css = ".btn-delete-playlist")
    WebElement deletePlaylistBtn;

    @FindBy(css = "button[class = 'ok']")
    WebElement deletePlaylistPopupBtn;

    @FindBy(css = "div.success.show")
    WebElement successPopupNotification;

    @FindBy(css = "input[name='name']")
    WebElement playlistInputField;

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }

    public void openPlaylist() {
        selectListedPlaylist.click();
    }

    public void deletePlaylist()  {
        deletePlaylistBtn.click();
    }

    public void confirmDeletePlaylistPopup() {
        deletePlaylistBtn.click();
    }

    public String getDeletedPlaylistMsg() {
        return successPopupNotification.getText();
    }

    public void doubleClickSelectedPlaylist(){
        actions.doubleClick(selectListedPlaylist).perform();
    }

    public void enterNewPlaylistName(String playlistName){
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
        return playlistElement.isDisplayed();
    }
}
