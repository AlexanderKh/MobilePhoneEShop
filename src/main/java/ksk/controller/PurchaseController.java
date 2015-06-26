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
    public String show(@PathVariable Integer customerID,
                       @PathVariable Integer purchaseID,
                       ModelMap modelMap){
        Customer customer = shopService.getCustomerByID(customerID);
        Purchase purchase = shopService.getPurchaseByID(purchaseID);
        List<Order> orders = shopService.getOrdersByPurchaseID(purchaseID);

        modelMap.addAttribute("customer", customer);
        modelMap.addAttribute("purchase", purchase);
        modelMap.addAttribute("orders", orders);
        modelMap.addAttribute("isCommitable", orders.size() != 0);

        return "purchases/show";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String create(@PathVariable Integer customerID,
                         ModelMap modelMap){
        Integer newID = shopService.addPurchaseByCustomerID(customerID);

        return "redirect:/customers/" + customerID + "/purchases/" + newID;
    }

    @RequestMapping(value = "{purchaseID}/end", method = RequestMethod.POST)
    public String commit(@PathVariable Integer customerID,
                         @PathVariable Integer purchaseID,
                         ModelMap modelMap){
        shopService.commitPurchaseByID(purchaseID);

        return "redirect:/customers/" + customerID;
    }

    @RequestMapping(value = "{purchaseID}/clear", method = RequestMethod.POST)
    public String clear(@PathVariable Integer customerID,
                         @PathVariable Integer purchaseID,
                         ModelMap modelMap){
        shopService.clearPurchaseByID(purchaseID);

        return "redirect:/customers/" + customerID + "/purchases/" + purchaseID;
    }

}
