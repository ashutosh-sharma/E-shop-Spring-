package com.epam.eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.eshop.models.Category;

/**
 * The Interface CategoryRepository.
 * 
 * @author Ashutosh_Sharma
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
