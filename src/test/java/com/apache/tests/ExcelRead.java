package com.apache.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excelFile() throws IOException {
        String path = "SampleData.xlsx";
        //to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook>sheet>row>cell

        // 1 create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // we need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // 3 select row and cell
        //print out Mary's cell
        // Indexes start from 0
        System.out.println("firstname: "+sheet.getRow(1).getCell(0));
        System.out.println("lastname:  "+sheet.getRow(1).getCell(1));


        //TODO: Create a logic to find specific element in excel

        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: create a logic to find Linda's Job_ID
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Linda")){
                System.out.println("job: "+sheet.getRow(i).getCell(2));
            }

        }



    }

}
