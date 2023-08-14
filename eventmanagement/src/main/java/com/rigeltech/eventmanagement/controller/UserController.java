package com.rigeltech.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rigeltech.eventmanagement.entity.User;
import com.rigeltech.eventmanagement.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hi")
	public String hi() {
		return "Welcome..";
	}

	//handler for adding records
	@PostMapping(value = "/add")
	@ResponseBody
	public String addData(@RequestParam("email") String email, @RequestParam("password") String password) {
		userService.saveData(email, password);
		return "Records added successfully!";
	}
	
	@PostMapping(value = "/add-user-view")

	public String addUserView(@RequestParam("email") String email, @RequestParam("password") String password) {
		return userService.addUserView(email, password);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/show")
	@ResponseBody
	public List<User> showAll(){
		return userService.showAll();
	}
	
	//handler for updating records
	@PutMapping("/update/{id}")
	@ResponseBody
	public User updateUser(@PathVariable("id") int id, @RequestParam("email") String email, @RequestParam("password") String password) {
		return userService.update(id, email, password);
		
	}
	
	//handler for deleting records by id
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteRecord(@PathVariable("id") int id){
		userService.delete(id);
		return "record deleted successfully: "+id;
	}	
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,  @RequestParam("password") String password, Model m) {
		 String loginMessage = userService.login(email, password,m);
		 return loginMessage;
	}
	
	@PostMapping("/login-api")
	@ResponseBody
	public String loginApi(@RequestParam("email") String email,  @RequestParam("password") String password, Model m) {
		 String loginMessage = userService.loginApi(email, password,m);
		 return loginMessage;
	}

	@GetMapping("/form")
	public String form() {
		return "login-form";
		}
}
