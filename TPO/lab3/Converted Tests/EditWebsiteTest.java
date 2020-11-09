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
public class EditWebsiteTest {
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
  public void editWebsite() {
    driver.get("https://us2.admin.mailchimp.com/websites/start-your-site/");
    driver.findElement(By.linkText("Edit Site")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Add Page\')]")).click();
    driver.findElement(By.xpath("//input")).click();
    driver.findElement(By.xpath("//input")).sendKeys("Home Test");
    driver.findElement(By.xpath("//button[contains(.,\'Add\')]")).click();
    assertThat(driver.findElement(By.xpath("//div[2]/div/div/span")).getText(), is("Something went wrong"));
    driver.findElement(By.xpath("//span[contains(.,\'Cancel\')]")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Styles\')]")).click();
    driver.findElement(By.xpath("//div[2]/div/div[3]")).click();
    driver.findElement(By.xpath("//span[contains(.,\'Publish\')]")).click();
    assertThat(driver.findElement(By.xpath("//h1")).getText(), is("Nice work! Publish to share your website online!"));
    driver.findElement(By.xpath("//button[contains(.,\'Update site tracking\')]")).click();
    driver.findElement(By.xpath("//form/div[2]/div/div/button")).click();
    driver.findElement(By.xpath("//div[2]/div[4]/div/button")).click();
    driver.findElement(By.xpath("//button[contains(.,\'Save\')]")).click();
    driver.findElement(By.xpath("//section/div[2]/div")).click();
    assertThat(driver.findElement(By.xpath("//h4/span")).getText(), is("You\\\'ve enabled Mailchimp Tracking and Google Ads Restricted Data Processing."));
    driver.findElement(By.xpath("//button[contains(.,\'Update site tracking\')]")).click();
    driver.findElement(By.xpath("//form/div[2]/div/div/button")).click();
    driver.findElement(By.xpath("//div[2]/div[4]/div/button")).click();
    driver.findElement(By.xpath("//button[contains(.,\'Save\')]")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 3);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,\'Get more data about your visitors and subscribers, or use Google and Facebook for deeper insights.\')]")));
    }
    driver.close();
  }
}