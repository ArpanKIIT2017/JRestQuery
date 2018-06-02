/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.json.simple.parser.JSONParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author KIIT
 */
@RestController
@RequestMapping("/")
public class QueryMapController {
    
    @CrossOrigin
   @RequestMapping(value="/newQuery", method=RequestMethod.POST)
   public String newQuery(@RequestParam("qid") String qid, @RequestParam("query") String query) throws Exception{
       
        String fileName="QueryMap.json";
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       CustomResourceLoader ob_res = (CustomResourceLoader) context.getBean("customResourceLoader");
        
         File file = ob_res.getFile();
         
         JSONArray arr;
         if(file.length()==0){
             
              arr = new JSONArray();
         
             JSONObject newob = new JSONObject();
             newob.put("Query_id",qid);
             newob.put("Query",query);
             
             arr.add(newob);
            
         }else{
         
         JSONParser parser = new JSONParser();
         FileReader fr = new FileReader(file);
         Object ob = parser.parse(fr);
         fr.close();
         
         
         arr = (JSONArray)ob;
         
         JSONObject newob = new JSONObject();
         newob.put("Query_id",qid);
         newob.put("Query",query);
         
         arr.add(newob);
         }
         
         FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
         BufferedWriter out = new BufferedWriter(fw);
         out.write(arr.toJSONString());
         out.flush();
         out.close();
         fw.close();

       return arr.toJSONString();
   }
   
   @CrossOrigin
   @RequestMapping("/queries")
   public JSONArray getQueryMap() throws Exception{
       
       String fileName="QueryMap.json";
       
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       CustomResourceLoader ob_res = (CustomResourceLoader) context.getBean("customResourceLoader");
        
         File file = ob_res.getFile();
         System.out.println("File retrieved...");
       FileReader fr;JSONArray ob;
       
          fr = new FileReader(file);
          JSONParser parser = new JSONParser();
          ob= (JSONArray)parser.parse(fr);
          
          fr.close();       
          
          return ob;
   
   }
   
   @RequestMapping(value = "delQuery/{id}", method = RequestMethod.DELETE)
   public String deleteQuery(@PathVariable String id) throws Exception{
       
       JSONArray arr = getQueryMap();
       int i=0;
       for(Object ob:arr){
            
           JSONObject row = (JSONObject)ob;
           
           String qid = row.get("Query_id").toString();
           
           if(qid.equals(id)){
               arr.remove(i);
               break;
           }
           i++;
        }
        
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       CustomResourceLoader ob_res = (CustomResourceLoader) context.getBean("customResourceLoader");
        
       File file = ob_res.getFile();
       FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
       BufferedWriter out = new BufferedWriter(fw);
       out.write(arr.toJSONString());
       out.flush();
       out.close();
       fw.close();

       return arr.toJSONString();
      
   }
            
}
