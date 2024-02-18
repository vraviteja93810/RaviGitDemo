package RavitejaAcademy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestDemo {
@Test
public void titleCheck() throws MalformedURLException
{
	
	WebDriver driver=new RemoteWebDriver(new URL("https://www.bstackdemo.com"), null);
}
}
