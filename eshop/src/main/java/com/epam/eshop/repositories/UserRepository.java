package com.epam.eshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.eshop.models.Role;
import com.epam.eshop.models.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find by email.
     *
     * @param email the email
     * @return the list
     */
    List<User> findByEmail(String email);

    /**
     * Find by role.
     *
     * @param customer the customer
     * @return the list
     */
    List<User> findByRole(Role customer);
}
