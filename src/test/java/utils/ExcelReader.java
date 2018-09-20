package utils;

import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {


  public static void main(String[] args) {
    getTestDataFromExcelFile("./src/test/resources/excel-filer/testdata2.xlsx",
        "Sheet1");
  }

  /**
   * A method that returns test data intended to be uses in parameterized test.
   * @return a 2d-array containing test data.
   */
  static String[][] testValues() {
    return getTestDataFromExcelFile("./src/test/resources/excel-filer/testdata2.xlsx",
        "Sheet1");
  }


  /**
   * Method that searches through a given sheet in an Excel-file and returns the data
   * @param excelFullPath full path to excel-file including file name.
   * @param sheetName the name of the sheet where to extract data.
   * @return String[][] containing the data
   */
  public static String[][] getTestDataFromExcelFile(String excelFullPath, String sheetName){
    DataFormatter myDataFormatter = new DataFormatter();

    try(Workbook excelFile = WorkbookFactory.create(
        new File(excelFullPath),null,true)) {

      Sheet excelSheet1 = excelFile.getSheet(sheetName);
      int firstRow = excelSheet1.getFirstRowNum();
      int lastRow = excelSheet1.getLastRowNum();
      String[][] testData2dArray = new String[lastRow][];

      //skipping the title row in the sheet
      for (int i = firstRow+1; i <= lastRow; i++) {
        Row row = excelSheet1.getRow(i);
        int firstCellNum = row.getFirstCellNum();
        int lastCellNum = row.getLastCellNum();
        String[] testDataArray = new String[lastCellNum];

        for (int j = firstCellNum; j < lastCellNum; j++) {
          testDataArray[j]=myDataFormatter.formatCellValue(row.getCell(j));
        }
        testData2dArray[i-1]=testDataArray;
      }
      return testData2dArray;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }







}
