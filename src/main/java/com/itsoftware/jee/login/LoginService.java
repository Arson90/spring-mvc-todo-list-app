package com.itsoftware.jee.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean isUserValid(String username, String password) {
		return username.equals("test") && password.equals("test");
	}
}
