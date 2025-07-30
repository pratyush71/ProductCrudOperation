package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

import lombok.Data;

@Service("service")
//@AllArgsConstructor
@Data
public class ProductServiceImp implements ProductService {

	ProductRepository repo;

//	@Autowired
	public ProductServiceImp(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public String addProduct(Product product) {

		repo.save(product);
		return "Product Saved Successfully";
	}

	@Override
	public String updateProduct(Product product) {

		repo.save(product);
		return "employee Updated Successfully";
	}

	@Override
	public String deleteProductById(int productId)  throws ProductNotFound{

	 repo.delete(getProductById(productId));
	
		 return "Product Deleted Succesfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {

		Optional<Product>optional= repo.findById(productId);
		if(optional.isEmpty()) {
			throw new ProductNotFound("Product not found ");
		}
		
		return optional.get();
	}

	@Override
	public List<Product> getAllProducts() {

		return repo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) throws CategoryNotFound {
		// TODO Auto-generated met
	List<Product>products= repo.findByProductCategory(productCategory);
		if(products.size()>0) {
			return products;
		}
		else 
			throw new CategoryNotFound("no found category matching");
		
		
		//return repo.findByProductCategory(productCategory);
	}

	@Override
	public List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice) {
		// TODO Auto-generated method stub
		return repo.findByProductPriceBetween(intialPrice, finalPrice);
	}

	/*
	 * @Override public List<Product> getProductsByCategory(String productCategory)
	 * {
	 * 
	 * return repo.findByProductCategory(productCategory); }
	 * 
	 * @Override public List<Product> getProductsBetweenPriceRange(int intialPrice,
	 * int finalPrice) {
	 * 
	 * return repo.findByProductPriceBetween(intialPrice, finalPrice); }
	 */
}
