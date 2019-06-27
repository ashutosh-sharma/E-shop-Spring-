package com.epam.eshop.dto;

/**
 * The Class ItemDTO.
 */
public class ItemDTO {

    /** The item name. */
    private String itemName;

    /** The item price. */
    private Double itemPrice;

    /** The item desc. */
    private String itemDesc;

    /** The product. */
    private String product;

    /**
     * Instantiates a new item DTO.
     *
     * @param itemName  the item name
     * @param itemPrice the item price
     * @param itemDesc  the item desc
     * @param product   the product
     */
    public ItemDTO(String itemName, Double itemPrice, String itemDesc, String product) {
	super();
	this.itemName = itemName;
	this.itemPrice = itemPrice;
	this.itemDesc = itemDesc;
	this.product = product;
    }

    /**
     * Gets the item name.
     *
     * @return the itemName
     */
    public String getItemName() {
	return itemName;
    }

    /**
     * Gets the item price.
     *
     * @return the itemPrice
     */
    public Double getItemPrice() {
	return itemPrice;
    }

    /**
     * Gets the item desc.
     *
     * @return the itemDesc
     */
    public String getItemDesc() {
	return itemDesc;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public String getProduct() {
	return product;
    }

}
