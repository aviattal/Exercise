package common;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import static org.testng.Assert.assertEquals;

public class commonMethodsClass
{
     static File fxmlFile;
    public static String getData(String nodaName)
    {

        DocumentBuilderFactory dbFactory;
        DocumentBuilder dbBuilder;
        Document doc = null;
        try
        {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally
        {
            NodeList element = doc.getElementsByTagName(nodaName);
            return element.item(0).getTextContent().toString();
        }

    }
    public static void verifyTextInElement(WebElement element, String text)
    {
        assertEquals(element.getText(), text);
    }

    public static void insertTextInElement (WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public static void numOfElements (List<WebElement> elems , int expectedValue)
    {
        assertEquals(elems.size(),expectedValue);
    }
}
