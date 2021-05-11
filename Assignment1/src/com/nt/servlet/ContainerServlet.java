package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.mainLogic.MinimumTimeTaken;

public class ContainerServlet extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
         PrintWriter pw=null;
         String total_container=null,total_person=null,each_volume=null;;
         pw=res.getWriter();
         res.setContentType("text/html");
         
         total_container=req.getParameter("total_container");
         total_person=req.getParameter("total_person");
         each_volume=req.getParameter("each_volume");
         int tcon=Integer.parseInt(total_container);
         int tper=Integer.parseInt(total_person);
         int container[]=new int[tcon];
         
         String str[]=each_volume.split(",");
         for(int i=0;i<str.length;i++) {
        	 container[i]=Integer.parseInt(str[i]);
         }
         int totalTime=MinimumTimeTaken.findMinimumTime(tcon, tper, container);
        
         pw.println("<h1 style='color:green'> "+totalTime+"  time taken to fill the all container in Minimum span of time");
         pw.close();
		  
		 
       }//doPost
}//servlet_class