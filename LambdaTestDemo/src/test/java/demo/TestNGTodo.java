package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTodo{
	public String username = "raviteja2094";
    public String accesskey = "X5Ji45AHqvAaLFCQXPRpbrsFC0rj7XPAfFgP361o1TsuYFgYm4";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false; 
    @BeforeClass
    public void setUp() throws Exception {
    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 10");
    	browserOptions.setBrowserVersion("121.0");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "raviteja2094");
    	ltOptions.put("accessKey", "X5Ji45AHqvAaLFCQXPRpbrsFC0rj7XPAfFgP361o1TsuYFgYm4");
    	ltOptions.put("project", "Untitled");
    	ltOptions.put("w3c", true);
    	ltOptions.put("plugin", "java-testNG");
    	browserOptions.setCapability("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testSimple() throws Exception {
       try {//Change it to production page
            driver.get("https://lambdatest.github.io/sample-todo-app/");
              //Let's mark done first two items in the list.
              driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();
             // Let's add an item in the list.
              driver.findElement(By.id("sampletodotext")).sendKeys("Yes, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();
              // Let's check that the item we added is added in the list.
            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
            if (enteredText.equals("Yes, Let's add it to list")) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
    @Test
    public void testUntitledTestCase() throws Exception {
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      driver.findElement(By.name("username")).click();
      driver.findElement(By.name("username")).clear();
      driver.findElement(By.name("username")).sendKeys("admin");
      driver.findElement(By.name("password")).click();
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys("admin123");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
      driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li/a/span")).click();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
      driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span")).click();
      driver.findElement(By.linkText("Logout")).click();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    }
