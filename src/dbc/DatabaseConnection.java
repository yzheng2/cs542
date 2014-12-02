package dbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
	private static String DBdriver = null;
	private static String DBURL = null;
	private static String DBUSER = null;
	private static String DBPASS = null;
	private static String configname = "config.properties";
	private Connection conn = null;
	/* example
	private static final String DBdriver = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/51test";
	private static final String DBUSER = "root";
	private static final String DBPASS = "1234";*/
		
	private void setParameter(String path) throws Exception{
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			DBdriver = properties.getProperty("database.driverClassName");
			DBURL = properties.getProperty("database.url");
			DBUSER = properties.getProperty("database.username");
			DBPASS = properties.getProperty("database.password");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}
	}
	
	/*
	private void GetDBFromXML() throws Exception{
		//read file in WEB-INF
		try {
			String path = DatabaseConnection.class.getResource("/").getPath();  
	        String websiteURL = (path.replace("/build/classes", "").replace("%20"," ").replace("classes/", "") + configname).replaceFirst("/", "");  
	        setParameter(websiteURL); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	private void displayParameter(){ //display the parameter
		System.out.println("DBconfiguration: "+System.getProperty("user.dir"));
		System.out.println("DBdriver:"+this.DBdriver);
		System.out.println("DBURL:"+this.DBURL);
		System.out.println("DBUSER:"+this.DBUSER);
		System.out.println("DBPASS:"+this.DBPASS);
	}
	
	public DatabaseConnection() throws Exception {  //construction method
		try {
			//GetDBFromXML();
			
			setParameter("src/dbconfig.properties");
			displayParameter();
			Class.forName(DBdriver).newInstance();// install database driver
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// connect to database
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {// get database connection
		return this.conn;
	}

	public void close() throws Exception {// close database connection
		if (this.conn != null) {// avoid NullPointerException
			try {
				this.conn.close();// close database
			} catch (Exception e) {
				throw e;
			}
		}
	}
}