package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.StaffDataService;
import com.example.demo.model.User;

@Controller

public class StaffController {
	@Autowired
	StaffDataService service;
    
	@RequestMapping("home")
    public String home() {
        return "home";
    }
	
	@RequestMapping("new")
    public String newStaff() {
		return "new";        
    }
    
	@RequestMapping("new/registration")
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