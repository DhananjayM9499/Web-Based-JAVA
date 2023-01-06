package org.fi.spring.resthibernateproduct.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.fi.spring.resthibernateproduct.dto.ProductDTO;
import org.fi.spring.resthibernateproduct.entity.Product;
import org.fi.spring.resthibernateproduct.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
@Autowired
ProductRepository repositoryProduct;
@PostMapping("/newProduct")
public Serializable addNew(@RequestBody ProductDTO objProduct)
{
	Product entityProduct = new Product();
	BeanUtils.copyProperties(objProduct, entityProduct);
	return repositoryProduct.save(entityProduct).getProductId();
}
@GetMapping("/get/{pid}")
public ProductDTO getProduct(@PathVariable("pid")int productId)
{
	Optional<Product>optProduct = repositoryProduct.findById(productId);
	if(optProduct.isPresent()) {
	
		Product entityProduct=optProduct.get();
		ProductDTO productDto = new ProductDTO();
		BeanUtils.copyProperties(entityProduct, productDto);
		return productDto;
	}
	return null;
}
@GetMapping("/getAll")
public List<ProductDTO> getCategory(){
	Iterator<Product>iter=repositoryProduct.findAll().iterator();
	ArrayList<ProductDTO> list = new ArrayList<>();
	while(iter.hasNext())
	{
		Product entityProduct = iter.next();
		ProductDTO productDto = new ProductDTO();
		BeanUtils.copyProperties(entityProduct, productDto);
		list.add(productDto);
	}
	return list;
}

}
