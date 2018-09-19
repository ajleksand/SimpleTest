package pages.simpleWine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SimpleWinePage {

    WebDriver driver;

    public SimpleWinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Чекбокс "белое"
    @FindBy(xpath = "//div[@id='arrFilter_634_3203668572-styler']")
    public WebElement checkboxWhite;

    //Чекбокс цена 3000-5000
    @FindBy (xpath = "//div[@id='arrFilter_1328_1842515611-styler']")
    public  WebElement checkboxPrice3_5;

    //Кнопка с корзиной первого элемента в поиске
    @FindBy(xpath = "//div[@class='category__content js-catalog-list']/div[@class='row']/div[1]//button")
    public WebElement buttonBasket;

    //Всплывающее окно "Товар добавлен в козину"
    @FindBy(xpath = "//span[text()='Товар добавлен в корзину']")
    public WebElement popupAddBasket;

    //Кнопка перейти в корзину
    @FindBy(xpath = "//a[text()='Перейти в корзину']")
    public WebElement buttonGoToBasket;
}
