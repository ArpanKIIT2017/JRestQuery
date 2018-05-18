/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

/**
 *
 * @author KIIT
 * 
 */
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class QueryMapper {
    
    private String query_id;
    private String query;
    
    QueryMapper(){
        
    }
    
    QueryMapper(String query_id){
        
        this.query_id=query_id;
        
    }
    
    public String getQuery() throws Exception{

        
       parseQuery();
       return query;
       
        }
        
        
    
    
    private boolean parseQuery() throws Exception {
        
        System.out.println("In parseQuery Method");
        
        String fileName="QueryMap.json";
        
        JSONParser parser = new JSONParser();
        
        System.out.println("Parser object created....");
        
        ClassLoader classLoader = getClass().getClassLoader();
         File file = new File(classLoader.getResource(fileName).getFile());
         
        Object ob = parser.parse(new FileReader(file));
        
        if(ob==null){
            System.out.println("Can't Parse File");
        }else{
            System.out.println("File Parsed");
        }
        
        JSONArray qmap = (JSONArray)ob;
        System.out.println("qmap JSONArray OKAY");
        
        for(Object query_entry : qmap){
            
            System.out.println("Inside loop");
            
            JSONObject temp = (JSONObject) query_entry;
            
            System.out.println("Temp Object Created");
            
            String xqry_id = (String)temp.get("Query_id");  //This statement WAS throwing NullPointer Exception
            
            String xqry = (String)temp.get("Query");
            
            System.out.println(xqry_id+" "+xqry);
            
            if(xqry_id.equals(query_id)){
                query=xqry;
                break;
            }
            
        }
        
        if(query!=null){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
}//end of class
