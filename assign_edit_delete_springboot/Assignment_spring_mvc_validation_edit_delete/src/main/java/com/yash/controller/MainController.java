package com.yash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.yash.dao.*;

@Controller
public class MainController {
	@Autowired
	UserDAO userdao;

	@RequestMapping(value = "/")
	public String first() {
		return "index";
	}

	@GetMapping("/login")
	public String userLogin() {
		return "userlogin";
	}

	@GetMapping("/signup")
	public String userReg(Model m) {
		User objuser = new User();
		m.addAttribute("objuser", objuser);
		return "signup";
	}

	@PostMapping("/SignUpSubmit")
	public String UserRegSubmit(@Valid @ModelAttribute("objuser") User objuser, BindingResult objBR) {
		if (objBR.hasErrors())
			return "signup";
		else {
			if (userdao.saveUser(objuser) == 1)
				return "signup_success";
			else
				return "index";

		}
	}

	@GetMapping("/viewalluser")
	public String showUsers(Model m) {
		List<User> userlist = new ArrayList<User>();
		userlist = userdao.getAllEmp();
		m.addAttribute("userlist", userlist);
		return "userlist";
	}

	@GetMapping("/edituser")
	public String editUser(@RequestParam String id, Model m) {
		//List<User> uli = new ArrayList<User>();
		User objuser = new User();
		//uli = userdao.getEmp(id);
		m.addAttribute("objuser", objuser);
		return "editprofile";
	}

	@RequestMapping("/updateuser")
	public String updateuser(@ModelAttribute("objuser") User objuser) {
		
			if (userdao.updateuser(objuser) == 1)
			{
				return "userlist";
			}
			else {
				return "index";
			}

		}
			

	@GetMapping("/deluser")
	public String deluser(@RequestParam String id, Model m) {
		userdao.deleteuser(id);
		return "userlist";
	}
}
