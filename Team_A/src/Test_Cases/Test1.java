package Test_Cases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\will9\\OneDrive\\Documents\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
    try {
      assertEquals("Select Action", driver.findElement(By.xpath("//h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  
  @Test
  public void testAddItem() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("1");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("1.50");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    try {
      assertEquals("Milk", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Fridge", driver.findElement(By.xpath("//td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1.50", driver.findElement(By.xpath("//td[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("View Inventory")).click();
    try {
      assertEquals("Milk", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Fridge", driver.findElement(By.xpath("//td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1.50", driver.findElement(By.xpath("//td[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testSearch() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Chocolate Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("2");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("3.00");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("5");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Pantry");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("1");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("1.50");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Search Inventory for Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("milk");
    driver.findElement(By.xpath("//input[@value='Search']")).click();
    try {
      assertEquals("Milk", driver.findElement(By.xpath("//tr[3]/td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Fridge", driver.findElement(By.xpath("//tr[3]/td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1.50", driver.findElement(By.xpath("//tr[3]/td[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Chocolate Milk", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("2", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("fridge", driver.findElement(By.xpath("//td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("3.00", driver.findElement(By.xpath("//td[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Chocolate Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Apples");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testUpdate() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Chocolate Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("2");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("3.00");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("5");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Pantry");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("1");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("1.50");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Update Item")).click();
    driver.findElement(By.name("itemName")).click();
    driver.findElement(By.name("itemName")).clear();
    driver.findElement(By.name("itemName")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("3");
    driver.findElement(By.xpath("//input[@value='Update']")).click();
    try {
      assertEquals("Apples", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("3", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Pantry", driver.findElement(By.xpath("//td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("5.00", driver.findElement(By.xpath("//td[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Chocolate Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("2");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("3.00");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("5");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Pantry");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("1");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("1.50");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Chocolate Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Apples");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testDelete() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Chocolate Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("2");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("3.00");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("5");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Pantry");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Milk");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("1");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Fridge");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("1.50");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Apples");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    try {
      assertEquals("Apples", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("5", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Pantry", driver.findElement(By.xpath("//td[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Chocolate Milk");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("View Inventory")).click();
    try {
      assertThat("//body", is(not(driver.findElement(By.tagName("BODY")).getText())));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
