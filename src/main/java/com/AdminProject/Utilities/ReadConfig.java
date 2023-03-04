package com.AdminProject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
    Properties pro;
	public ReadConfig() {
		File src= new File("C:\\Users\\Ritessh\\eclipse-workspace\\AdminProject\\configuration\\config.properties");
	
     FileInputStream File;
     try
     {
    	 pro=new Properties();

    	 File =new FileInputStream(src);
    	 pro.load(File);
    }
     catch(Exception e){
    	 System.out.println("Exception is"+ e.getMessage());
     } }
     
     public String getApplicationUrl() {
    	String url= pro.getProperty("baseURL");
    	return url;
     }
     public String getUserName() {
    	String username= pro.getProperty("username");
    	return username;
     }
     public String getPassword() {
    	 String password=pro.getProperty("password");
    	 return password;
     }
}
