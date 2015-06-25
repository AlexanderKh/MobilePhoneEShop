package ksk.service;

import ksk.entity.Product;
import ksk.entity.Customer;
import java.util.List;

public interface ShopService {
    List<Product> getProducts();

    List<Customer> getCustomers();

    Product getProductByID(Integer productID);

    void addProduct(Product product, Integer brandID);

    void addProduct(Product product);

    void removeProductByID(Integer productID);


    Customer getCustomerByID(Integer customerID);

    void addCustomer(Customer customer, Integer customerID);

    void addCustomer(Customer customer);

    void removeCustomerByID(Integer customerID);
}
