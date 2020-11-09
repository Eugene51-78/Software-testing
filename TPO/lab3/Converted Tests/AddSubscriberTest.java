// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AddSubscriberTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addSubscriber() {
    // Test name: Add Subscriber
    // Step # | name | target | value | comment
    // 1 | open | https://us2.admin.mailchimp.com/lists/designer/?id=971650 |  | 
    driver.get("https://us2.admin.mailchimp.com/lists/designer/?id=971650");
    // 2 | selectFrame | index=1 |  | 
    driver.switchTo().frame(1);
    // 3 | selectFrame | index=0 |  | 
    driver.switchTo().frame(0);
    // 4 | click | xpath=//input[@name='submit'] |  | 
    driver.findElement(By.xpath("//input[@name=\'submit\']")).click();
    // 5 | click | xpath=//div/div/input |  | 
    driver.findElement(By.xpath("//div/div/input")).click();
    // 6 | type | xpath=//div/div/input | evgeny.chernousov2013@gmail.com | 
    driver.findElement(By.xpath("//div/div/input")).sendKeys("evgeny.chernousov2013@gmail.com");
    // 7 | click | xpath=//div[2]/div/input |  | 
    driver.findElement(By.xpath("//div[2]/div/input")).click();
    // 8 | type | xpath=//div[2]/div/input | Evgen | 
    driver.findElement(By.xpath("//div[2]/div/input")).sendKeys("Evgen");
    // 9 | click | xpath=//div[3]/div/input |  | 
    driver.findElement(By.xpath("//div[3]/div/input")).click();
    // 10 | type | xpath=//div[3]/div/input | Chernousov | 
    driver.findElement(By.xpath("//div[3]/div/input")).sendKeys("Chernousov");
    // 11 | click | xpath=//div[4]/div/input |  | 
    driver.findElement(By.xpath("//div[4]/div/input")).click();
    // 12 | type | xpath=//div[4]/div/input | 89217777777 | 
    driver.findElement(By.xpath("//div[4]/div/input")).sendKeys("89217777777");
    // 13 | click | xpath=//div[3]/input |  | 
    driver.findElement(By.xpath("//div[3]/input")).click();
    // 14 | pause | 5000 |  | 
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 15 | click | id=templateBody |  | 
    driver.findElement(By.id("templateBody")).click();
    // 16 | assertText | xpath=//div[2]/div/div/div/div | Recipient "evgeny.chernousov2013@gmail.com" has too many recent signup requests | 
    assertThat(driver.findElement(By.xpath("//div[2]/div/div/div/div")).getText(), is("Recipient \\\"evgeny.chernousov2013@gmail.com\\\" has too many recent signup requests"));
    // 17 | close |  |  | 
    driver.close();
  }
}