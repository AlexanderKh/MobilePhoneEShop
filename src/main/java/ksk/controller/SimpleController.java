package ksk.controller;

import ksk.dao.CharacteristicDAO;
import ksk.dao.ProductDAO;
import ksk.entity.Characteristic;
import ksk.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SimpleController {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CharacteristicDAO characteristicDAO;

    @RequestMapping("/")
    public String Hello(ModelMap model){
        List<Product> products = productDAO.getProducts();
        System.out.println(products.size());
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Integer productID,
                       ModelMap model){
        Product product = productDAO.getProduct(productID);
        List<Characteristic> characteristics = characteristicDAO.getCharacteristicsByProduct(product);
        System.out.println(characteristics.size());
        model.addAttribute("product", product);
        model.addAttribute("characteristics", characteristics);

        return "products/show";
    }
}
