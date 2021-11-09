package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Service.Service1;
import com.example.demo.model.User;

@Controller
@RequestMapping("/new")
public class NewController {
	@Autowired
	Service1 sv;

    @RequestMapping(method=RequestMethod.GET)
    public String New() {
        return "new";
    }
    
    @RequestMapping(method=RequestMethod.POST,value = "/registration")
    public String insert(@ModelAttribute User user ) {
    	
    	sv.new_employee(user);
    	
    	return "result";
    }
   
   
}
