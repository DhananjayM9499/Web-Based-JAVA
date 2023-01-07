package org.fi.spring.completerestboot.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class ProductId implements Serializable {
	private static final long serialVersionUID = -2114659809239530303l;
	
	@Column(name="categoryid")
	int categoryId;
	@Column(name="productid")
	int productId;
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
