package com.dfmp.monsters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {
	private List<Monster> monster;

	public MonsterController() {
		super();
		Stream.of("venon", "insect").toArray(String[]::new);
		this.monster = Arrays.asList(
				new Monster("M A.",
						Stream.of("venon", "insect").toArray(String[]::new),
						"small",
						Stream.of("forest", "fields").toArray(String[]::new),
						1,
						Stream.of("fly", "sting").toArray(String[]::new)
						),
				new Monster("M B.",
						Stream.of("venon", "insect").toArray(String[]::new),
						"small",
						Stream.of("desert", "rocks").toArray(String[]::new),
						1,
						Stream.of("grab", "sting").toArray(String[]::new)),
				new Monster("M c.",
						Stream.of("flying").toArray(String[]::new),
						"small",
						Stream.of("forest", "fields").toArray(String[]::new),
						1,
						Stream.of("fly", "peck").toArray(String[]::new))
				);
	}

	@GetMapping("/monster")
	public List<Monster> getMonster() {
		return monster;
	}
}
