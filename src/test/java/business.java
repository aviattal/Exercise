import common.commonMethodsClass;
import common.mainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class business extends mainPage
{
    @BeforeClass
    public void start()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/react");
    }
    @AfterClass
    public void close() throws InterruptedException
    {
        driver.quit();
    }
    @BeforeMethod
    public void before()
    {
        createItem("AAA");
        createItem("BBB");
        createItem("CCC");
    }
    @AfterMethod
    public void after()
    {
        filterAll();
        deleteAllItems();
    }

    @Test
    public void test01_createItem()
    {
        assertEquals(getItemNumber(),3);

    }

    @Test
    public void test02_filterCompleted()
    {
        toggleItem(2);
        filterCompleted();
        assertEquals(getItemNumber(),1);
    }
    @Test
    public void test03_filterActive()
    {
        toggleItem(2);
        filterActive();
        assertEquals(getItemNumber(),2);
    }
    @Test
    public void test04_clearCompleted()
    {
        toggleItem(2);
        clearCompleted();
        assertEquals(getItemNumber(),2);
    }
    @Test
    public void test05_itemLeft()
    {
    }
    @Test
    public void test06_renameItem()
    {
        reNameItem(2, "DDD");
        assertEquals(getItemName(2), "DDD");
    }
    @Test
    public void test07_deleteItem()
    {
        deleteItem(0);
        assertEquals(getItemNumber(),2);
    }

}
