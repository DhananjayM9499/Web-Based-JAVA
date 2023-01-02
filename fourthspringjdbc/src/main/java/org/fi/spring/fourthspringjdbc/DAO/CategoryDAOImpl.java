package org.fi.spring.fourthspringjdbc.DAO;

import java.util.List;

import javax.annotation.PostConstruct;

import org.fi.spring.fourthspringjdbc.beans.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	String sqlInsertCategory;
	String sqlDeleteCategory;
	String sqlUpdateCategory;
	String sqlAllCategories;

	@Autowired
	Environment environment;

@PostConstruct
public void initCategoryDAO()
{
	sqlInsertCategory = environment.getProperty("sql.insertCategory");
	sqlDeleteCategory= environment.getProperty("sql.deleteCategory");
	sqlUpdateCategory = environment.getProperty("sql.updateCategory");
	sqlAllCategories = environment.getRequiredProperty("sql.allCategories");
}

@Override
public boolean addCategory(Category objcategory) {
	int count = jdbcTemplate.update(sqlInsertCategory,objcategory.getCategoryId(),objcategory.getCategoryName(),objcategory.getCategoryDescription(),objcategory.getCategoryImageUrl());
	if(count>0)
		return true;
	else 
		return false;
}

@Override
public List<Category>getAllCategories(){
	return null;
}

@Override
public boolean updateCategory(int catId, String catName, String catDescription, String catImageUrl) {
	return false;
}

@Override
public boolean deleteCategory(int categoryId) {
	return false;
}

}
