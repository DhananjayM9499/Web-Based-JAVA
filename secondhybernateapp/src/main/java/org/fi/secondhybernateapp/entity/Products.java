package org.fi.secondhybernateapp.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products_0018")
public class Products 
{
@EmbeddedId
ProductId id;

@Column(name="productName")
String productName;

@Column(name="productDescription")
String producDescription;

@Column(name="productPrice")
String productPrice;

@Column(name="productImageUrl")
String productImageUrl;

public Products() {
	
	// TODO Auto-generated constructor stub
}

public Products(ProductId id, String productName, String producDescription, String productPrice,
		String productImageUrl) {
	super();
	this.id = id;
	this.productName = productName;
	this.producDescription = producDescription;
	this.productPrice = productPrice;
	this.productImageUrl = productImageUrl;
}

public ProductId getId() {
	return id;
}

public void setId(ProductId id) {
	this.id = id;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProducDescription() {
	return producDescription;
}

public void setProducDescription(String producDescription) {
	this.producDescription = producDescription;
}

public String getProductPrice() {
	return productPrice;
}

public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}

public String getProductImageUrl() {
	return productImageUrl;
}

public void setProductImageUrl(String productImageUrl) {
	this.productImageUrl = productImageUrl;
}

}
