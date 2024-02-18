package datadrivendemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
@DataProvider(name="driverTest")
public Object[][] getData() throws IOException
{
	DataFormatter df=new DataFormatter();
	//Object[][] data= {{"hellow","Hi",1},{"how","are",2},{"you","are",3}};
	FileInputStream fis=new FileInputStream("C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\DataDriven.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet Sheet = workbook.getSheetAt(0);
	//To know number of rows
	int rowCount=Sheet.getPhysicalNumberOfRows();
	XSSFRow row = Sheet.getRow(0);
	//now we are fetching the last cell number. indirectly we are taking column count.
	int colCount = row.getLastCellNum();
	Object[][] data= new Object[rowCount-1][colCount];
	for(int i=0;i<rowCount-1;i++)//to fetch rows
		
	{
		//it will take the 1st index row
		row=Sheet.getRow(i+1);
		for(int j=0;j<colCount;j++)//to fetch columns
			
		{
			XSSFCell cell=row.getCell(j);
		    data[i][j]=df.formatCellValue(cell);
		}
		
	}
	
	return data;
}

@Test(dataProvider = "driverTest")
public void testCaseData(String value1, String value2, String value3, String value4)
{
	System.out.println(value1+"  "+value2+" "+value3+""+value4);
	
}
}
