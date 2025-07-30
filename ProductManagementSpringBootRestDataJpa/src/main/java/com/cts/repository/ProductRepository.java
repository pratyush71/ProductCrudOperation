package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	 List<Product> findByProductCategory(String productCategory);
	 List<Product> findByProductPriceBetween(int initialPrice,int finalPrice);
	
	
	/*
	 * //@Query("select p from Product p") List<Product>
	 * getProductsByCategory(String productCategory);
	 * 
	 * List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice);
	 */

}
