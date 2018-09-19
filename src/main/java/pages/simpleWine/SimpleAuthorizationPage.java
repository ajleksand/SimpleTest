package pages.simpleWine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleAuthorizationPage {

    private WebDriver driver;

    public SimpleAuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Заголовок "Вход"
    @FindBy(xpath = "//div[@class='auth-title']")
    public WebElement authorizationTitle;

    //Поле ввода логина
    @FindBy(id = "LOGIN")
    public WebElement inputLogin;

    //Поле ввода пароля
    @FindBy(id = "PASS")
    public WebElement inputPass;

    @FindBy(xpath = "//div[@class='auth-sub']/input[@value='Войти']")
    public WebElement buttonIn;

}
