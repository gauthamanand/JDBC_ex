package com.model.bl;

import com.model.bean.User;

public class LoginCheck {
	
	public boolean check (User user) {
		if (user.getUsername().equals("Admin") && user.getPassword().equals("Admin")) {
			return true;
		} else {
			return false;
		}
	}
}
