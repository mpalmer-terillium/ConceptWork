package com.concepttest.util;

import com.concepttest.valueobject.JDECustomer;
import com.concepttest.valueobject.JDEItem;

import com.configureone.ws.Customer;
import com.configureone.ws.ItemMaster;

public class Util {


    /*
     * this could be a direct one-to-one mapping of all the values
     * or just what is needed for an item creation - it will depend
     * on the design decisions.
     */
    public static ItemMaster mapJDEItemToItemMaster(JDEItem item) {
        ItemMaster itemMaster = new ItemMaster();
        
        itemMaster.setITEMNUM(item.getItemnum());
        // continue as needed
        
        return itemMaster;
    }
    
    public static Customer mapJDECustomerToCustomer(JDECustomer jdeCustomer) {
        Customer customer = new Customer();
        
        customer.setACCOUNTNUM(jdeCustomer.getAccountnum());
        // continue as needed
        
        return customer;
    }
}
