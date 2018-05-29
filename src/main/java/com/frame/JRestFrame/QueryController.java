/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

import java.sql.ResultSet;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Arpan
 */
@RestController
@RequestMapping("/")
public class QueryController {
    
    DataSourceConnection conn = new DataSourceConnection();
    
    @RequestMapping(value="/query", method=RequestMethod.GET)
    public List<Map> rawResult(@RequestParam("query") String query_id) throws Exception{
        
        QueryMapper qmap = new QueryMapper(query_id);
        
        String sql = qmap.getQuery();
        
        ResultSet results=conn.runSelectQuery(sql);
        
        CustomResponse response  = new CustomResponse();
        
        response.mapTable(results);
        
        return response.getResponse();
       
        
    }
    
    @RequestMapping(value="/update", method=RequestMethod.GET)
    public String update(@RequestParam("query") String query) throws Exception{
        
        String sql=query;
        
        CustomResponse response = new CustomResponse(conn.runUpdateStatements(sql)+" rows Updated");
        
        return response.getMessage();
    }
    
    
            
    
    
}
