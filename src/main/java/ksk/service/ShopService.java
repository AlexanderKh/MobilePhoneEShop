package ksk.service;

import ksk.entity.Product;

import java.util.List;

public interface ShopService {
    List<Product> getProducts();

    Product getProductByID(Integer productID);

    void addProduct(Product product, Integer brandID);

    void addProduct(Product product);

    void removeProductByID(Integer productID);


}
