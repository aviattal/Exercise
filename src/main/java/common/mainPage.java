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
   @FindBy(how = How.CLASS_NAME, using ="list-left")
    public WebElement left_list;

    @FindBy(how = How.CLASS_NAME, using ="list-right")
    public WebElement right_list;

    @FindBy(how = How.CLASS_NAME, using ="move-right")
    public WebElement btn_right;

}
