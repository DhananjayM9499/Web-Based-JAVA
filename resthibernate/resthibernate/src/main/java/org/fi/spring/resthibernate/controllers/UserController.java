package org.fi.spring.resthibernate.controllers;


import java.util.ArrayList;
import java.util.List;

import org.fi.spring.resthibernate.dto.UserDTO;
import org.fi.spring.resthibernate.entity.UserEntity;
import org.fi.spring.resthibernate.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
@Autowired
UserRepository repositoryUser;
@GetMapping("all/{pageNo}")
public List<UserDTO>getAllUsers(@PathVariable("pageNo")int pageNo,@RequestParam("pageSize")int pageSize)
{
	Pageable page = PageRequest.of(pageNo, pageSize,Sort.by("name").ascending());
	List<UserEntity> dataList =repositoryUser.findAll(page).toList();
	ArrayList<UserDTO> list = new ArrayList<>();
	for (UserEntity user : dataList)
	{
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		list.add(dto);
	}
	return list;
}
@GetMapping("byEmail")
public List<UserDTO> getUserByEmail(@RequestParam("email") String email)
{
	List<UserEntity> dataList = repositoryUser.findByEmail(email);
	ArrayList<UserDTO> list = new ArrayList<>();
	for(UserEntity user : dataList)
	{
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		list.add(dto);			
	}
	
	return list;
}
@GetMapping("user")
public UserDTO getUser(@RequestParam("name") String name)
{
	UserEntity user= repositoryUser.findByName(name);

	System.out.println(name);
	System.out.println(user);
	UserDTO dto = new UserDTO();
	BeanUtils.copyProperties(user, dto);
	return dto;	
}
@GetMapping("allByDescending")
public List<UserDTO> getAllByDescending()
{
	List<UserEntity> dataList = repositoryUser.getAllRecordsByDescending();
	ArrayList<UserDTO> list = new ArrayList<>();
	for(UserEntity user : dataList)
	{
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
list.add(dto);
	}
	return list;
}
@PostMapping("authenticate")
public UserDTO authenticateUser(@RequestParam("userName")String userName,@RequestParam("password")String password)
{
	UserEntity user = repositoryUser.authenticateUser(userName,password);
UserDTO dto = new UserDTO();
BeanUtils.copyProperties(user, dto);
dto.setPassword("************");
return dto;
}
}
