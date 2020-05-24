package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class corkCoastersPage
{
    @FindBy(how = How.ID, using ="Quantity")
    public WebElement txt_amount;
}
