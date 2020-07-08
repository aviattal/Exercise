package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class mainPage
{
    @FindBy(how = How.ID, using ="user-message")
    public WebElement txt_message;

    @FindBy(how = How.XPATH , using = "//*[text() = 'Show Message']")
    public WebElement btn_show_message;

    @FindBy(how = How.XPATH , using = "//*[@id='display']")
    public WebElement txt_show_message;

    @FindBy(how = How.CLASS_NAME , using = "at-cm-no-button")
    public WebElement btn_close;

    @FindBy(how = How.ID , using = "sum1")
    public WebElement txt_a;

    @FindBy(how = How.ID , using = "sum2")
    public WebElement txt_b;

    @FindBy(how = How.XPATH , using = "//*[@id='gettotal']/button")
    public WebElement btn_showTotal;

    @FindBy(how = How.ID , using = "displayvalue")
    public WebElement txt_showTotal;




/*    @FindBy(how = How.NAME, using ="lastname")
    public WebElement txt_lastName;

    @FindBy(how = How.NAME, using ="reg_email__")
    public WebElement txt_email;

    @FindBy(how = How.NAME, using ="reg_email_confirmation__")
    public WebElement txt_email_confirm;

    @FindBy(how = How.NAME, using ="websubmit")
    public WebElement btn_webSubmit;

    @FindBy(how = How.ID, using ="reg_error_inner")
    public WebElement error;

    public void signUp( String fName, String lName, String email, String pass, String bday )
    {
        txt_firstName.sendKeys(fName);
        txt_lastName.sendKeys(lName);
        txt_email.sendKeys(email);
        txt_email_confirm.sendKeys(email);
        txt_password.sendKeys(pass);
        insertBirthDay(bday);
        radio_male.click();
        btn_webSubmit.click();

    }
    public void insertBirthDay(String bday)
    {
        String [] values = bday.split("/");
        Select Day = new Select(txt_birthday_day);
        Select Month = new Select(txt_birthday_month);
        Select Year = new Select(txt_birthday_year);
        Month.selectByIndex(Integer.parseInt(values[1]));
        Day.selectByVisibleText(values[0]);
        Year.selectByVisibleText(values[2]);
    }*/
}
