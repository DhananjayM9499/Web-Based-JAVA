package org.fi.SpringSecond.beans;

public class Category {
	
	int categoryId;
	String catergoryName;
	
	
	
	public Category() {
		System.out.println("Category ctor fired.");
		
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCatergoryName() {
		return catergoryName;
	}
	public void setCatergoryName(String catergoryName) {
		this.catergoryName = catergoryName;
	}

}
