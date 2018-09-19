package utils;

import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {


  public static void main(String[] args) {
    hamtaRader();
  }

  static String[][] testVarden() {
    String[][] testData = {{"a","b"},{"c","d"}};
    return testData;
  }

  public static void hamtaRader(){
    try(Workbook excelFil = WorkbookFactory.create(
        new File("./src/test/resources/excel-filer/testdata1.xlsx"),null,true)) {

      System.out.println("Excelfilen har " + excelFil.getNumberOfSheets() + " blad");

      Sheet excelBlad1 = excelFil.getSheet("Blad1");
      int forstaRaden = excelBlad1.getFirstRowNum();
      int sistaRaden = excelBlad1.getLastRowNum();

      for (int i = forstaRaden+1; i <= sistaRaden; i++) {
        Row rad = excelBlad1.getRow(i);
        for (int j = rad.getFirstCellNum(); j < rad.getLastCellNum(); j++) {
          System.out.print(rad.getCell(j));
          System.out.print("\t");
        }
        System.out.println("");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }







}
