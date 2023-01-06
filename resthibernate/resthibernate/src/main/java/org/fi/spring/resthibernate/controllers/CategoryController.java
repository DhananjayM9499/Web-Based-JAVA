package org.fi.spring.resthibernate.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.fi.spring.resthibernate.dto.CategoryDTO;
import org.fi.spring.resthibernate.entity.Category;
import org.fi.spring.resthibernate.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("category")
public class CategoryController 
{
@Autowired
CategoryRepository repositoryCategory;
@PostMapping("/newCategory")
public Serializable addNew(@RequestBody CategoryDTO objCategory)
{
	Category entityCategory = new Category();
	BeanUtils.copyProperties(objCategory, entityCategory);
	
		return repositoryCategory.save(entityCategory).getCategoryId();
	}

@GetMapping("/get/{cid}")
public CategoryDTO
getCategory(@PathVariable("cid")int categoryId)
{
	Optional<Category>optCategory = repositoryCategory.findById(categoryId);
	if(optCategory.isPresent()) {
	
		Category entityCategory=optCategory.get();
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(entityCategory, dto);
		return dto;
	}
	return null;
}
@GetMapping("/getAll")
public List<CategoryDTO> getCategory(){
	Iterator<Category>iter=repositoryCategory.findAll().iterator();
	ArrayList<CategoryDTO> list = new ArrayList<>();
	while(iter.hasNext())
	{
		Category entityCategory = iter.next();
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(entityCategory, dto);
		list.add(dto);
	}
	return list;
}



}
