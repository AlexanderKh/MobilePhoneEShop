package ksk.dao;

import ksk.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getAll();

    Product getByID(int id);

    void save(Product product);

    void deleteByID(Integer productID);
}
