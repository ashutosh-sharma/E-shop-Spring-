package com.epam.eshop.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.epam.eshop.dto.ItemDTO;
import com.epam.eshop.exceptions.ItemNotFound;
import com.epam.eshop.exceptions.NoItemsFound;
import com.epam.eshop.exceptions.ProductNotFound;
import com.epam.eshop.models.Item;
import com.epam.eshop.models.Product;
import com.epam.eshop.repositories.ItemRepository;
import com.epam.eshop.repositories.ProductRepository;

/**
 * The Class ItemService.
 */
@Service
@PropertySource("classpath:exception.properties")
public class ItemService {

    /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(UserService.class);

    /** The environment. */
    @Autowired
    Environment env;

    /** The item repository. */
    @Autowired
    ItemRepository itemRepository;

    /** The product repository. */
    @Autowired
    ProductRepository productRepository;

    /**
     * Adds the item.
     *
     * @param newItem the new item
     * @return the item DTO
     */
    public ItemDTO addItem(ItemDTO newItem) {
	Optional<Product> seletedProduct = productRepository.findById(Integer.parseInt(newItem.getProduct()));
	if (seletedProduct.isPresent()) {
	    Item item = new Item(newItem.getItemName(), newItem.getItemPrice(), newItem.getItemDesc(),
		    seletedProduct.get());
	    Item createdItem = itemRepository.save(item);
	    return new ItemDTO(createdItem.getItemName(), createdItem.getItemPrice(), createdItem.getItemDesc(),
		    createdItem.getProduct().getName());
	} else {
	    throw new ProductNotFound(Integer.parseInt(env.getProperty("ProductNotFound.code ")),
		    env.getProperty("ProductNotFound.message"));
	}
    }

    /**
     * Gets the item.
     *
     * @param itemId the item id
     * @return the item if present otherwise null
     * @throws ItemNotFound the item not found
     */
    public ItemDTO getItem(int itemId) {
	Item item = itemRepository.findById(itemId)
		.orElseThrow(() -> new ItemNotFound(Integer.parseInt(env.getProperty("ItemNotFound.code")),
			env.getProperty("ItemNotFound.message")));
	return new ItemDTO(item.getItemName(), item.getItemPrice(), item.getItemDesc(), item.getProduct().getName());

    }

    /**
     * Gets the all items.
     *
     * @return the all items
     */
    public List<Item> getAllItems() {
	List<Item> itemList = itemRepository.findAll();
	if (itemList.isEmpty()) {
	    throw new NoItemsFound(Integer.parseInt(env.getProperty("NoItemsFound.code")),
		    env.getProperty("NoItemsFound.message"));
	}
	return itemList;
    }

    /**
     * Gets the item by product.
     *
     * @param product the product
     * @return the item by product
     */
    public List<Item> getItemByProduct(Product product) {
	List<Item> itemList = itemRepository.findByProduct(product);

	if (itemList.isEmpty()) {
	    logger.error("No items found related to that product.");
	    throw new NoItemsFound(Integer.parseInt(env.getProperty("NoItemsFound.code")),
		    env.getProperty("NoItemsFound.message"));
	}
	return itemList;
    }

    /**
     * Removes the item by id.
     *
     * @param itemId the item id
     * @return the item
     */
    public boolean removeItemById(int itemId) {
	boolean result = false;
	try {
	    itemRepository.deleteById(itemId);
	    result = true;
	} catch (EmptyResultDataAccessException exe) {
	    logger.error("Item Does Not Exsits.");
	    result = false;
	}
	return result;
    }

    /**
     * Sorted by price.
     *
     * @return the list
     */
    public List<Item> sortedByPrice() {
	List<Item> itemList = itemRepository.findAllByOrderByPriceAsc();
	if (itemList.isEmpty()) {
	    throw new NoItemsFound(Integer.parseInt(env.getProperty("NoItemsFound.code")),
		    env.getProperty("NoItemsFound.message"));
	}
	return itemList;
    }
}
