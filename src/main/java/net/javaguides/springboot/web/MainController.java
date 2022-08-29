package net.javaguides.springboot.web;

import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import net.javaguides.springboot.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.service.UserService;


@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {

		return "index";
	}



	@GetMapping("/admin")
	public String admin(Model model) {
		List<User> listUsers = userService.getAllUsers();
		model.addAttribute("listUsers", listUsers);

		return "admin";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.userService.deleteUserById(id);
		return "redirect:/admin";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		User user = userService.getUserById(id);
		
		model.addAttribute("user",user);
		return "update_user";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("employee") User user) {
		// save employee to database
		userService.saveUser(user);
		return "redirect:/";
	}




}
