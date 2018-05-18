/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

/**
 *
 * @author Arpan
 */

import java.util.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class CustomResponse {
    
    private String message;
    private List<Map> rows;
    
    public CustomResponse(){
        //default constructor
        rows = new ArrayList();
    }
    
    public CustomResponse(String msg){
        
        this.message=msg;
    }
    
    public String getMessage(){
        
        return message;
    }
    
    public void mapTable(ResultSet rs) throws Exception{
        
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        
        while(rs.next()){
            
            String col_name;
            Map row = new HashMap();
            
            for(int i=1;i<=numberOfColumns;i++){

                col_name=rsMetaData.getColumnName(i);
                row.put(col_name,  rs.getObject(i) );
            }
            
            rows.add(row);
        }
        
    }
    
    public List<Map> getResponse(){
        return rows;
    }
    
    
}
