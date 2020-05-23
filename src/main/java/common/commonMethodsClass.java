package common;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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

/*    public static void  initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        driver.manage().window().maximize();
        driver.get(getData("url"));
        String timeout = getData("TimeOut");
        Long parsedTimeout = Long.parseLong(timeout);
        driver.manage().timeouts().implicitlyWait(parsedTimeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }*/


}
