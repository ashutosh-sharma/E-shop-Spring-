/**
 * 
 */
package com.epam.eshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.epam.eshop.exceptions.CategoryNotFound;
import com.epam.eshop.models.Category;
import com.epam.eshop.repositories.CategoryRepository;

/**
 * The Class CategoryService.
 *
 * @author Ashutosh_Sharma
 */
@Service
@PropertySource("classpath:exception.properties")
public class CategoryService {

    /** The category repository. */
    @Autowired
    CategoryRepository categoryRepository;

    /** The environment. */
    @Autowired
    Environment env;

    /**
     * Gets the category.
     *
     * @param categoryId the category id
     * @return the category
     */
    public Category getCategory(int categoryId) {
	Optional<Category> category = categoryRepository.findById(categoryId);
	return category
		.orElseThrow(() -> new CategoryNotFound(Integer.parseInt(env.getProperty("CategoryNotFound.code")),
			env.getProperty("CategoryNotFound.message")));
    }
}
