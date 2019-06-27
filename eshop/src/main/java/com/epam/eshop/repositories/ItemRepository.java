package com.epam.eshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.eshop.models.Item;
import com.epam.eshop.models.Product;

/**
 * The Interface ItemRepository.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    /**
     * Find by product.
     *
     * @param product the product
     * @return the list
     */
    public List<Item> findByProduct(Product product);

    /**
     * Find all by order by price in ascending order.
     *
     * @return the list
     */
    public List<Item> findAllByOrderByPriceAsc();
}
