//Sabrina Turney
//February 28th 2019
//COP 2800 - Java
//Week Seven - Database Connection.java
//This program simply connects to the SQL Database through Java.

package JavaDatabasePackage;

//import statements using java.jar file
import java.sql.Connection;
import java.sql.DriverManager;

public class JavaDatabaseConnection {	
    
    //Start the connection process by generating a method
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
	}
	
	public static Connection getConnection() throws Exception {
		//We try to connect, if it fails, we have an exception given to us.
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/information_schema";
			String user = "root";
			String passwd = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Successfully connected to the information_schema database");
		}
		catch (Exception e){
			System.out.println(e);
		}
		return null;
		
	}

}
