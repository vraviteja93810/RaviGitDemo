package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
public void switchWinodwToChild()
{
	Set<String> allWindows = driver.getWindowHandles();
	Iterator<String> windows = allWindows.iterator();
	String parentWindow = windows.next();
    String childwindow = windows.next();
    driver.switchTo().window(childwindow);
}
}
