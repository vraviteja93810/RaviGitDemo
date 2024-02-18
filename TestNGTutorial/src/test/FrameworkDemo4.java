package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrameworkDemo4 {
@Test(groups = "smoke")
public void webLoginHomeLoan()
{
	//webLogin 
	System.out.println("WebLoginHomeLoan");
}


@Test(dataProvider="getData")
public void mobileLoginCarLoan(String username, String password)
{
   // mobile Login	
	System.out.println("mobileLoginCarLoan");
	System.out.println(username+" "+password);
	System.out.println();
}



@Test(timeOut = 4000)
public void apiLogin()
{
	System.out.println("apiLogin");
	//Api Login
}
@BeforeMethod
public void beforeMethod()
{
	System.out.println("I will execute before every method");
}
@AfterMethod
public void afterMethod()
{
	System.out.println("I will execute after every method");
}

@DataProvider
public Object[][] getData()
{
	//suppose this method needs three sets of data combination.
	//1st combination is with username and password
	//2nd combination is with
	
	Object[][] data=new Object[3][2];
	//First set
	data[0][0]="FirstSetUsername"; //--> here we wrote 1st column, 1st row, 1st cell.
	data[0][1]="password";//--> Here we wrote 1st column, 1st row, 2nd cell.
	
	//2nd set of data
	data[1][0]="secondSetUsername";
	data[1][1]="secondpassword";
	
	//3rd set of data
	data[2][0]="thirdSetUsername";
	data[2][1]="thirdPassword";
	return data;
}
}
