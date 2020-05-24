package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class loginPage
{
    @FindBy(how = How.CLASS_NAME, using ="username")
    public WebElement txt_username;

    @FindBy(how = How.CLASS_NAME, using ="password")
    public WebElement txt_password;

    @FindBy(how = How.CLASS_NAME, using ="btn-default")
    public WebElement btn_login;



    public void login (String user , String pass)
    {
        txt_username.sendKeys(user);
        txt_password.sendKeys(pass);
        btn_login.click();
    }




}
