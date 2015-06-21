package ksk.controller;

import ksk.entity.Brand;
import ksk.entity.Characteristic;
import ksk.entity.Product;
import ksk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductsController {
    @Autowired
    ShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Product> products = shopService.getProducts();

        model.addAttribute("products", products);

        return "products/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Integer productID,
                       ModelMap model){
        Product product = shopService.getProductByID(productID);
        List<Characteristic> characteristics = shopService.getCharacteristicsByProduct(product);

        model.addAttribute("product", product);
        model.addAttribute("characteristics", characteristics);

        return "products/show";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newProduct(ModelMap modelMap){
        Product product = new Product();
        List<Brand> brands = shopService.getBrands();

        modelMap.addAttribute("brands", brands);
        modelMap.addAttribute("product", product);
        return "products/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String create(@ModelAttribute Product product,
                         BindingResult bindingResult,
                         @RequestParam("brand") Integer brandID){
        shopService.addProduct(product);

        return "redirect:/products";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Integer productID){
        shopService.removeProductByID(productID);
        return "redirect:/products";
    }
}
