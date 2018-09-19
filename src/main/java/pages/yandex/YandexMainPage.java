package pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage {

    WebDriver driver;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Кнопка войти в почту
    @FindBy(xpath = "//span[text()='Войти в почту']/..")
    public WebElement buttonInEmail;

}
