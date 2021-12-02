package com.itsoftware.jee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String showWelcomeSite(@RequestParam String username, @RequestParam String password, ModelMap model) {
		if(loginService.isUserValid(username, password)) {
			model.put("name", username);
			model.put("password", password);
			return "welcome";
		}
		model.put("errorMessage", "Invalid credantionals!");
		return "login";
	}
}
