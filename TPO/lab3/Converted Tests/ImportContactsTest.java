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
public class ImportContactsTest {
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
  public void importContacts() {
    driver.get("https://us2.admin.mailchimp.com/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.xpath("//button[contains(.,\'Add Contacts\')]")).click();
    driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    driver.findElement(By.xpath("//p[contains(.,\'Browse\')]")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      WebElement element = driver.findElement(By.xpath("//p[contains(.,\'Browse\')]"));
      wait.until(ExpectedConditions.stalenessOf(element));
    }
    driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    driver.findElement(By.xpath("//input[@id=\'mc:43\']")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Continue to Tag\')]")).click();
    driver.findElement(By.xpath("//input")).click();
    driver.findElement(By.xpath("//input")).sendKeys("Staff");
    driver.findElement(By.xpath("//div[20]/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Continue To Match\')]")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Finalize Import\')]")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Complete Import\')]")).click();
    assertThat(driver.findElement(By.xpath("//h2[contains(.,\'Your import was successful\')]")).getText(), is("Your import was successful"));
    driver.findElement(By.linkText("View Contacts")).click();
    driver.close();
  }
}
