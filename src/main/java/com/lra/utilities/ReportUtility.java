package com.lra.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.lra.restmodels.LraTransactionInfo;
import com.lra.restmodels.Response;

public class ReportUtility {
//	
//	
//	
//	     /** 
//	     * Connect to a sample database 
//	     */  
//	    public static Response dbQuery() {  
//	    	Response resp = new Response();
//	        Connection conn = null;  
//	        LraTransactionInfo reportsrec = new LraTransactionInfo();
//	        try {  
//	            // db parameters  
//	          //  String url = "jdbc:sqlite:/Users/iimokhai/Documents/projects/servicedb/sqlite.db";  
//	            // create a connection to the database  
//	          //  conn = DriverManager.getConnection(url);  
//	            conn = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
//	            System.out.println("Connection to SQLite has been established.");
//	            String sql = "SELECT * from LRA_SERVICE_ATTTENDIES_TBL";
//	      
//	            
//	            try (
//	                    Statement stmt  = conn.createStatement();
//	                    ResultSet rs    = stmt.executeQuery(sql)){
//	                   
//	                   // loop through the result set
//	                   while (rs.next()) {
//	                    
//	                       
//	                       reportsrec.setFirstName(rs.getString("FIRST_NAME"));
//	                       reportsrec.setLastName(rs.getString("LAST_NAME"));
//	                       reportsrec.setMiddleName(rs.getString("LAST_NAME"));
//	                       reportsrec.setEmail(rs.getString("EMAIL"));
//	                       reportsrec.setAddreess(rs.getString("ADDRESS"));
//	                       reportsrec.setSoc(rs.getString("SOC"));
//	                       reportsrec.setSeat(rs.getString("SEAT"));
//	                       reportsrec.setCount(rs.getString("COUNT"));
//	                       reportsrec.setService_Number(rs.getString("SERVICE_NUMBER"));
//	                       reportsrec.setChurchDate(rs.getDate("CHURCH_DATE"));
//	                       
//	                       resp.setData(reportsrec);
//	                   }
//	               } catch (SQLException e) {
//	                   System.out.println(e.getMessage());
//	               }
//	            
//	           
//	              
//	        } catch (SQLException e) {  
//	            System.out.println(e.getMessage());  
//	        } finally {  
//	            try {  
//	                if (conn != null) {  
//	                    conn.close();  
//	                }  
//	            } catch (SQLException ex) {  
//	                System.out.println(ex.getMessage());  
//	            }  
//	        }
//			return resp;  
//	    }  
//	    
//	    
//	  @Override
//	    public void runEOD() {
//	        Connection conn = null;
//	        CallableStatement stmt = null;
//	        try {
//	            conn = jndiDataSource.getConnection();
//	            stmt = conn.prepareCall("{call WAVES_SMARTTELLER_PKG.WAVES_ARCHIVE_REQUEST(?, ?, ?)}");
//
//	            stmt.setNull(1, Types.TIMESTAMP);
//	            stmt.registerOutParameter(2, Types.VARCHAR);
//	            stmt.registerOutParameter(3, Types.VARCHAR);
//	            stmt.execute();
//	            if(!"00".equals(stmt.getString(2)))
//	                LOGGER.error("EOD Error",  stmt.getString(3));
//	        } catch (Exception ex) {
//	            LOGGER.error("EOD Exception",  ex);
//	        } finally {
//	            try {
//	                if (stmt != null) {
//	                    stmt.close();
//	                }
//	            } catch (Exception ex) {
//	            }
//	            try {
//	                if (conn != null) {
//	                    conn.close();
//	                }
//	            } catch (Exception ex) {
//	            }
//	        }
//	    }``

}
