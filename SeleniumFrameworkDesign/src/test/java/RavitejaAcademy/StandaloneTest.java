package RavitejaAcademy;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ravitejaacademy.pageobjects.Landingpage;

public class StandaloneTest {
public static void main(String[] args) {
	//Here we are going to use webdrivermanager.
	String productName="ZARA COAT 3";
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client");
	
	//login details with mail and password.
	driver.findElement(By.id("userEmail")).sendKeys("raviteja@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Vraviteja@12345");
	driver.findElement(By.name("login")).click();
	
	
	
	//Grab all the products to the list.
	//Below logic is one way to do using for loop.
	/*
	 List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	for(int i=0;i<products.size();i++) {
		String ProductNames = products.get(i).getText();
		if(ProductNames.contains("ADIDAS ORIGINAL"))
		{
			driver.findElements(By.cssSelector(".btn.w-10.rounded")).get(i).click();
			break;
		}
	} */
	
	//We build same above requirement by using java streams.
	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	WebElement ActualProd = products.stream().filter(product->
	product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	//Now we need to click on add to button by using sub driver.
	ActualProd.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	//waiting for confirmation message like product added successfully and wait for element disappear.
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
	//Below method also we can use.
	//But here we need to pass entire webelement address.
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
	
	//clicking on add to cart.
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	//fetching all the product names available inside of cart page to see all addedd products are available or not.
	List<WebElement> CartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	boolean match = CartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
	//Here above stream i have given a separate local variable called cartproduct in stream.
	//Here i am not taking cartProducts name.
	//In the place of streams variable we can take any variable that is our choice.
	
	//Here we  have used anyMatch method instead of filter. 
	//Now this anymatch will match the elements one by one. if any match found then it reuturn true.
	//that true we have stored inside of above match element.
	Assert.assertTrue(match); //--> Here we are sending that match variable.
	//here if this match variable having the value true then our test will pass.
	
	//clicking on checkout button.
	driver.findElement(By.cssSelector(".totalRow button")).click();
	//Entering country name and selecting the name of country from auto suggestive dropdown.
	Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india").build().perform();
	//here we are waiting explicitly
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item:nth-of-type(2)")));
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
    //click on place order.
	driver.findElement(By.cssSelector(".btnn")).click();
	String Confirm_Message = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(Confirm_Message.equalsIgnoreCase("Thankyou for the order."));
	System.out.println("welcome");
	System.out.println("Hellow");
	System.out.println("HI");
	driver.quit();
	
}
}