package ksk.dao;

/**
 * Created by UAHollow on 25.06.2015.
 */

import ksk.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void removeCustomerByID(Integer customerID);
}

