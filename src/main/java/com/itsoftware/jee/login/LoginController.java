package com.itsoftware.jee.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/app")
	@ResponseBody
	public String handleRequest() {
		return "welcome to the app";
	}


//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String showLoginForm(ModelMap model) {
//		model.addAttribute("name","DUPA");
//		return "welcome";
//	}
//
//	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
//	public String showWelcomeSite() {
//		return "welcome";
//	}
//
//	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
//	public String showWelcomeSite2() {
//		return "welcome";
//	}
////	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
////	public String showWelcomeSite(@RequestParam String username, @RequestParam String password, ModelMap model) {
////		if(loginService.isUserValid(username, password)) {
////			model.put("name", username);
////			model.put("password", password);
////			return "welcome";
////		}
////		model.put("errorMessage", "Invalid credantionals!");
////		return "login";
////	}
}
