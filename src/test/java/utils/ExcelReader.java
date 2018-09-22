package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.params.provider.Arguments;

public class ExcelReader {


  public static void main(String[] args) {
    getTestDataStreamFromExcelFile("./src/test/resources/excel-filer/testdata2.xlsx",
        "Sheet1");

  }

  /**
   * A method that returns test data intended to be uses in parameterized test.
   * @return a 2d-array containing test data.
   */
  static Stream<Arguments> testValues1() {
    return getTestDataStreamFromExcelFile("./src/test/resources/excel-filer/testdata2.xlsx",
        "Sheet1");
  }


  /**
   * Method that searches through a given sheet in an Excel-file and returns the data
   * @param excelFullPath full path to excel-file including file name.
   * @param sheetName the name of the sheet where to extract data.
   * @return test data as Stream&lt;Arguments&gt;
   */
  public static Stream<Arguments> getTestDataStreamFromExcelFile(String excelFullPath,
      String sheetName){
    Stream<Arguments> returnStream = Stream.empty();
    DataFormatter myDataFormatter = new DataFormatter();

    try(Workbook excelFile = WorkbookFactory.create(new File(excelFullPath),null,true)) {
      Sheet excelSheet1 = excelFile.getSheet(sheetName);

      for(Row row: excelSheet1){
        if(row.getRowNum()==0) {continue;}
        ArrayList<Object> rowArrayList = new ArrayList<>();
        for (Cell cell : row) {
          rowArrayList.add(myDataFormatter.formatCellValue(cell));
        }
        Arguments arguments = Arguments.of(rowArrayList.toArray());
        returnStream = Stream.concat(returnStream,Stream.of(arguments));
      }
    return returnStream;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return returnStream;
  }


  /**
   * A method that returns test data intended to be uses in parameterized test.
   * @return a 2d-array containing test data.
   */
  static String[][] testValues2() {
    return getTestData2dArrayFromExcelFile("./src/test/resources/excel-filer/testdata2.xlsx",
        "Sheet1");
  }


  /**
   * Method that searches through a given sheet in an Excel-file and returns the data
   * @param excelFullPath full path to excel-file including file name.
   * @param sheetName the name of the sheet where to extract data.
   * @return String[][] containing the data
   */
  public static String[][] getTestData2dArrayFromExcelFile(String excelFullPath, String sheetName){
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
