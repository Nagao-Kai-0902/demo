package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Service.StaffDataService;
import com.example.demo.model.User;

@Controller

public class StaffController {
	@Autowired
	StaffDataService service;
    
	@RequestMapping(path = "home",method = RequestMethod.GET )
    public String home(Model model) {
		String engineer = "0001";
		service.findDepartment(engineer);
		model.addAttribute("engineerList", "engineer");
		
        return "home";
    }
	
	@RequestMapping(path = "new", method = RequestMethod.GET)
    public String newStaff() {
		return "new";        
    }
    
	@RequestMapping(path = "new/registration", method = RequestMethod.GET)
    public String insert(@ModelAttribute User user ) {
		service.newEmployee(user);
    	return "result";
    }
	
	public void displayResult(Model model) {
		List<User> userList;
		try {
			userList = service.searchAll();
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @GetMapping(value = "/list")
	public String displayList(Model model) {
		List<User> userList;
		try {
			userList = service.searchAll();
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/list";
	}
}