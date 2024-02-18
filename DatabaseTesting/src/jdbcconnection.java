import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {
public static void main(String[] args) throws SQLException, InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	String localhost="localhost";
	String port="3306";
	//Here we created a connection
	Connection con=DriverManager.getConnection("jdbc:mysql://"+localhost+":"+port+"/QAdbt" ,"root", "tiger");
	//here with connection we need to create a statement and stored into one object with statement reference.
	Statement st= con.createStatement();
	ResultSet result = st.executeQuery("select * from Empcredentials where scenario='ZerobalanceCard';");
	WebDriver driver= new ChromeDriver();
	driver.get("https://login.salesforce.com");
	while(result.next())
	{
		driver.findElement(By.id("username")).sendKeys(result.getString("username"));
		driver.findElement(By.id("password")).sendKeys(result.getString("password"));
	}
	
	
}
}
