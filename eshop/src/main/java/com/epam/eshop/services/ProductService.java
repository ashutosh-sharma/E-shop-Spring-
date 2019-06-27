package com.epam.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.epam.eshop.exceptions.ProductNotFound;
import com.epam.eshop.models.Product;
import com.epam.eshop.repositories.ProductRepository;

/**
 * The Class ProductService.
 */
@Service
@PropertySource("classpath:exception.properties")
public class ProductService {

    /** The environment. */
    @Autowired
    Environment env;

    /** The product repository. */
    @Autowired
    ProductRepository productRepository;

    /**
     * Adds the product.
     *
     * @param product the product
     * @return the product
     */
    public Product addProduct(Product product) {
	return productRepository.save(product);
    }

    /**
     * Removes the product.
     *
     * @param productId the product id
     * @return true, if successful
     */
    public boolean removeProduct(int productId) {
	boolean result = false;
	try {
	    productRepository.deleteById(productId);
	    result = true;
	} catch (EmptyResultDataAccessException exe) {
	    result = false;
	}
	return result;
    }

    /**
     * Gets the product.
     *
     * @param productId the product id
     * @return the product
     */
    public Product getProduct(int productId) {
	return productRepository.findById(productId)
		.orElseThrow(() -> new ProductNotFound(Integer.parseInt(env.getProperty("ProductNotFound.code")),
			env.getProperty("ProductNotFound.message")));
    }

    /**
     * Gets the all products.
     *
     * @return the all products
     */
    public List<Product> getAllProducts() {
	List<Product> listOfProducts = productRepository.findAll();
	if (listOfProducts.isEmpty()) {
	    throw new ProductNotFound(Integer.parseInt(env.getProperty("ProductNotFound.code")),
		    env.getProperty("ProductNotFound.message"));
	}
	return listOfProducts;
    }

}
