package com.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDto;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired(required=false)
	private ProductRepository productRepository;

	@GetMapping("/get-products")
	public List<ProductDto> getAllEmployees(){
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productList) {
			ProductDto productDto = new ProductDto(product);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}		
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

	@GetMapping("/get-product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productRepository.findById(id).get();
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Product product = productRepository.findById(id).get();
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
