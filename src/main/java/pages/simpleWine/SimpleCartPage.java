package pages.simpleWine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class SimpleCartPage {

    WebDriver driver;

    public SimpleCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Массив из добавленных элементов в заказ
   @FindBy (xpath = "//div[@class='cart-table__item']")
   public List<WebElement> productList;

    //Кнопка "+"
    @FindBy(xpath = "//a[@class='cart-table__count__action js-plus']")
    public WebElement buttonPlus;

    //Кнопка "Оформить заказ"
    @FindBy(id = "order-button")
    public WebElement buttonCreateOrder;
}
