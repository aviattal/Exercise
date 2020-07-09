package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class loginPage
{
    @FindBy(how = How.ID, using ="username")
    public WebElement txt_userName;

    @FindBy(how = How.ID, using ="instance")
    public WebElement txt_instance;

    @FindBy(how = How.ID, using ="password")
    public WebElement txt_password;

    @FindBy(how = How.ID, using ="login-submit")
    public WebElement btn_submit;

    public void loginAction(String user , String instance , String password)
    {
        txt_userName.sendKeys(user);
        txt_instance.sendKeys(instance);
        txt_password.sendKeys(password);
        btn_submit.click();
    }
}
