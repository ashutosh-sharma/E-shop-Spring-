package com.epam.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eshop.dto.ProductDTO;
import com.epam.eshop.exceptions.ProductNotFound;
import com.epam.eshop.models.Category;
import com.epam.eshop.models.Product;
import com.epam.eshop.services.CategoryService;
import com.epam.eshop.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    /**
     * Gets the product.
     *
     * @param productId the product id
     * @return the product
     * @throws ProductNotFound the product not found
     */
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
	return productService.getProduct(Integer.parseInt(productId));
    }

    /**
     * Gets the all products.
     *
     * @return the all products
     */
    @GetMapping("/all")
    public List<Product> getAllProducts() {
	return productService.getAllProducts();
    }

    /**
     * Creates the product.
     *
     * @param newProduct the new product
     * @return the product
     */
    @PostMapping("/add")
    public Product createProduct(ProductDTO newProduct) {
	Category category = categoryService.getCategory(Integer.parseInt(newProduct.getCategory()));
	Product product = new Product(newProduct.getName(), category);
	return productService.addProduct(product);
    }
}
