
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.simpleWine.*;
import pages.yandex.YandexAuthorizationPage;
import pages.yandex.YandexEmailIncoming;
import pages.yandex.YandexMainPage;

import java.util.concurrent.TimeUnit;

import static data.Settings.*;

public class SimpleTest {

    private WebDriver driver;

    @Before
    public void setUpBefore() {

        //прописываем путь к драйверу браузера
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        //Установим ожидание на поиск элемента в 10 секунд.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Задаем размер окна браузера во весь экран
        driver.manage().window().maximize();

    }

    @Test
    public void simpleTest() throws InterruptedException {

        String numberOrder;

        //Загружаем адрес страницы
        driver.get(URLSW);

        //Создаем экземпляр класса SimpleMainPage
        SimpleMainPage simpleMainPage = new SimpleMainPage(driver);

        //Подтверждаем что нам исполнилось 18 лет
        if (simpleMainPage.button18Years.isDisplayed()) {
            simpleMainPage.button18Years.click();
        } else {
            System.out.println("Не удалось найти кнопку подтверждающую возраст.");
        }

        //Проверяем корректность заголовка страницы
        String actualTitle = driver.getTitle();
        String expectedTitle = "Купить вино, шампанское и крепкие напитки в Москве - интернет витрина элитного вина simplewine.ru";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Нажимаем на ссылку "Вход на сайт"
        simpleMainPage.linkEnterSite.click();

        //Создаем экземпляр страницы авторизации
        SimpleAuthorizationPage simpleAuthorizationPage = new SimpleAuthorizationPage(driver);

        //Проверяем что мы находимся на странице авторизации
        Assert.assertTrue(simpleAuthorizationPage.authorizationTitle.isDisplayed());

        //Вводим логин и пароль
        simpleAuthorizationPage.inputLogin.sendKeys(SIMPLELOGIN);
        simpleAuthorizationPage.inputPass.sendKeys(SIMPLEPASS);

        //Нажимаем кнопку войти
        simpleAuthorizationPage.buttonIn.click();

        //Проверяем что авторизавались на сайте
        Assert.assertNotEquals(simpleMainPage.name.getText(), "Вход на сайт");

        //Открываем вкладку "Вино"
        simpleMainPage.linkWine.click();

        //Проверяем корректность заголовка страницы
        actualTitle = driver.getTitle();
        expectedTitle = "Купить вино по цене от 220 руб в интернет-магазине и винотеках SimpleWine";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Создаем экземпляр страницы "Вино"
        SimpleWinePage simpleWinePage = new SimpleWinePage(driver);

        //Проставляем чекбокс "белое"
        if (!simpleWinePage.checkboxWhite.isSelected()) {
            simpleWinePage.checkboxWhite.click();
        }
        Thread.sleep(9000);

        //Проставляем чекбокс цены "3000-5000"
        if (!simpleWinePage.checkboxPrice3_5.isSelected()) {
            simpleWinePage.checkboxPrice3_5.click();
        }
        Thread.sleep(9000);

        //Добавляем первый товар в корзину
        simpleWinePage.buttonBasket.click();
        Thread.sleep(3000);

        //Если всплывающее окно "Товар добавлен в козину" появилось, то переходим в корзину
        if (simpleWinePage.popupAddBasket.isDisplayed()) {
            simpleWinePage.buttonGoToBasket.click();
        } else {
            System.out.println("Не удалось добавить товар в корзину.");
        }

        //Создаем экземпляр страницы "Корзина"
        SimpleCartPage simpleCartPage = new SimpleCartPage(driver);

        //Проверяем что один товар в корзине
        if (simpleCartPage.productList.size() != 1) {
            System.out.println("Товаров в корзине " + simpleCartPage.productList.size() + ". Не соответствует условиям теста!");
        }
        Assert.assertEquals(simpleCartPage.productList.size(), 1);

        //Нажимаем на кнопку "+"
        simpleCartPage.buttonPlus.click();
        Thread.sleep(6000);

        //Нажимаем на кнопку оформить заказ
        simpleCartPage.buttonCreateOrder.click();

        //Создаем экземпляр страницы "оформление заказа"
        SimpleOrderingPage simpleOrderingPage = new SimpleOrderingPage(driver);

        //Проверяем что поле имя не пустое, если пустое заполняем
        simpleOrderingPage.inputNotNull(simpleOrderingPage.inputFirstName, "Test");

        //Проверяем что поле фамилия не пустое, если пустое заполняем
        simpleOrderingPage.inputNotNull(simpleOrderingPage.inputLastName, "Test");

        //Проверяем что поле фамилия не пустое, если пустое заполняем
        simpleOrderingPage.inputNotNull(simpleOrderingPage.inputEmail, SIMPLELOGIN);

        //Проверяем что поле телефон не пустое, если пустое заполняем
        simpleOrderingPage.inputNotNull(simpleOrderingPage.inputPhone, "1231231231");

        //Выбираем пункт "Наличный расчёт"
        simpleOrderingPage.labelCash.click();

        //Выбираем пункт "Самовывоз"
        simpleOrderingPage.labelPickup.click();

        //Выбираем магазин на м.Проспект Мира
        simpleOrderingPage.addressPM.click();

        //Проверяем что поле комментарий не пустое, если пустое заполняем
        simpleOrderingPage.inputNotNull(simpleOrderingPage.inputComent, "Тестовый заказ");

        //Выбираем ближайший понедельник
        if (!(simpleOrderingPage.dateGetOrderOnDisplay.getText().toUpperCase().contains("ПОНЕДЕЛЬНИК"))) {

            simpleOrderingPage.dateGetOrderOnDisplay.click();

            for (int i = 0; i < simpleOrderingPage.dateGetOrder.size(); i++)
                if (simpleOrderingPage.dateGetOrder.get(i).getText().toUpperCase().contains("ПОНЕДЕЛЬНИК")) {
                    simpleOrderingPage.dateGetOrder.get(i).click();
                    break;
                }
        }

        //Нажимаем оформить заказ
        simpleOrderingPage.buttonСheckout.click();
        Thread.sleep(9000);
        //Проверяем что заказ успешно оформлен
        Assert.assertTrue(simpleOrderingPage.titleReadyOrder.isDisplayed());

        //Запоминаем номер заказа
        numberOrder = simpleOrderingPage.numberOrder.getText();

        //Переходим на страницу Яндекса
        driver.get(URLYANDEX);

        //Нажимаем на кнопку войти в почту
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        yandexMainPage.buttonInEmail.click();

        //Вводим логин и пароль
        YandexAuthorizationPage yandexAuthorizationPage = new YandexAuthorizationPage(driver);
        yandexAuthorizationPage.inputLogin.sendKeys(YANDEXLOGIN);
        yandexAuthorizationPage.inputPass.sendKeys(YANDEXPASS);

        //Нажимаем кнопку войти
        yandexAuthorizationPage.buttonIn.click();


        //Нажимаем на первое письмо
        YandexEmailIncoming yandexEmailIncoming = new YandexEmailIncoming(driver);
        yandexEmailIncoming.massageIn.get(0).click();

        //Выкусымаем номер заказа из сообщения
        String str = yandexEmailIncoming.titleMassage.getText();
        int i = str.indexOf('/');
        int j = str.indexOf(']');
        String res = str.substring(i + 1, j);

        //Выводим оба в конcоль
        System.out.println("Номер заказа из почты " + res);
        System.out.println("Номер заказа из корзины " + numberOrder);

        //Проверяем что номера совпадают
        Assert.assertEquals(res, numberOrder);


    }


    @After
    public void tearDownAfter() {
        driver.quit();
    }
}
