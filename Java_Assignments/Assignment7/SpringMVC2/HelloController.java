package com.webonise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{
 
   @RequestMapping(value= "/hello")
   public String printHello(ModelMap model) {
	  System.out.println("if you're seeing this, it worked..");
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
}