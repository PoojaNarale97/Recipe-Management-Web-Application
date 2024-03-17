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


//@WebServlet("/RecipeUpdateServlet")
public class RecipeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RecipeUpdateServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("rname");
		String ingre=request.getParameter("rin");
		String  des=request.getParameter("rdes");
		
		Recipe recipe=new Recipe(id, name, ingre, des);
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/recipemanagement","root","root");
		    
			
			String sql="update recipe set  Recipe_Name=?, Ingredients=? ,Instructions=? where Recipe_id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(4,recipe.getRecipe_id());
			ps.setString(1,recipe.getRecipe_name());
			ps.setString(2,recipe.getRecipe_ingredients());
			ps.setString(3,recipe.getRecipe_description());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.print("<h1>Recipe Updated Successfully...!</h1>");
			}
			else
			{
				out.print("<h1>Recipe Failed To Update...!</h1>");
			}
		
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
