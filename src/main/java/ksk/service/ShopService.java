package ksk.service;

import ksk.entity.Brand;
import ksk.entity.Characteristic;
import ksk.entity.Product;

import java.util.List;

public interface ShopService {
    List<Product> getProducts();

    List<Characteristic> getCharacteristicsByProduct(Product product);

    Product getProductByID(Integer productID);

    void addProduct(Product product, Integer brandID);

    void addProduct(Product product);

    void removeProductByID(Integer productID);

    List<Brand> getBrands();
}
