package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
	public static String filePath= System.getProperty("user.dir") + "\\Common.properties";
	public static File file=new File(filePath);
	public static FileInputStream fis;
	public static Properties prop=new Properties();
	
	public static String URL;
	public static String username;
	public static String password;
	
	
	
	
	public static String getURL() throws Exception {
		try {
			fis=new FileInputStream(file);
			prop.load(fis);
			URL=prop.getProperty("url");
			
		}catch (Exception e) {
			throw e;
		}
		return URL;
	}
	
	public static String getUsername() throws Exception {
		try {
			fis=new FileInputStream(file);
			prop.load(fis);
			username=prop.getProperty("username");
			
		}catch (Exception e) {
			throw e;
		}
		return username;
	}
	
	public static String getPassword() throws Exception {
		try {
			fis=new FileInputStream(file);
			prop.load(fis);
			password=prop.getProperty("password");
			
		}catch (Exception e) {
			throw e;
		}
		return password;
	}
	
}
