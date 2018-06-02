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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

                        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                        CustomResourceLoader ob_res = (CustomResourceLoader) context.getBean("customResourceLoader");
        
                        File file = ob_res.getFile(fileName);
                        Scanner sc  = new Scanner(file);
                        
                       driver=sc.nextLine();
                       url=sc.nextLine();
                       user=sc.nextLine();
                       passwd=sc.nextLine();
                       
                  }
                  
                  public void updateParam() throws Exception{
                      
                        String fileName = "CustomDataConn.dat";    

                        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                        CustomResourceLoader ob_res = (CustomResourceLoader) context.getBean("customResourceLoader");
        
                        File file = ob_res.getFile(fileName);
                        
                        FileWriter fw = new FileWriter(file,false); //overwrite file
                        
                        fw.write(driver+"\n"+url+"\n"+user+"\n"+passwd);
                        
                        fw.close();
                        

                  }
}
