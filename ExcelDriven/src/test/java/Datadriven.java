import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> al=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\DataDriven.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//now we need to reach out to only particular sheet.
		int Sheets = workbook.getNumberOfSheets();
		for(int i=0;i<Sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				//we selected the particular sheet.
			 XSSFSheet SheetName = workbook.getSheetAt(i);
			 //identify testcase column by scanning the entire 1st row.
			  Iterator<Row> rows = SheetName.iterator();
			  Row firstRow = rows.next();//now the control reach at first row.
			  //now we need match the column name in that first row which is having name as test case.
			  //for that we need to check each and every cell to match the column name.
			  Iterator<Cell> cell = firstRow.cellIterator();
			  int k=0;
			  int column=0;
			  while(cell.hasNext())
			  {
				  Cell value = cell.next();
				  if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				  {
					 column=k;
				  }
				  k++;
			  }
			  System.out.println(column);
			  //Once column identified then scan entire testcase column to identify purchase testcase row.
			  while(rows.hasNext())
			  {
				Row Rows = rows.next();  
				//here we are fetching the cell address from 0th index of every row and column.
				if(Rows.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					//Now pull all the data of that row
					Iterator<Cell> Cells = Rows.cellIterator();
					while(Cells.hasNext())
					{
						
//						if(CellValues.getCellType()==CellType.STRING)
//						{
//						al.add(CellValues.getStringCellValue());
//						}
//						else
//						{
//							al.add(NumberToTextConverter.toText(CellValues.getNumericCellValue()));
//							
//						}
//
						DataFormatter formatter = new DataFormatter();
					     String text = formatter.formatCellValue(Cells.next());
					     al.add(text);	
					     
					}
				}
				//why because here TestCases column present at 0th index.
				
			  }
			  
			  
			}
			return al;
		}
		return al;	
	}
	public static void main(String[] args) throws IOException {
		
	}
}
