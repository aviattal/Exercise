import common.commonMethodsClass;
import common.mainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class business
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
    @AfterClass
    public void close()
    {
        driver.quit();
    }

    @Test
    public void test1_verifyMessage()
    {
        seleniumEasy.btn_close.click();
        commonMethodsClass.insertTextInElement(seleniumEasy.txt_message , "Hello");
        seleniumEasy.btn_show_message.click();
        commonMethodsClass.verifyTextInElement(seleniumEasy.txt_show_message, "Hello");
    }

    @Test
    public void test2_verifyInput()
    {
        commonMethodsClass.insertTextInElement(seleniumEasy.txt_a , "3");
        commonMethodsClass.insertTextInElement(seleniumEasy.txt_b , "2");
        seleniumEasy.btn_showTotal.click();
        commonMethodsClass.verifyTextInElement(seleniumEasy.txt_showTotal ,"5");
    }
}
