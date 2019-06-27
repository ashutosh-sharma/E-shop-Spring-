package com.epam.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eshop.dto.ItemDTO;
import com.epam.eshop.exceptions.ItemNotFound;
import com.epam.eshop.models.Item;
import com.epam.eshop.repositories.ProductRepository;
import com.epam.eshop.services.ItemService;

/**
 * The Class ItemRestController.
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    /** The item service. */
    @Autowired
    private ItemService itemService;

    /** The product repository. */
    @Autowired
    ProductRepository productRepository;

    /**
     * Add Item.
     *
     * @param newItem the new item
     * @return the item
     */
    @PostMapping("/add/")
    public ItemDTO add(@RequestBody ItemDTO newItem) {
	return itemService.addItem(newItem);
    }

    /**
     * Gets the item.
     *
     * @param itemId the item id
     * @return the item
     * @throws ItemNotFound the item not found
     */
    @GetMapping("/{itemId}")
    public ItemDTO get(@PathVariable String itemId) {
	return itemService.getItem(Integer.parseInt(itemId));
    }

    /**
     * Gets the all items.
     *
     * @return the all items
     */
    @GetMapping("/all")
    public List<Item> getAll() {
	return itemService.getAllItems();
    }

    /**
     * Delete item.
     *
     * @param itemId the item id
     */
    @DeleteMapping("/delete/{itemId}")
    public boolean delete(@PathVariable int itemId) {
	return itemService.removeItemById(itemId);
    }

    /**
     * Sorted by price.
     *
     * @return the list
     */
    @GetMapping("/all/sortByPrice")
    public List<Item> getAllSortedByPrice() {
	return itemService.sortedByPrice();
    }
}
