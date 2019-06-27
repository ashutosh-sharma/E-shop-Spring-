package com.epam.eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.eshop.models.Product;

/**
 * The Interface ProductRepository.
 * 
 * @author Ashutosh_Sharma
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
