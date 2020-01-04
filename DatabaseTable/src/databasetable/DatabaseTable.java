//Sabrina Turney
//February 28th 2019
//COP 2800 - Java
//Week Seven - Database Table.java
//This program goes further into the Java/Database project by creating a table
//once the user has connected to SQL.

package databasetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseTable {    
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createTable();
	}
    private static void createTable() throws Exception {
            
        try 
                {           
                Connection conn = getConnection();
                PreparedStatement tablecreate = conn.prepareStatement("CREATE TABLE dogtable (dognum INT(1) NOT NULL AUTO_INCREMENT, dogFirstName char(10), middleInitial char(4), lastName char(10), ownerName char(50), PRIMARY KEY(dognum))");
                
                tablecreate.executeUpdate();        
                }
		catch (Exception e){
			System.out.println(e);
		}
    finally
                {
                 System.out.println("Table Created and function completed.");
                }
        }


    public static Connection getConnection() throws Exception {
		
		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dogs";
			String user = "root";
			String passwd = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Successfully connected");
			return conn;
		
		}
		catch (Exception e){
			System.out.println(e);
		}
		return null;
		
    }
}