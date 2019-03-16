package com.capgemini.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {
	public int insertData(int id,String name,String dept,int age,long phoneNo,String address,int sal)
	{
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, dept);
			ps.setInt(4, age);
			ps.setLong(5, phoneNo);
			ps.setString(6, address);
			ps.setInt(7, sal);
			
			 i = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int updateData(int id,int sal)
	{
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement ps = con.prepareStatement("update employee set salary = ? where id = ?");
			ps.setInt(1, sal);
			ps.setInt(2, id);
			i = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int deleteData(int id)
	{
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from employee where id = ?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int selectData() {
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next())
			{
				i++;
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
			
	}

	public String selectDataName(int id) {
		String i = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement st = con.prepareStatement("select * from employee where id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				i = rs.getString(2);
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
