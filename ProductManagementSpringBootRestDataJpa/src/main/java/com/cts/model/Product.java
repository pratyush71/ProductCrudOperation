package com.cts.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid", length = 3, nullable = false)
	@GeneratedValue
	private int productId;
	@Min(value=1000,message="price should be greater than 1000")
	@Max(value=10000,message="price should be less than 10000")
	
	private int productPrice;
	@Size(min=6,max=15,message="Product name must be betwwen 6 to 15")
	private String productName;
	@NotEmpty(message="cannot be null")
	//@NotNull
	private String productCategory;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {

	}

	public Product( int productPrice, String productName, String productCategory) {
		super();
	
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategory = productCategory;
	}

}
