package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Recipe;

//@WebServlet("/RecipeDeleteServlet")
public class RecipeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RecipeDeleteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int id=Integer.parseInt(request.getParameter("id"));
	
		Recipe recipe=new Recipe();
		recipe.setRecipe_id(id);
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipemanagement","root","root");
		    
			
			String sql="delete from recipe where Recipe_id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,recipe.getRecipe_id());
			
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.print("<h1>Recipe Deleted Successfully...!</h1>");
			}
			else
			{
				out.print("<h1>Recipe Failed To Delete...!</h1>");
			}
		
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
