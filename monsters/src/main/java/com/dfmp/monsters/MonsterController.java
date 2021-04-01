package com.dfmp.monsters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dfmp.monsters.clients.SkillClient;

@RestController
public class MonsterController {
	private List<Monster> monsters;
	private List<TamedMonster> tamedMonsters;
	private Monster monsterExample;
	@Value("${NUM_THREADS}")
	private int numThreads;
	@Autowired
	private SkillClient skillClient;

	public MonsterController() {
		super();
		monsterExample = new Monster(-1L, "M A.",
				Stream.of("venon", "insect").toArray(String[]::new),
				"small",
				Stream.of("forest", "fields").toArray(String[]::new),
				1,
				Arrays.asList(1L, 2L, 3L, 4L)
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
				new TamedMonster(-1L, 10L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-2L, 10L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-3L, 10L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-4L, 20L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-5L, 20L, Calendar.getInstance().getTime(), monsterExample),
				new TamedMonster(-6L, 30L, Calendar.getInstance().getTime(), monsterExample)
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
	public List<TamedMonsterVO> getTamedMonsterByUserID(@PathVariable long user) throws InterruptedException, ExecutionException {
		List<TamedMonsterVO> tms = this.tamedMonsters.stream().filter(tm -> tm.getTamedByUser() == user)
				.map(TamedMonsterVO::new).collect(Collectors.toList());
		List<Future<TamedMonsterVO>> futures = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
		tms.forEach(vo ->
			futures.addAll(vo.getMonster().getSkills().stream()
					.map(s -> executorService.submit(() -> recSkill(vo, s))).collect(Collectors.toList()))
		);
		executorService.awaitTermination(750, TimeUnit.MILLISECONDS);
		Set<TamedMonsterVO> result = new HashSet<>();
		for (Future<TamedMonsterVO> f : futures) {
			result.add(f.get());
		}
		return List.copyOf(result);
	}

	private TamedMonsterVO recSkill(TamedMonsterVO vo, Long skillId) {
		vo.add(this.skillClient.getSkill(skillId));
		System.out.println("recuperado " + skillId);
		return vo;
	}
}
