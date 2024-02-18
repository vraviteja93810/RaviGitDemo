import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DisabledElementsHandling {
public static void main(String[] args) throws InterruptedException {

	//System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//-->//a[@value='BLR'] --> this is from location city
//-->//a[@value='MAA'] --> xpath for chennei 
// -->(//a[@value='MAA'])[2]
Thread.sleep(2000);
/*driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
driver.findElement(By.xpath("//a[@value='BLR']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
*/


//System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled());
System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
{
	System.out.println("It is enabled.");
	Assert.assertTrue(true); //-->here directly we pass true. 
}
else
{
	//Here we just simply passed false to the assertTrue(false).
	//if we pass the false here to true assertion, then it fail our test.
	Assert.assertTrue(false);
}

}
}
