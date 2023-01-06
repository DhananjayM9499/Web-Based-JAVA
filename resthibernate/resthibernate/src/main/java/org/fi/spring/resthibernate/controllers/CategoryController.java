package org.fi.spring.resthibernate.controllers;

import java.io.Serializable;

import javax.persistence.EntityNotFoundException;

import org.fi.spring.resthibernate.dto.CategoryDTO;
import org.fi.spring.resthibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
SessionFactory hibernateFactory;
@PostMapping("/newCategory")
public Serializable addNew(@RequestBody CategoryDTO objCategory)
{
	Category entityCategory = new Category();
	BeanUtils.copyProperties(objCategory, entityCategory);
	try(Session hibernateSession = hibernateFactory.openSession())
	{
		hibernateSession.beginTransaction();
		Serializable id = hibernateSession.save(entityCategory);
		hibernateSession.getTransaction().commit();
		return id;
	}
}
@GetMapping("/get/{cid}")
public CategoryDTO
getCategory(@PathVariable("cid")int categoryId)
{
	try(Session hibernateSession = hibernateFactory.openSession())
	{
		Category entitycCategory=(Category)hibernateSession.load(Category.class, categoryId);
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(entitycCategory, dto);
		return dto;
	}catch(EntityNotFoundException hbe) {
		return null;
	}
}
}
