package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\opencart_login_data.xlsx"; //taking the xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //created for two dimensional array
		 
		for(int i=1; i<=totalrows; i++) //1	//read the data from xl storing in two dimensional array (we ignore header part)
		{
			for(int j=0; j<totalcols; j++) //0 i for rows, j for columns
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //1,0 (minus one because array index starts from zero!)
			}
		}
		
		return logindata; //returning two dimensional array
	}
	
	
}
