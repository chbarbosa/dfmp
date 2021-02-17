package com.dfmp.users;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private List<User> users;

	public UserController() {
		super();
		this.users = Arrays.asList(new User(-1L, "José Silva", Calendar.getInstance().getTime()),
				new User(-2L, "José Souza", Calendar.getInstance().getTime()),
				new User(-3L, "Chica da Silva", Calendar.getInstance().getTime()),
				new User(-4L, "José Simão", Calendar.getInstance().getTime()),
				new User(-5L, "José Lima", Calendar.getInstance().getTime()));
	}

	@GetMapping("/user")
	public List<User> getAll() {
		return this.users;
	}

	@GetMapping("/user/{id}")
	public User getById(final @PathVariable long id) {
		return this.users.stream().filter(u -> u.getId() == id).findFirst().get();
	}

}
