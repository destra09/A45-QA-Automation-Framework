import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }
}
