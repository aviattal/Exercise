package todoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class todoMethods
{
    public static WebDriver driver;
    public Actions action;

    public void createItem(String name )
    {
        driver.findElement(By.className("new-todo")).sendKeys(name);
        driver.findElement(By.className("new-todo")).sendKeys(Keys.RETURN);
    }
    public void filterAll()
    {
        driver.findElement(By.linkText("All")).click();

    }
    public List<WebElement> listItems()
    {
        return driver.findElements(By.xpath("/html/body/section/div/section/ul/li"));

    }
    public int getItemNumber()
    {

        return listItems().size();

    }
    public  void deleteItem (int index)
    {

        WebElement itemDeleteX= driver.findElement(By.tagName("button"));
        action.moveToElement(listItems().get(index)).moveToElement(itemDeleteX).click().build().perform();


        /*WebElement itemDeleteX = driver.findElement(By.tagName("button"));
        List<WebElement> lisOfWebElements = listItems();
        WebElement selected = lisOfWebElements.get(index);
        action.moveToElement(selected).click().build().perform();*/
    }

    public void deleteAllItems()
    {
        int count = getItemNumber();
        for (int i =0; i <count; i++ )
        {
            deleteItem(0);
        }
    }
    public void toggleItem(int index)
    {
        listItems().get(index).findElement(By.className("toggle")).click();
    }
    public void filterCompleted()
    {
        driver.findElement(By.linkText("Completed")).click();
    }
    public void filterActive()
    {
        driver.findElement(By.linkText("Active")).click();
    }
    public void clearCompleted()
    {
        driver.findElement(By.className("clear-completed")).click();
    }
    //    public int getItemsLeft()
//    {
//      return driver.findElement(By.className("todo-count")
//
//    }
    public String getItemName(int index)
    {
        return listItems().get(index).findElement(By.tagName("label")).getText();
    }

    public void reNameItem(int index, String newName)
    {

        int charCount = getItemName(index).length();
        WebElement itemName = listItems().get(index).findElement(By.tagName("label"));
        action.doubleClick(itemName).build().perform();
        for (int i=0 ; i < charCount ; i++)
        {
            listItems().get(index).findElement(By.className("edit")).sendKeys(Keys.BACK_SPACE);
        }
        listItems().get(index).findElement(By.className("edit")).sendKeys(newName);
        listItems().get(index).findElement(By.className("edit")).sendKeys(Keys.RETURN);
    }
}
