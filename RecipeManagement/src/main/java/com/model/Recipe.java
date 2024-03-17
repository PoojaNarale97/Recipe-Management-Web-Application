package com.model;

public class Recipe {
	
	private int recipe_id;
	private String recipe_name;
	private String recipe_ingredients;
	private String recipe_description;
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipe_id, String recipe_name, String recipe_ingredients, String recipe_description) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.recipe_ingredients = recipe_ingredients;
		this.recipe_description = recipe_description;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_ingredients() {
		return recipe_ingredients;
	}

	public void setRecipe_ingredients(String recipe_ingredients) {
		this.recipe_ingredients = recipe_ingredients;
	}

	public String getRecipe_description() {
		return recipe_description;
	}

	public void setRecipe_description(String recipe_description) {
		this.recipe_description = recipe_description;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", recipe_ingredients="
				+ recipe_ingredients + ", recipe_description=" + recipe_description + "]";
	}
	
	
	

}
