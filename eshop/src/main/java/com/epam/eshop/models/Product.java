/**
 * 
 */
package com.epam.eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Product.
 *
 * @author Ashutosh_Sharma
 */
@Entity
public class Product {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    /** The name. */
    @Column(name = "product_name", nullable = false)
    private String name;

    /** The category. */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Instantiates a new product.
     */
    public Product() {
    }

    /**
     * Instantiates a new product.
     *
     * @param name     the name
     * @param category the category
     */
    public Product(String name, Category category) {
	super();
	this.name = name;
	this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
	return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
	this.category = category;
    }

}
