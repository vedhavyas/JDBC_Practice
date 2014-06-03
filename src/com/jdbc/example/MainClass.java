package com.jdbc.example;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseObject obj = new DatabaseObject("Rushikesh", "rushikesh@gmail.com");
		DBOperations.addObjectIntoDB(obj);
		DBOperations.printDbObj(DBOperations.getAllObjects());
		
	}
}
