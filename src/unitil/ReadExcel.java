/**
*lileilei
 * 2018年9月24日
* ReadExcel.java
 */
package unitil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	/*
	 * 从excle读取case的用例
	 */
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
     static LogNew logger_user=new LogNew();
    public static Object[][] getTableArray(String FilePath, String SheetName)  {   
        String[][]tabArray = null;
        try {
        	 FileInputStream ExcelFile = new FileInputStream(FilePath);
             ExcelWBook = new XSSFWorkbook(ExcelFile);
             ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int startCol = 1;
            int ci,cj = 0;
            int totalRows = ExcelWSheet.getLastRowNum();
            int totalC=ExcelWSheet.getRow(0).getLastCellNum();
            int totalCols = 2;
            int size=totalC-totalCols;
            tabArray=new String[totalRows][size];
            ci=0;
            cj=0;
            int cm = 0;int cl = 0;int ch = 0;
            for (int i=startRow ;i<=totalRows;i++, ci++) {
            		int m=2;
            		if (m<totalCols+1) {
            			for(int j=0;j<=size;j++) {
            			try {
        					tabArray[ci][j]=getCellData(i,m);
                            } catch (Exception e) {
                            	logger_user.error(e);
        					}
            			m++;
					}
            		
            	}
            }
             }
         catch (FileNotFoundException e){
        	 logger_user.error(e);
             }
         catch (IOException e){
        	 logger_user.error(e);
             }
         return(tabArray);
         }
     public static String getCellData(int RowNum, int ColNum)  {
    	 try{
             Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
             Cell.setCellType(Cell.CELL_TYPE_STRING);
             int dataType = Cell.getCellType();
             if  (dataType == 3) {
                 return "";
             }
             else{
                 String CellData = Cell.getStringCellValue();
                 return CellData;
             }
         }
             catch (Exception e){
             throw (e);
             }
         }
}
