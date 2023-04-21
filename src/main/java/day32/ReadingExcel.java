package day32;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
--------
Data Driven testing
--------------
Excel

Apache poi - API used for automating ms documents- excel.

reading data from excel
writing data into excel


https://mvnrepository.com/artifact/org.apache.poi/poi/5.2.3
https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/5.2.3


Excel File-->Workbook-->Sheets---->Rows--->Cells

FileInputStream
FileOutputStream

XSSFWorkbook
XSSFSheet
XSSFRow
XSSFCell

 */
public class ReadingExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/testdata/data.xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook(file);

        //workbook.getSheet("Sheet1");
        //workbook.getSheetAt(0); //Sheet 1 (index of the sheet)
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        int totalrows=sheet.getLastRowNum(); //last number of rows, total

        int totalcells=sheet.getRow(1).getLastCellNum(); //total number of columns

        System.out.println("Number of rows:  "+totalrows);  //5 counted from 0, so its 6
        System.out.println("Number of cells:  "+totalcells);  //4 counted from 1

        for(int r=0;r<=totalrows;r++)
        {
            XSSFRow currentRow=sheet.getRow(r);

            for(int c=0;c<totalcells;c++)
            {
                //XSSFCell cell=currentRow.getCell(c);
                //String value=cell.toString();
                String value=currentRow.getCell(c).toString();
                System.out.print(value+"      ");
            }
            System.out.println();
        }

        workbook.close();
        file.close();



    }

}
