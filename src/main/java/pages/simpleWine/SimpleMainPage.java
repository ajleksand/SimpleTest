package pages.simpleWine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class SimpleMainPage {

    private WebDriver driver;

   public SimpleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Кнопка подтверждающая возраст
    @FindBy(xpath = "//button[text()='Мне исполнилось 18 лет']")
    public WebElement button18Years;

    //Ссылка "Вход на сайт"
     @FindBy(xpath = "//span[@class='manage-link-description']")
     public WebElement linkEnterSite;

     //Имя авторизованного пользователя
     @FindBy(xpath = "//a[@class='dropdown__text']//span")
     public WebElement name;

     //Ссылка "Вино"
     @FindBy(xpath = "//span/a[@href='/catalog/vino/']")
     public  WebElement linkWine;



}
