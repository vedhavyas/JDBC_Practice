package com.jdbc.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperations {
	public static ArrayList<DatabaseObject> getAllObjects(){
		Connection connection = ConnectionFactory.getConnection();
		ArrayList<DatabaseObject> dbObj = new ArrayList<DatabaseObject>();
		try {
			Statement stmnt = connection.createStatement();
			String sql = "select * from jdbctable";	
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				dbObj.add(new DatabaseObject(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbObj;
	}
	
	public static int addObjectIntoDB(DatabaseObject obj){
		Connection connection = ConnectionFactory.getConnection();
		Statement stmnt;
		int retVal=-1;
		try {
			stmnt = connection.createStatement();
			String sql = "Insert into jdbctable (Name,Email) Values (\""+obj.getName()+"\",\""+obj.getEmail()+"\")";
			retVal=stmnt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static void printDbObj(ArrayList<DatabaseObject> dbObj){
		for(DatabaseObject object : dbObj){
			System.out.println("ID : "+object.getID()+"| Name : "+object.getName()+"| Email : "+object.getEmail());
		}
	}
}
