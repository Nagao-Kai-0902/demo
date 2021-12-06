package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Service.UserDataService;
import com.example.demo.model.User;

@Controller

public class StaffController {
	@Autowired
	UserDataService service1;
	UserDataService sv;
    
	@RequestMapping("home")
    public String home() {
        return "home";
    }
	
	@RequestMapping("new")
    public String New() {
        return "new";
    }
    
	@RequestMapping(method=RequestMethod.POST,value = "new/registration")
    public String insert(@ModelAttribute User user ) {
    	
    	return "result";
    }
    
    @GetMapping(value = "/list")
	public String displayList(Model model) {
		List<User> userlist;
		try {
			userlist = service1.searchAll();
			model.addAttribute("userlist", userlist);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return "/list";
	}
}