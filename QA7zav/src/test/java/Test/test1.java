package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test1 {
    WebDriver driver;

    private final String srchInp = "//input";
    private final String srchprod = "//span[@class=\"goods-tile__title\"]";
    private String proText;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }
    @Test
    public void newtest()
    {
        WebElement srchElem = driver.findElement(By.xpath(srchInp));
        srchElem.clear();
        srchElem.sendKeys("Монитор\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement srchElem1 = driver.findElement(By.xpath(srchprod));
        proText = srchElem1.getText();
        Assert.assertTrue(proText.contains("Mонитор"), "Not contain");
    }
    @AfterMethod
    public void quitBrowser()
    {
        driver.quit();
    }
}
