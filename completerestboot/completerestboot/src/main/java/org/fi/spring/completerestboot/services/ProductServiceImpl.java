package org.fi.spring.completerestboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.fi.spring.completerestboot.dto.ProductDTO;
import org.fi.spring.completerestboot.dto.ProductIdDTO;
import org.fi.spring.completerestboot.entity.Product;
import org.fi.spring.completerestboot.entity.ProductId;
import org.fi.spring.completerestboot.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	MailService mailService;
	@Autowired
	ProductRepository repositoryProduct;

	@Override
	public ProductDTO getProductById(ProductIdDTO pid) {
		ProductId epid = new ProductId();
		BeanUtils.copyProperties(pid, epid);
		Optional<Product> optEntity = repositoryProduct.findById(epid);
		if (optEntity.isPresent()) {
			Product entity = optEntity.get();
			ProductDTO dto = new ProductDTO();
			ProductIdDTO dtoId = new ProductIdDTO();
			BeanUtils.copyProperties(entity.getId(), dtoId);
			BeanUtils.copyProperties(entity, dto);
			dto.setId(dtoId);
			return dto;
		}
		return null;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> dataList = repositoryProduct.findAll();
		ArrayList<ProductDTO> list = new ArrayList<>();
		for (Product entity : dataList) {
			ProductDTO dto = new ProductDTO();
			ProductIdDTO dtoId = new ProductIdDTO();
			BeanUtils.copyProperties(entity.getId(), dtoId);
			BeanUtils.copyProperties(entity, dto);
			dto.setId(dtoId);
			list.add(dto);
		}
		return list;
	}
	@Override
	public boolean addNewProduct(ProductDTO objProduct)
	{
		ProductId pid = new ProductId();
		Product entity = new Product();
		BeanUtils.copyProperties(objProduct.getId(),pid);
		BeanUtils.copyProperties(objProduct, entity);
		entity.setId(pid);
		repositoryProduct.save(entity);
		String contents = "A New Product has been added to the Catalog\n";
		contents+="Product Name : "+ objProduct.getProductName();
		contents+="\nProduct Desc : "+ objProduct.getProductDescription();
		contents+="Product Price : "+ objProduct.getProductPrice();
		contents+="Product Image : "+ objProduct.getProductImageUrl();
		contents+="\n------------------------------------------------";
		mailService.sendMail("dmmohokar94@gmail.com","New Product Added", contents);
		return true;        

	
	
	
	}
}


