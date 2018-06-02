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

import java.sql.*;
public class DataSourceConnection {
    
    private Connection con;
	
	private void connect()
	{
		try
		{
                        DataSourceParams ob = new DataSourceParams();
                        ob.readParam();
			Class.forName(ob.getDriver()); 
			
                        String url=ob.getURL();
			String user=ob.getUserName();
			String passwd=ob.getPasswd();
                        
                        /*
			String url="jdbc:oracle:thin:@localhost:1521/orclpdb";
			String user="HR";
			String passwd="hr";
                        */
			
			con = DriverManager.getConnection(url,user,passwd);
                        
                        if(con!=null){
                            System.out.println("Connection Eshtablished!!");
                        }
                        else{
                            System.out.println("Connection Failed");
                        }
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
        
        public Connection getConnection(){
            
            connect();
            return con;
        }
        
        public ResultSet runSelectQuery(String sql){
            
            
            ResultSet rs=null;
            try{
                
               
                connect();
                
                Statement st = con.createStatement();
                rs=st.executeQuery(sql);
                
                if(rs!=null){
                    System.out.println("Results Obtained!!");
                }
                
                System.out.println(rs);
                
              
                
            }catch(SQLException e){}
            
            return rs;
            
        }

        public int runUpdateStatements(String sql) throws SQLException{
            
            connect();
            
            Statement st  = con.createStatement();
            
            int res = st.executeUpdate(sql);
            
            return res;
        }
    
}
