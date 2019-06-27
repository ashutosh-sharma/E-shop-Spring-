/**
 * 
 */
package com.epam.eshop.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Category.
 *
 * @author Ashutosh_Sharma
 */
@Entity
@Table(name = "category")
public class Category {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    /** The name. */
    @Column(name = "category_name")
    private String name;

    /** The desc. */
    @Column(name = "category_desc")
    private String desc;

    /** The product. */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> product;

    /**
     * Instantiates a new category.
     */
    public Category() {
    }

    /**
     * Instantiates a new category.
     *
     * @param name the name
     * @param desc the desc
     */
    public Category(String name, String desc) {
	super();
	this.name = name;
	this.desc = desc;
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
     * @return the desc
     */
    public String getDesc() {
	return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
	this.desc = desc;
    }

}
