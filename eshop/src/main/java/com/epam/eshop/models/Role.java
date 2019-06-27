package com.epam.eshop.models;

/**
 * The Enum Role.
 *
 * @author Ashutosh_Sharma
 */
public enum Role {

    /** The shopkeeper. */
    SHOPKEEPER(1),

    /** The customer. */
    CUSTOMER(2);

    /** The role id. */
    private final int roleId;

    /**
     * Instantiates a new role.
     *
     * @param roleId the role id
     */
    Role(int roleId) {
	this.roleId = roleId;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public int getRoleId() {
	return roleId;
    }

}
