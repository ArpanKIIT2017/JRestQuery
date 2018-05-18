/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame.JRestFrame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KIIT
 */
@RestController
@RequestMapping("/")
public class ConnectionController {
   
    @RequestMapping("/newConn")
   public String newConnection(@RequestParam("driver") String driver,@RequestParam("url") String url, @RequestParam("user") String user, @RequestParam("passwd") String passwd) throws Exception{
       
       DataSourceParams obj = new DataSourceParams(driver,url,user,passwd);
       
       obj.updateParam();
       
       return "Success";
   }
    
}
