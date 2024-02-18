import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatadrivenTest {
public ArrayList<String> getData(String testcaseName,String sheetName) throws IOException
{
	FileInputStream fis=new FileInputStream("C:\\Users\\vredd\\OneDrive\\Desktop\\DatadrivenTestSample.xlsx");
	ArrayList<String> alist=new ArrayList<String>();
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheetsCount = workbook.getNumberOfSheets();
	for(int i=0;i<sheetsCount;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			//Now our first requirement is to identify the Testcases column first by scanning entire row at the top as headers row we can say.
			Iterator<Row> Rows = sheet.iterator();
			//we reached to first row below
			Row firstRow = Rows.next();
			//we need to access cell by cell in a first row.
			Iterator<Cell> cell = firstRow.cellIterator();
			int k=0;
			int column = 0;
			while(cell.hasNext())
			{
				Cell cellValue = cell.next();
				if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					column=k;

				}
				k++;
			}
			System.out.println(column);
			while(Rows.hasNext())
			{
				Row row = Rows.next();
				if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					//Now we have to grab all the cell values inside of this purchase row
					Iterator<Cell> cells = row.cellIterator();
					while(cells.hasNext())
					{

						Cell cvalue = cells.next();
						if(cvalue.getCellTypeEnum()==CellType.STRING)
						{
						//moving the data into the arraylist.
						alist.add(cvalue.getStringCellValue());
						}
						else
						{
							alist.add(NumberToTextConverter.toText(cvalue.getNumericCellValue()));
						}
						
					}
				}
			}

		}
	}
	return alist;
}
	public static void main(String[] args) throws IOException {
		
	}
}