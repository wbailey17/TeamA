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
  
  @Test
  public void testDuplicateItem() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
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
    driver.findElement(By.name("cost")).sendKeys("3.00");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Item")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Apples");
    driver.findElement(By.name("quantity")).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("6");
    driver.findElement(By.name("storage")).click();
    driver.findElement(By.name("storage")).clear();
    driver.findElement(By.name("storage")).sendKeys("Pantry");
    driver.findElement(By.name("cost")).click();
    driver.findElement(By.name("cost")).clear();
    driver.findElement(By.name("cost")).sendKeys("5");
    driver.findElement(By.xpath("//input[@value='Add']")).click();
    try {
      assertEquals("Item Already Exists", driver.findElement(By.xpath("//h2")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Item")).click();
    driver.findElement(By.name("item")).click();
    driver.findElement(By.name("item")).clear();
    driver.findElement(By.name("item")).sendKeys("Apples");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testAddExpense() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test");
    driver.findElement(By.xpath("//form[@action='AddExpense']")).click();
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("1000");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    try {
      assertEquals("test , 1000.00", driver.findElement(By.xpath("//p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testUpdateExpense() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test1");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("40.00");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Update Expense")).click();
    driver.findElement(By.name("expenseName")).click();
    driver.findElement(By.name("expenseName")).clear();
    driver.findElement(By.name("expenseName")).sendKeys("test1");
    driver.findElement(By.name("newName")).click();
    driver.findElement(By.name("newName")).clear();
    driver.findElement(By.name("newName")).sendKeys("test2");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("100");
    driver.findElement(By.xpath("//input[@value='Update']")).click();
    try {
      assertEquals("test2 , 100.00", driver.findElement(By.xpath("//p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("View Budget")).click();
    try {
      assertEquals("test2", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("100.00", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test2");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
  }
  
  @Test
  public void testRemoveExpense() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test1");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("1000");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test2");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("10.0");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense3");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("200");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test2");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    try {
      assertEquals("test2 , 10.00", driver.findElement(By.xpath("//p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("View Budget")).click();
    try {
      assertEquals("test1", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("1000.00", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Expense3", driver.findElement(By.xpath("//tr[3]/td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("200.00", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("test1");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense3");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
  }
  
  @Test
  public void testViewBudget() throws Exception {
    driver.get("http://ec2-3-17-56-105.us-east-2.compute.amazonaws.com:8080/Team_A/User_Login.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("testuser");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense1");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("10");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense2");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("72.33");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Add Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense3");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("4200.01");
    driver.findElement(By.xpath("//input[@value='create']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("View Budget")).click();
    try {
      assertEquals("Budget", driver.findElement(By.xpath("//h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Budget: Test User, Income: 10000.00", driver.findElement(By.xpath("//p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Expense1", driver.findElement(By.xpath("//td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("10.00", driver.findElement(By.xpath("//td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("72.33", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Expense3", driver.findElement(By.xpath("//tr[4]/td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("4200.01", driver.findElement(By.xpath("//tr[4]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Total Expense: 4282.34", driver.findElement(By.xpath("//p[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Remaining Income: 5717.66", driver.findElement(By.xpath("//p[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense1");
    driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense2");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Remove Expense")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Expense3");
    driver.findElement(By.xpath("//input[@value='Remove']")).click();
    driver.findElement(By.linkText("Home")).click();
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
