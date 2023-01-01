package org.fi.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductId implements Serializable 
{
@Column(name="categoryId")
int categoryId;
@Column(name="productId")
int productId;

public ProductId() {
	super();
	// TODO Auto-generated constructor stub
}

public ProductId(int categoryId, int productId) {
	super();
	this.categoryId = categoryId;
	this.productId = productId;
}

public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}


}
