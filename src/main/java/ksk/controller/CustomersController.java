package ksk.controller;

/**
 * Created by UAHollow on 25.06.2015.
 */
import ksk.entity.Customer;
import ksk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomersController {
    @Autowired
    ShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Customer> customers = shopService.getCustomers();

        model.addAttribute("customers", customers);

        return "customers/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Integer customerID,
                       ModelMap model){
    //    Customer customer = shopService.getCustomerByID(customerID);
        Customer customer = shopService.getCustomerByID(customerID);
        model.addAttribute("customer", customer);

        return "customers/show";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCustomer(ModelMap modelMap){
        Customer customer = new Customer();

        modelMap.addAttribute("customer", customer);
        return "customers/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String create(@ModelAttribute Customer customer,
                         BindingResult bindingResult){
        shopService.addCustomer(customer);

        return "redirect:/customers";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Integer customerID){
        shopService.removeCustomerByID(customerID);
        return "redirect:/customers";
    }
}

