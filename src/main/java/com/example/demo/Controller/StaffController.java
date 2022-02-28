package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		String sales = "0002";
		String corporate = "0003";
		List<User> engineerMembers;
		List<User> salesMembers;
		List<User> corporateMembers;
		try {
		engineerMembers = service.findDepartment(engineer);
		salesMembers = service.findDepartment(sales);
		corporateMembers = service.findDepartment(corporate);
		model.addAttribute("engineerMembers", engineerMembers);
		model.addAttribute("salesMembers", salesMembers);
		model.addAttribute("corporateMembers", corporateMembers);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
        return "home";
    }
	
	@RequestMapping(path = "new", method = RequestMethod.GET)
    public String newStaff() {
		return "new";        
    }
    
	@RequestMapping(path = "new/registration", method = RequestMethod.POST)
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
    
    @GetMapping(value = "/edit/{staff_code}")
    public String displayEdit(Model model, @PathVariable("staff_code") String staffCode) {
        
            User user = service.selectOne(staffCode);
            model.addAttribute("user", user);

		return "/edit";
	}
    
    @PostMapping(value = "update")
    public String update(@ModelAttribute String staffCode ) {
    	
    	service.updateOne(staffCode);
    	return "/update" ;
    }
   
}