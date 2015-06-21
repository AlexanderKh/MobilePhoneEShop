package ksk.dao;

import ksk.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();

    Product getProduct(int id);

    void saveProduct(Product product);

    void removeProductByID(Integer productID);
}
