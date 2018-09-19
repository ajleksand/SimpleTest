package pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexAuthorizationPage {
    WebDriver driver;

    public YandexAuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Поле ввода логина
    @FindBy(xpath = "//input[@name='login']")
    public WebElement inputLogin;

    //Поле ввода логина
    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement inputPass;

    //Кнопка войти
    @FindBy(xpath = "//span[text()='Войти']/..")
    public WebElement buttonIn;

}
