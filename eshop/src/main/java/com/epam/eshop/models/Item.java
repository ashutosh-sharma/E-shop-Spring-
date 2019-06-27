/**
 * 
 */
package com.epam.eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Model class - Item.
 *
 * @author Ashutosh_Sharma
 */
@Entity
@Table(name = "item")
public class Item {

    /** The item id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    /** The item name. */
    @Column(name = "item_name")
    private String name;

    /** The item price. */
    @Column(name = "item_price")
    private Double price;

    /** The item desc. */
    @Column(name = "item_desc")
    private String desc;

    /** The product. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Instantiates a new item.
     */
    public Item() {
    }

    /**
     * Instantiates a new item.
     *
     * @param itemName  the item name
     * @param itemPrice the item price
     * @param itemDesc  the item desc
     * @param product   the product
     */
    public Item(String itemName, Double itemPrice, String itemDesc, Product product) {
	super();
	this.name = itemName;
	this.price = itemPrice;
	this.desc = itemDesc;
	this.product = product;
    }

    /**
     * Gets the item name.
     *
     * @return the itemName
     */
    public String getItemName() {
	return name;
    }

    /**
     * Sets the item name.
     *
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
	this.name = itemName;
    }

    /**
     * Gets the item price.
     *
     * @return the itemPrice
     */
    public Double getItemPrice() {
	return price;
    }

    /**
     * Sets the item price.
     *
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(Double itemPrice) {
	this.price = itemPrice;
    }

    /**
     * Gets the item desc.
     *
     * @return the itemDesc
     */
    public String getItemDesc() {
	return desc;
    }

    /**
     * Sets the item desc.
     *
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
	this.desc = itemDesc;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public Product getProduct() {
	return product;
    }

    /**
     * Sets the product.
     *
     * @param product the product to set
     */
    public void setProduct(Product product) {
	this.product = product;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return "Item [itemName=" + name + ", itemPrice=" + price + ", itemDesc=" + desc + ", product=" + product + "]";
    }

}
