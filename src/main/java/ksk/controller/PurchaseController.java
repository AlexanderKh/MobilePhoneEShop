package ksk.controller;

import ksk.entity.Customer;
import ksk.entity.Order;
import ksk.entity.Purchase;
import ksk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("customers/{customerID}/purchases")
public class PurchaseController {
    @Autowired
    ShopService shopService;

    @RequestMapping("{purchaseID}")
    public String show(@PathVariable("customerID") Integer customerID,
                       @PathVariable("purchaseID") Integer purchaseID,
                       ModelMap modelMap){
        Customer customer = shopService.getCustomerByID(customerID);
        Purchase purchase = shopService.getPurchaseByID(purchaseID);
        List<Order> orders = shopService.getOrdersByPurchaseID(purchaseID);

        modelMap.addAttribute("customer", customer);
        modelMap.addAttribute("purchase", purchase);
        modelMap.addAttribute("orders", orders);

        return "purchases/show";
    }

    @RequestMapping("new")
    public String create(@PathVariable("customerID") Integer customerID,
                         ModelMap modelMap){
        shopService.addPurchaseByCustomerID(customerID);

        return "redirect:..";
    }
}
