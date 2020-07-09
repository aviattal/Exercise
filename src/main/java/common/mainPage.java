package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class mainPage
{
    @FindBy(how = How.ID, using ="screens-name-search")
    public WebElement txt_searchField;

    @FindBy(how = How.CLASS_NAME, using ="event-row__name")
    public WebElement txt_result;

    @FindBy(how = How.CLASS_NAME, using ="events-row-container")
    public List <WebElement> webElementList ;

    public void webList()
    {
        webElementList.size();
    }
    @FindBy(how = How.CLASS_NAME, using ="export-csv")
    public WebElement btn_csv;
}
