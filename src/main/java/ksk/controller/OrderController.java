package ksk.controller;

import ksk.entity.Product;
import ksk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("customers/{customerID}/purchases/{purchaseID}/orders")
public class OrderController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String add(@PathVariable Integer customerID,
                      @PathVariable Integer purchaseID,
                      ModelMap modelMap){
        List<Product> possibleProducts = shopService.getProducts();

        modelMap.addAttribute("purchaseID", purchaseID);
        modelMap.addAttribute("customerID", customerID);
        modelMap.addAttribute("possibleProducts", possibleProducts);

        return "orders/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String create(@PathVariable Integer customerID,
                         @PathVariable Integer purchaseID,
                         @RequestParam Integer productID,
                         ModelMap modelMap){
        shopService.addNewProductToPurchase(purchaseID, productID);

        return "redirect:..";
    }
}
