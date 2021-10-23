package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.Service1;
import com.example.demo.model.User;

@Controller
public class listController {
	@Autowired
	Service1 service1;
	
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
