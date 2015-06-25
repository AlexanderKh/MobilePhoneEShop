package ksk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "redirect:/products";
    }
}
