package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class coastersPage
{
    @FindBy(how = How.CLASS_NAME, using ="product-thumbnail__image")
    public List <WebElement> search__results;

    @FindBy(how = How.CSS, using ="img[alt='Cork Coasters']")
    public WebElement cork_coaster;

}
