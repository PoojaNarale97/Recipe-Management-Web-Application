package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Recipe;


//@WebServlet("/RecipeReadServlet")
public class RecipeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RecipeReadServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			
		Recipe recipe=new Recipe();
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipemanagement","root","root");
		    
			
			String sql="select * from recipe";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Recipe_id   </th>");
			out.print("<th> Recipe_Name </th>");
			out.print("<th> Ingredients </th>");
			out.print("<th> Instructions</th>");			
			out.print("</tr>");
			
			while(rs.next())
			{
				out.print("<tr>");
				
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("</tr>");
			}
			
			out.print("</table>");		
		
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
