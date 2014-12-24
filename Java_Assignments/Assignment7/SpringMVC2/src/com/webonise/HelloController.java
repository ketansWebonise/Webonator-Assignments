package com.webonise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HelloController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
	   System.out.println("printHello() called from HelloController.java....");
      model.addAttribute("message", "Hello Spring MVC Framework!");
      System.out.println("attribute added to model....");
      return "hello";
   }
}