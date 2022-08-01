package com.apache.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    String filePath = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(10);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(20);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(30);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(40);

        //TODO: Change Mary's lastname to Snow
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Mary")){
                //XSSFCell lastnameMarry = sheet.getRow(i).createCell(1);
                //lastnameMarry.setCellValue("Snow");
                sheet.getRow(i).getCell(1).setCellValue("Snow2");
            }
        }





        //save changes
        // open to write to the file : FileInputStream --> reading
        // save changes              : FileOutputStream --> writing

        FileOutputStream outputStream = new FileOutputStream(filePath);

        //save/write changes to the workbook
        workbook.write(outputStream);

        //close all
        outputStream.close();
        workbook.close();
        fileInputStream.close();


    }
}