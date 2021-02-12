package com.dfmp.users;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private List<User> users;

	public UserController() {
		super();
		this.users = Arrays.asList(new User(-1L, "José Silva", GregorianCalendar.getInstance().getTime()));
	}

	@GetMapping("/users")
	public List<User> getAll() {
		return this.users;
	}

}
