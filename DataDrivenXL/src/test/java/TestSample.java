import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
public static void main(String[] args) throws IOException {
	DatadrivenTest t=new DatadrivenTest();
	ArrayList<String> actualData = t.getData("Addprofile");
	System.out.println(actualData.get(0));
	System.out.println(actualData.get(1));
	System.out.println(actualData.get(2));
	//driver.findelement(By.xapth("//a/img")).sendkeys(actualData.get(0));
}
}
