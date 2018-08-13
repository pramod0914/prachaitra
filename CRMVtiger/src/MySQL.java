import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MySQL {

	public static void main(String[] args) throws SQLException {
		
//		Load  The Driver
		Driver my_sql = new Driver();
		DriverManager.registerDriver(my_sql);
		
//		Get the Connection
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.109:3306/"+"studentsapp_db", "j2ee", "j2ee");
		
// Create a statement
		java.sql.Statement stat = con.createStatement();
		
//		Execute the query 
		ResultSet rs = stat.executeQuery("select * from employee");
		while(rs.next()) {
System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			
		}
		con.close();
	}

}

