package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.model.ProductDTO;
import com.pms.service.IProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductRestController {
	@Autowired
	IProductService service;

	@ApiOperation("Fetches the details of all products from Database")
	@GetMapping(value = "/allproducts", produces = "application/json")
	public ResponseEntity<List<ProductDTO>> findAllProducts() {
		List<ProductDTO> productDTOList = service.searchAllProducts();
		return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);

	}

	@ApiOperation("Fetches the details of specific product with a given id from Database")
	@GetMapping(value = "/product/{id}", produces = "application/json")
	public ProductDTO findProductById(@PathVariable Integer id) {
		return service.searchProductById(id);

	}

	@ApiOperation("Fetches the details of specific product with a given manufacturer from Database")
	@GetMapping(value = "/products/{manufacturer}", produces = "application/json")
	public List<ProductDTO> findProductsByManufacturer(@PathVariable String manufacturer) {
		return service.searchProductsByManufacturer(manufacturer);

	}

	@ApiOperation("Add the new product details to Database")
	@PostMapping(value = "/product/add", consumes = "application/json")
	public String addProduct(@RequestBody ProductDTO productDTO) {
		return service.addProduct(productDTO);
	}

	@ApiOperation("Updates an existing products details in a Database")
	@PutMapping(value = "/product/update", consumes = "application/json")
	public String updateProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO dto = service.updateProduct(productDTO);
		if (dto == null) {
			return "product doesn't exist";
		} else {
			return "product is updated";
		}
	}

	@ApiOperation("Deletes a specific product from  from Database with a given id")
	@DeleteMapping(value = "/product/delete/{id}")
	public String deleteProductById(@PathVariable Integer id) {
		return service.deleteProductById(id);
	}
}