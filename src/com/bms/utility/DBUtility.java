package com.bms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	public static Connection establishConnection() throws SQLException, ClassNotFoundException {
	String url,user,pass;
	
	url="jdbc:mysql://localhost:3306/bms_saniya";
	user="root";
	pass="root";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(url,user,pass);
	return con;
}}
