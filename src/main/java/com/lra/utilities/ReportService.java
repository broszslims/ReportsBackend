package com.lra.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lra.restmodels.LraTransactionInfo;
import com.lra.restmodels.Response;

@Service
public class ReportService {
	  @Autowired
	    ReportUtility rptUtility;
	   


	    
	
	    
	    
	   
	     
	    public void export() {
	        String jdbcURL = "jdbc:mysql://localhost:3306/sales";
	        String username = "root";
	        String password = "password";
	 
	        String excelFilePath = "Reviews-export.xlsx";
	 
	        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
	            String sql = "SELECT * FROM review";
	 
	            Statement statement = connection.createStatement();
	 
	            ResultSet result = statement.executeQuery(sql);
	 
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            XSSFSheet sheet = workbook.createSheet("Reviews");
	 
	            writeHeaderLine(sheet);
	 
	            writeDataLines(result, workbook, sheet);
	 
	            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
	            workbook.write(outputStream);
	          
	 
	            statement.close();
	 
	        } catch (SQLException e) {
	            System.out.println("Datababse error:");
	            e.printStackTrace();
	        } catch (IOException e) {
	            System.out.println("File IO error:");
	            e.printStackTrace();
	        }
	    }
	 
	    private void writeHeaderLine(XSSFSheet sheet) {
	 
	        Row headerRow = sheet.createRow(0);
	 
	        Cell headerCell = headerRow.createCell(0);
	        headerCell.setCellValue("Course Name");
	 
	        headerCell = headerRow.createCell(1);
	        headerCell.setCellValue("Student Name");
	 
	        headerCell = headerRow.createCell(2);
	        headerCell.setCellValue("Timestamp");
	 
	        headerCell = headerRow.createCell(3);
	        headerCell.setCellValue("Rating");
	 
	        headerCell = headerRow.createCell(4);
	        headerCell.setCellValue("Comment");
	    }
	 
	    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
	            XSSFSheet sheet) throws SQLException {
	        int rowCount = 1;
	 
	        while (result.next()) {
	            String courseName = result.getString("course_name");
	            String studentName = result.getString("student_name");
	            float rating = result.getFloat("rating");
	            Timestamp timestamp = result.getTimestamp("timestamp");
	            String comment = result.getString("comment");
	 
	            Row row = sheet.createRow(rowCount++);
	 
	            int columnCount = 0;
	            Cell cell = row.createCell(columnCount++);
	            cell.setCellValue(courseName);
	 
	            cell = row.createCell(columnCount++);
	            cell.setCellValue(studentName);
	 
	            cell = row.createCell(columnCount++);
	 
	            CellStyle cellStyle = workbook.createCellStyle();
	            CreationHelper creationHelper = workbook.getCreationHelper();
	            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
	            cell.setCellStyle(cellStyle);
	 
	            cell.setCellValue(timestamp);
	 
	            cell = row.createCell(columnCount++);
	            cell.setCellValue(rating);
	 
	            cell = row.createCell(columnCount);
	            cell.setCellValue(comment);
	 
	        }
	    }
}



