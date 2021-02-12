package com.dfmp.monsters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {
	private List<Monster> monsters;

	public MonsterController() {
		super();
		this.monsters = Arrays.asList(
				new Monster("M A.",
						Stream.of("venon", "insect").toArray(String[]::new),
						"small",
						Stream.of("forest", "fields").toArray(String[]::new),
						1,
						Stream.of("fly", "sting").toArray(String[]::new)
						),
				new Monster("M B.",
						Stream.of("venon", "insect").toArray(String[]::new),
						"regular",
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
		return monsters;
	}

	@GetMapping("/monster/{location}")
	public List<Monster> getMonsterByLocation(@PathVariable String location) {
		return
				this.monsters.stream().filter(m -> this.filterByLocation(m, location)).collect(Collectors.toList());
	}
	private boolean filterByLocation(Monster m, String location) {
		return Arrays.stream(m.getLocations()).anyMatch(l -> l.equals(location));
	}
}
