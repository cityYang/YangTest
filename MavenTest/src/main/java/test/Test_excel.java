package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;


public class Test_excel {
	
	public void Test_excel() throws IOException {
		HSSFWorkbook wb =new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("测试单元");
		FileOutputStream output = new FileOutputStream("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\Test_excel.xls");
		wb.write(output);
		output.flush();
		return;
	}
	public void Test_excel2() throws IOException{
		HSSFWorkbook wkb =new HSSFWorkbook();
	    HSSFSheet sheet =wkb.createSheet("成绩表");
		HSSFRow row1 = sheet.createRow(0);
	    HSSFCell cell = row1.createCell(0);
		
		cell.setCellValue("学生成绩一览表");
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,3));
	    HSSFRow row2 = sheet.createRow(2);
	            row2.createCell(0).setCellValue("姓名");
	            row2.createCell(1).setCellValue("班级");
	            row2.createCell(2).setCellValue("笔试成绩");
	    FileOutputStream output = new FileOutputStream("D:\\workroom\\TestMaven\\src\\main\\webapp\\XML\\Test_excel2.xls");
	    wkb.write(output);
		output.flush();
		return; 
	}
	public static void main(String args[]) throws IOException{
		Test_excel test = new Test_excel();
		test.Test_excel2();
	}
}
