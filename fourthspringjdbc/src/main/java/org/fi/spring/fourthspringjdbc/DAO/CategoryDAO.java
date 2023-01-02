package org.fi.spring.fourthspringjdbc.DAO;

import java.util.List;

import org.fi.spring.fourthspringjdbc.beans.Category;

public interface CategoryDAO {
	public boolean addCategory(Category objCategory);

	public List<Category> getAllCategories();

	public boolean updateCategory(int catId, String catName, String catDescription, String catImageUrl);
	public boolean deleteCategory(int categoryId);
}
