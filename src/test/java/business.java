import common.commonMethodsClass;
import common.mainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class business extends commonMethodsClass
{
    protected static WebDriver driver;
    public static mainPage seleniumEasy ;

    @BeforeClass
    public void start()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String urlToOpen = commonMethodsClass.getData("urlToOpen");
        driver.get(urlToOpen);

        seleniumEasy = PageFactory.initElements(driver, mainPage.class);

    }
  /*  @AfterClass
    public void close()
    {
        driver.quit();
    }*/

    @Test
    public void test1_verifyNumOfElement()
    {
        WebElement listOfElements = driver.findElement(By.className("list-left"));
        List<WebElement> lis = listOfElements.findElements(By.xpath(".//li"));
        lis.get(0).click();
        seleniumEasy.btn_right.click();
        lis = listOfElements.findElements(By.xpath(".//li"));
        commonMethodsClass.numOfElements(lis ,4);



    }

}
