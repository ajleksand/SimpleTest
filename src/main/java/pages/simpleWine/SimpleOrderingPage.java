package pages.simpleWine;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleOrderingPage {
    WebDriver driver;

    public SimpleOrderingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Поле для ввода Имени
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement inputFirstName;

    //Поле для ввода Фамилии
    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement inputLastName;

    //Поле для ввода Почты
    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputEmail;

    //Поле для ввода Телефона
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement inputPhone;

    //Поле для ввода Коментария
    @FindBy(xpath = "//*[@name='ORDER_DESCRIPTION']")
    public WebElement inputComent;

    //Лэйбл "Наличный расчёт"
    @FindBy(xpath = "//label[text()='Наличный расчёт']")
    public WebElement labelCash;

    //Лэёбл "Самовывоз"
    @FindBy(xpath = "//div[@class='checkout-dlivery-customer__item delivery-type-local']/label")
    public WebElement labelPickup;

    //Адрес магазина "Проспект Мира"
    @FindBy(xpath = "//span[text()='м. Проспект Мира, ']/../..")
    public  WebElement addressPM;

    //Текущая дата получения заказа
    @FindBy(xpath = "//div[@class='select-field__display']")
    public  WebElement dateGetOrderOnDisplay;

    //Даты получения заказа
    @FindBy(xpath = "//div[@class='select-field__item']")
    public List<WebElement> dateGetOrder;

    //Кнопка оформить заказ
    @FindBy(xpath = "//button[text()='Оформить заказ']")
    public WebElement buttonСheckout;

    //Заголовок об успешности заказа
    @FindBy(xpath = "//h1")
    public WebElement titleReadyOrder;

    //Номер заказа
    @FindBy(xpath = "//td[text()='Номер вашего заказа:']/../td[2]")
    public WebElement numberOrder;

    //Метод проверки и заполнения поля в случае необходимости
    public void inputNotNull(WebElement input, String inputText) {

        String textInput = input.getAttribute("value");
        if (textInput.length() == 0) {
            input.sendKeys(inputText);
        }


    }



}
