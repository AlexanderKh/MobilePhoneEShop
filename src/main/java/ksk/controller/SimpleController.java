package ksk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("hello")
    public void Hello(ModelMap model){
        System.out.println("hello");
    }
}
