import java.sql.*;
import java.util.*;


public class CallableDemo {
Connection con;
CallableStatement cstmt;
ResultSet rs;
CallableDemo()
{
}
void createConnection()
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");     //forName is for registering the driver
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc","root","dhoom1234");
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
public void getSkills(int candidateID)
{
	String query = "{call get_candidate_skill(?)}";
	ResultSet rs;
	try
	{
		CallableStatement stmt = con.prepareCall(query);
		stmt.setInt(1, candidateID);
		rs= stmt.executeQuery();
		while (rs.next())
		{
			System.out.println(String.format("%s - %s",rs.getString("first_name")+" "+rs.getString("last_name"),rs.getString("skill")));
		}	
	}
	catch(SQLException ex)
	{
		System.out.println(ex.getMessage());
	}
}
public static void main(String[] args)
{
	CallableDemo cd=new CallableDemo();
	cd.createConnection();
	cd.getSkills(133);
}
}
