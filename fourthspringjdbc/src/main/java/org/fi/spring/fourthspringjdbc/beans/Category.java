package org.fi.spring.fourthspringjdbc.beans;

import org.springframework.stereotype.Component;

@Component
public class Category {
int CategoryId;
String categoryName;
String categoryDescription;
String categoryImageUrl;
public int getCategoryId() {
	return CategoryId;
}
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}
public String getCategoryImageUrl() {
	return categoryImageUrl;
}
public void setCategoryImageUrl(String categoryImageUrl) {
	this.categoryImageUrl = categoryImageUrl;
}
}