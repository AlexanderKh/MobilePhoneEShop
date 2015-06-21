package ksk.service.impl;

import ksk.dao.CharacteristicDAO;
import ksk.dao.ProductDAO;
import ksk.entity.Characteristic;
import ksk.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements ksk.service.ShopService{
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CharacteristicDAO characteristicDAO;


    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    public List<Characteristic> getCharacteristicsByProduct(Product product) {
        return characteristicDAO.getCharacteristicsByProduct(product);
    }

    public Product getProductByID(Integer productID) {
        return productDAO.getProduct(productID);
    }

    public void addProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public void removeProductByID(Integer productID) {
        productDAO.removeProductByID(productID);
    }
}
