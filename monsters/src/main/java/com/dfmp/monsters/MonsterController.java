package com.dfmp.monsters;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {
	private List<Monster> monsters;
	private List<TamedMonster> tamedMonsters;
	private Monster monsterExample;

	public MonsterController() {
		super();
		monsterExample = new Monster(-1L, "M A.",
				Stream.of("venon", "insect").toArray(String[]::new),
				"small",
				Stream.of("forest", "fields").toArray(String[]::new),
				1,
				Arrays.asList(1L, 2L)
				);
		this.monsters = Arrays.asList(
				monsterExample,
				new Monster(-2L, "M B.",
						Stream.of("venon", "insect").toArray(String[]::new),
						"regular",
						Stream.of("desert", "rocks").toArray(String[]::new),
						1,
						Arrays.asList(3L, 2L)),
				new Monster(-3L, "M c.",
						Stream.of("flying").toArray(String[]::new),
						"small",
						Stream.of("forest", "fields").toArray(String[]::new),
						1,
						Arrays.asList(1L, 4L))
				);
		this.tamedMonsters = Arrays.asList(
				new TamedMonster(-1L, -1L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-2L, -1L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-3L, -1L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-4L, -2L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-5L, -2L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-6L, -3L, Calendar.getInstance().getTime(), monsterExample)
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

	@GetMapping("/monster/tamed/{user}")
	public List<TamedMonster> getTamedMonsterByUserID(@PathVariable long user) {
		return this.tamedMonsters.stream()
				.filter(tm -> tm.getTamedByUser() == user).collect(Collectors.toList());
	}
}
