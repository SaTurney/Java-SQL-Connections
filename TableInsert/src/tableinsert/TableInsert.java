//Sabrina Turney
//February 28th 2019
//COP 2800 - Java
//Week Seven - Database TableInsert.java
//This program goes further into the Java/Database project by allowing the user
//from Java to insert values into the SQL table.

package tableinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TableInsert {
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        post();
        
    }
    public static void post() throws Exception 
    {
        try
        {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO dogtable " + 
                    "VALUES (1, 'Peapod', 'P.', 'Ross', 'Bob Ross')");
            st.executeUpdate("INSERT INTO dogtable " + 
                    "VALUES (2, 'Edwin', 'E.', 'Hilf', 'Tom Hilf')");
            st.executeUpdate("INSERT INTO dogtable " + 
                    "VALUES (3, 'Kiwi', 'T.', 'Turney', 'Sabrina Turney')");
            st.executeUpdate("INSERT INTO dogtable " + 
                    "VALUES (4, 'Lily', 'L.', 'Estrada', 'Toni Estrada')");
            st.executeUpdate("INSERT INTO dogtable " + 
                    "VALUES (5, 'Ziggy', 'S.', 'Gilstad', 'Leslie Gilstad')");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Insertion of values successful!");
        }
    }
    private static void createTable() throws Exception {
		// TODO Auto-generated method stub
		createTable();
            
        try 
                {           
                Connection conn = getConnection();
                PreparedStatement tablecreate = conn.prepareStatement("Create table dogtable (dogID char(1), dogFirstName char(10), middleInitial char(4), lastName char(10), ownerName char(50), PRIMARY KEY(dogID))");
                
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
			System.out.println("Successfully connected.");
			return conn;
		
		}
		catch (Exception e){
			System.out.println(e);
		}
		return null;
		
    }
}
