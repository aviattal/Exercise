import common.commonMethodsClass;
import common.mainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class business
{
    protected static WebDriver driver;
  //  public static mainPage facebookLogin ;

    @BeforeClass
    public void start()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String urlToOpen = commonMethodsClass.getData("urlToOpen");
        driver.get(urlToOpen);
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }

    @Test
    public void test1_signUp()
    {
  /*      facebookLogin.signUp(commonMethodsClass.getData("firstName"),commonMethodsClass.getData("lastName"), "bill.gates@microsoft.com", "12345","28/3/1956");
        commonMethodsClass.verifyTextInElement(facebookLogin.error, "Your password must be at least 6 characters long. Please try another");*/
    }

}
