/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

/**
 *
 * @author KIIT
 */

import java.io.*;
import java.util.*;
public class DataSourceParams {
    
                 
    
    private String driver;
    private String url;
    private String user;    
    private String passwd;
                 
                 DataSourceParams(){
                     
                     
                 }
                 
                 DataSourceParams(String driver, String url, String user, String passwd){
                     
                     this.driver=driver;
                     this.url=url;
                     this.user=user;
                     this.passwd=passwd;
                     
                     
                 }
                 
                 public String getDriver(){
                     return driver;
                 }
                 
                 public String getURL(){
                     return url;
                 }
                 
                 public String getUserName(){
                     return user;
                 }
                 
                 public String getPasswd(){
                     return passwd;
                 }
                  
                  public boolean readParams(){
                      return false;
                  }
                  
                  public void readParam() throws Exception{
                  
                        String fileName = "CustomDataConn.dat";    

                        ClassLoader classLoader = getClass().getClassLoader();
                         File file = new File(classLoader.getResource(fileName).getFile());

                        Scanner sc  = new Scanner(file);
                        
                       driver=sc.nextLine();
                       url=sc.nextLine();
                       user=sc.nextLine();
                       passwd=sc.nextLine();
                       
                  }
                  
                  public void updateParam() throws Exception{
                      
                      String fileName = "CustomDataConn.dat";    

                        ClassLoader classLoader = getClass().getClassLoader();
                        File file = new File(classLoader.getResource(fileName).getFile());
                        
                        FileWriter fw = new FileWriter(file,false); //overwrite file
                        
                        fw.write(driver+"\n"+url+"\n"+user+"\n"+passwd);
                        
                        fw.close();
                        

                  }
}
