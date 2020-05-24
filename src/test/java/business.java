import common.commonMethodsClass;
import common.corkCoastersPage;
import common.mainPage;
import common.coastersPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class business
{
    static WebDriver driver;
    static mainPage MainPage;
    static corkCoastersPage CorkPage;
    static coastersPage CoasterPage;


    @BeforeClass
    public void start()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.github.myshopify.com");
        //String urlToOpen = commonMethodsClass.getData("urlToOpen");
        //driver.get(urlToOpen);

        MainPage = PageFactory.initElements(driver, mainPage.class);
        CorkPage = PageFactory.initElements(driver, corkCoastersPage.class);
        CoasterPage = PageFactory.initElements(driver, coastersPage.class);
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }

    @Test
    public void test1_search()
    {
        MainPage.search.sendKeys("Coasters");
        MainPage.search.sendKeys(Keys.ENTER);
        assertEquals(2, CoasterPage.search__results.size());
        CoasterPage.cork_coaster.click();
        assertEquals(1, CorkPage.txt_amount.getText());

    }

}
