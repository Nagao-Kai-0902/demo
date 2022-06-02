package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.StaffDataService;
import com.example.demo.model.User;

@Controller

public class StaffController {
	@Autowired
	StaffDataService service;

	@RequestMapping(path = "home", method = RequestMethod.GET)
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home";
	}

	@RequestMapping(path = "new", method = RequestMethod.GET)
	public String newStaff(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "new";
	}

	@RequestMapping(path = "new/registration", method = RequestMethod.POST)
	public String insert(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.test1Form", result);
//			model.addAttribute("validationError", errorList);
			return "new";
		}

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
	public String displayEdit(Model model, @PathVariable("staff_code") String staff_code) {

		User user = service.selectOne(staff_code);
		model.addAttribute("user", user);

		return "/edit";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			RedirectAttributes redirectAttributes, @PathVariable("staff_code_before") @RequestParam String staff_code_before,
			String staff_code) {

		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			redirectAttributes.addFlashAttribute("staff_code", staff_code_before);
//			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
//			User user1 = service.selectOne(staff_code_before);
//			model.addAttribute("user", user1);
			return "edit";
		}
		service.updateOne(staff_code_before, user);

		return "/update";
	}

	@GetMapping(value = "/delete/{staff_code}")
	public String displayDelete(Model model, @PathVariable("staff_code") String staff_ode) {

		User user = service.deleteOne(staff_ode);
		model.addAttribute("user", user);

		return "/delete";
	}

	@RequestMapping(path = "/destroy", method = RequestMethod.POST)
	public String destroy(Model model, User user, @RequestParam String staff_code) {

		service.destroyOne(staff_code, user);

		return "/destroy";
	}

}