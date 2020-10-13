package testscripts.regression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DBTesting {
	
	@Test
	public void dbTest() throws SQLException
	{
		Connection conn=null;
		
		String url="jdbc:mysql://localhost:3306/";
		String dbName="testdb";
		String username="root";
		String password="reyaz123";
		
		String DBdriver="com.mysql.jdbc.Driver";
		
		conn=DriverManager.getConnection(url+dbName, username, password);
		
		PreparedStatement psmt=conn.prepareStatement("SELECT ename,empno FROM emp WHERE sal>2000;");
		
		ResultSet rs=psmt.executeQuery();
		
		while(rs.next())
		{
			
			
			System.out.println(rs.getString("ename")+"\t"+rs.getString("empno"));
		}
		
		conn.close();
		
		
	}

}
