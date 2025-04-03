package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\sarat\\eclipse-workspace\\OpenCart\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtilities xcel = new ExcelUtilities(path);
		
		int totalrows = xcel.getRowCount("sheet1");
		int totalcol = xcel.getCellCount("sheet1", 1);
		
		String data[][] = new String[totalrows][totalcol];
		
		for(int i=1; i<=totalrows; i++) {
			for(int j=0;j<totalcol;j++)  //0    i is rows j is col
			{
				data[i-1][j]= xcel.getCellData("Sheet1",i, j);  //1,0
			}

		}
		return data;
		
	}

}
