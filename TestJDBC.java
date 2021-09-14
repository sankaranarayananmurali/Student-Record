package edubridge.jswing.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Driver loaded Successfully");
			
			/*Class.forName("edubridge.jdbcDemos.Test");
			System.out.println("Object done");*/
			
			//establish connection
			//jdbc:mysql://server-name:server-port/database-name
			//"jdbc:mysql://localhost:3306/empdemo?characterEncoding=utf8"
			String db_url="jdbc:mysql://127.0.0.1:3306/batch5723?characterEncoding=utf8";
			Connection con=DriverManager.getConnection(db_url,"root","Environment@365");
			
			System.out.println("2.Connected with SQL");
			
			
			Statement stmt=con.createStatement();
			
			String sqlQuery="CREATE TABLE student ( Id int(10)NOT NULL ,first_name varchar(250) NOT NULL, last_name varchar(250) NOT NULL, dept_name varchar(250) NOT NULL, blood_group varchar(250), email_id varchar(250) NOT NULL,  mobile_number varchar(250) NOT NULL,PRIMARY KEY (Id) );";
			boolean result=stmt.execute(sqlQuery);
			if(result)
				System.out.println("Query executed");
			else
				System.out.println("Table may Exists");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}