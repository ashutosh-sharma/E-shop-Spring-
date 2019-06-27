package com.epam.eshop.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class Cart.
 *
 * @author Ashutosh_Sharma
 */
@Entity
public class Cart {

    /** The id. */
    @Id
    @Column(name = "cart_id")
    private int id;

    /** The items. */
    @OneToMany
    @Column(name = "cart_items")
    private List<Item> items;

    /** The total. */
    @Column(name = "cart_total")
    private int total;

    /** The user. */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
