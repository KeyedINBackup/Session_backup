package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.*;

import config.constants;

public class ExcelUtilis {

	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFRow Row;
    private static XSSFCell Cell;

//This method is to set the File path and to open the Excel file
//Pass Excel Path and SheetName as Arguments to this method
public static void setExcelFile(String Path,String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
       }

//This method is to read the test data from the Excel Cell
//In this we are passing parameters/arguments as Row Num and Col Num
public static String getCellData(int RowNum, int ColNum) throws Exception{
	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      String CellData = Cell.getStringCellValue();
      return CellData;
	}

//This method is to get the row count used of the excel sheet
public static int getRowCount(String SheetName){
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number=ExcelWSheet.getLastRowNum()+1;
		return number;
	}

public static void PrintResult(String result, int Rownum, int colnum) throws Exception{
	try{
		Row=ExcelWSheet.getRow(Rownum);
		Cell=Row.getCell(colnum, Row.RETURN_BLANK_AS_NULL);
		if(Cell==null){
			Cell=Row.createCell(colnum);
			Cell.setCellValue(result);
		} else {
			Cell.setCellValue(result);
		}
	FileOutputStream out = new FileOutputStream(constants.Path_TestData);
	ExcelWBook.write(out);
	out.flush();
	out.close();
		
				
	}catch(Exception e){
		throw e;
	}
}





}
