package com.capgemini.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDemo {
	static Connection con = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Step-1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step-2
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "NEW", "root");
			//retrieve();
			//insert();
			//update();
			delete();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void delete() {
		// TODO Auto-generated method stub
		try {
			//Step-3
			PreparedStatement ps = con.prepareStatement("delete from employee where emp_id = ?");
			//Step-4
			ps.setInt(1, 1003);
			int i = ps.executeUpdate();
			if(i == 1)
				System.out.println("Done");
			else
				System.out.println("No");
			//Step-5
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void update() {
		// TODO Auto-generated method stub
		try {
			//Step-3
			PreparedStatement ps = con.prepareStatement("update employee set dept = ? where emp_id = ?");
			//Step-4
			ps.setString(1, "cse");
			ps.setInt(2, 1003);
			int i = ps.executeUpdate();
			if(i == 1)
				System.out.println("Done");
			else
				System.out.println("No");
			//Step-5
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void insert() {
		// TODO Auto-generated method stub
		try {
			//Step-3
			PreparedStatement ps = con.prepareStatement("insert into employee values(my_sequence.nextval,?,?)");
			//Step-4
			ps.setString(1, "DEF");
			ps.setString(2, "ece");
			int i = ps.executeUpdate();
			if(i == 1)
				System.out.println("Done");
			else
				System.out.println("No");
			//Step-5
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void retrieve() {
		// TODO Auto-generated method stub
		try {
			//Step-3
			Statement st = con.createStatement();
			//Step-4
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			//Step-5
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
