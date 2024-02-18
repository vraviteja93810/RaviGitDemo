import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//Click on column
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		
		//capture all the webelements
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text of all webelemens into new (original) list
		List<String> OriginalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//now we need to perform the sorting on it and take the elements into another new list.
		List<String> SortedList = OriginalList.stream().sorted().collect(Collectors.toList());
		
		//Now comparing the original list with actual list.
		Assert.assertTrue(OriginalList.equals(SortedList));
		
		
		//To get the price of the vegetables.
		//Scan the name column with get text.
		//When getText() return the price as text then we are asking to get the price of that Beans.
		List<String> Price;
		do
		{
			//This below line we write to freshly take the next page elements again and again if we find in new page.
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		 Price = rows.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		//If that desired element is not available in 1st page.
		Price.forEach(s->System.out.println(s));
		if(Price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(Price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		
		String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return PriceValue;
	}
}