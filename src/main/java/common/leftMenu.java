package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class leftMenu
{
    @FindBy(how = How.XPATH, using ="//*[@id='menu-list']/div[1]/li/ul/li[5]/a")
    public WebElement btn_analytics;

    @FindBy(how = How.XPATH, using ="//*[@id='menu-list']/div[1]/li/ul/li[5]/div/ul/li[4]/a")
    public WebElement btn_events;


}
