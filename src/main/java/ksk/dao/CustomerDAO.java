package ksk.dao;

import ksk.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAll();

    Customer getByID(int id);

    void save(Customer customer);

    void deleteByID(Integer customerID);
}

