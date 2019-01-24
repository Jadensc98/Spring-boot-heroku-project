package com.tts.CarterWebsite.User;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tts.CarterWebsite.User.UserRepository;





@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserRepository UserRepository;
	
		@GetMapping("/")
		public String index(User user) {
			return "User/index.html";
		}
		
		@GetMapping("/about")
		public String about() {
			return "User/about.html";
		}
		
		@GetMapping("/contact")
		public String contact() {
			return "User/contact-us.html";
		}
		
		@GetMapping("/Signup")
		public String signup(User user) {
			return "User/Signup.html";
		}
		
		@GetMapping("/Result")
			public String result(User user) {
				return "User/Result.html";
		}
		@RequestMapping(value = "/Signup", method = RequestMethod.POST) 
		@PostMapping(value="User/Signup") 
		public String addNewUser(User user, Model model) {
		UserRepository.save(new User(user.getUserName(), user.getPassWord()));
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("passWord", user.getPassWord());
			return "User/Result";
			
		}
	}

