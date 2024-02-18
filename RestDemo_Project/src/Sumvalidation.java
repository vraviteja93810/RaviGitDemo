import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {
	int Allprices=0;
	int wholeCost=0;
@Test
public void SumOfCourses()
{
	JsonPath js=new JsonPath(Payload.CoursePrice());
	//print number of courses returned by API.
	int size=js.getInt("courses.size()");
	
	for(int i=0;i<size;i++)
	{
		int prices=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		wholeCost=prices*copies;
		Allprices=Allprices+wholeCost;
}
	System.out.println(Allprices);
	Assert.assertEquals(Allprices,js.getInt("dashboard.purchaseAmount"));
}
}