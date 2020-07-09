import common.commonMethodsClass;
import common.leftMenu;
import common.loginPage;
import common.mainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class business extends commonMethodsClass
{
    public static WebDriver driver;
    public static mainPage eventPage ;
    public static loginPage login ;
    public static leftMenu leftMenuPage;
    Actions action;

    @BeforeClass
    public void start()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String urlToOpen = commonMethodsClass.getData("urlToOpen");
        driver.get(urlToOpen);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        eventPage = PageFactory.initElements(driver, mainPage.class);
        login = PageFactory.initElements(driver, loginPage.class);
        leftMenuPage = PageFactory.initElements(driver, leftMenu.class);
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }

    @Test
    public void test1_login()
    {
        login.loginAction("viewer", "demo" , "AStrip01");

    }
      @Test
    public void test4_navigateThroughSideMenu()
    {
        commonMethodsClass.mouseOverElements(leftMenuPage.btn_analytics , leftMenuPage.btn_events);
    }

    @Test
    public void test2_verifyOneResult()
    {
        commonMethodsClass.insertTextInElement(eventPage.txt_searchField , "ItemAddedToCart");
        eventPage.txt_searchField.sendKeys(Keys.RETURN);
        commonMethodsClass.verifyTextInElement(eventPage.txt_result , "ItemAddedToCart");
        commonMethodsClass.numOfElements(eventPage.webElementList,1);
        commonMethodsClass.verifyWordContain(eventPage.webElementList , "ItemAddedToCart");

    }
    @Test
    public void test3_verifyTwoResults()
    {
        WebElement dclick = eventPage.txt_searchField;
        Actions action = new Actions(driver);
        action.doubleClick(dclick);
        action.build().perform();
        action.sendKeys(Keys.BACK_SPACE);
        commonMethodsClass.insertTextInElement(eventPage.txt_searchField , "Purchase");
        eventPage.txt_searchField.sendKeys(Keys.RETURN);
        commonMethodsClass.numOfElements(eventPage.webElementList,2);
        commonMethodsClass.verifyWordContain(eventPage.webElementList , "Purchase");

    }

}
