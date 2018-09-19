package pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexEmailIncoming {

    WebDriver driver;

    public YandexEmailIncoming(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='mail-MessageSnippet-Content']")
    public List<WebElement> massageIn;

    @FindBy(xpath = "//span[@class='mail-Message-Toolbar-Subject-Wrapper']/div")
    public WebElement titleMassage;
}
