package com.Algodomain1.crm1.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Algodomain1.crm1.Entity.Product1;
import com.Algodomain1.crm1.Repository.ProductRepository1;

@RestController
@RequestMapping("/algodomain")
public class ProductControl {

	@Autowired
	private ProductRepository1 productRepository;

	@PostMapping("/addProducts")
	public List<Product1> addProducts(@Valid @RequestBody List<Product1> product) {
		return productRepository.saveAll(product);
	}

	@PostMapping("/searchProductByName")
	public List<Product1> searchProductByName(@RequestParam(name = "product_name") String productName) {
		return productRepository.getProductsByName(productName);
	}

	@PostMapping("/searchProductByNameForSeller")
	public List<Product1> searchProductByName(@RequestParam(name = "product_name") String productName,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByName(productName, sellerId);
	}

	@PostMapping("/searchProductByType")
	public List<Product1> searchProductByType(@RequestParam(name = "product_type") String productType) {
		return productRepository.getProductsByType(productType);
	}

	@PostMapping("/searchProductByTypeForSeller")
	public List<Product1> searchProductByType(@RequestParam(name = "product_type") String productType,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByType(productType, sellerId);
	}

	@PostMapping("/searchProductByCategory")
	public List<Product1> searchProductByCategory(@RequestParam(name = "product_category") String productCategory) {
		return productRepository.getProductsByCatgeory(productCategory);
	}

	@PostMapping("/searchProductByCategoryForSeller")
	public List<Product1> searchProductByCategory(@RequestParam(name = "product_category") String productCategory,
			@RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByCatgeory(productCategory, sellerId);
	}

	@PostMapping("/searchProductByPriceRange")
	public List<Product1> searchProductByPriceRange(@RequestParam(name = "min") float min,
			@RequestParam(name = "max") float max) {
		return productRepository.getProductsByRange(min, max);
	}

	@PostMapping("/searchProductByPriceRangeForSeller")
	public List<Product1> searchProductByPriceRange(@RequestParam(name = "min") float min,
			@RequestParam(name = "max") float max, @RequestParam(name = "seller_id") int sellerId) {
		return productRepository.getProductsByRange(min, max, sellerId);
	}

}
