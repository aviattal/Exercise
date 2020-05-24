import common.commonMethodsClass;
import common.loginPage;
import common.mainScreen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class business
{
    public static WebDriver driver;
    static loginPage flightLogin ;
    static mainScreen flightMain ;
    Select from, to;

    @BeforeClass
    public void start()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String urlToOpen = commonMethodsClass.getData("urlToOpen");
        driver.get(urlToOpen);

        flightLogin = PageFactory.initElements(driver, loginPage.class);
        flightMain = PageFactory.initElements(driver, mainScreen.class);
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }

    @Test
    public void test1_login()
    {
        flightLogin.login("test", "demo123");

    }
    @Test
    public void flightSelect()
    {
        from = new Select (driver.findElement(By.id("from")));
        from.selectByVisibleText("New York");
        to = new Select(driver.findElement(By.id("to")));
        to.selectByVisibleText("Los Angeles");

        String date = driver.findElement(By.id("dateTo")).getAttribute("ng-reflect-model");
        driver.findElement(By.id("dateTo")).clear();

    }

}
