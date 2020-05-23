
import common.commonMethodsClass;
import common.commonObjects;
import common.declerationsClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class appTests extends declerationsClass
{
    @BeforeClass
    public void start()
    {
        String urlToOpen = commonMethodsClass.getData("urlToOpen");
        WebDriverManager.chromedriver().setup();
        common.commonObjects.driver = new ChromeDriver();
        common.commonObjects.actions = new Actions(common.commonObjects.driver);
        common.commonObjects.driver.manage().window().maximize();
        common.commonObjects.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        common.commonObjects.driver.get(urlToOpen);
    }
    @AfterClass
    public void close() throws InterruptedException
    {
        common.commonObjects.driver.quit();
    }
    @BeforeMethod
    public void before()
    {

    }
    @AfterMethod
    public void after()
    {

    }

}
