package com.dfmp.skills;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

	private List<Skill> skills = null;

	public SkillController() {
		super();
		this.skills = Arrays.asList(
				new Skill(1L, "fly", 50L, null, null, 0.05D, Arrays.asList(-1L, -3L)),
				new Skill(2L, "sting", 50L, null, null, 0.05D, Arrays.asList(-1L, -2L)),
				new Skill(3L, "grab", 50L, null, null, 0.05D, Arrays.asList(-2L)),
				new Skill(4L, "peck", 50L, null, null, 0.05D, Arrays.asList(-3L))
				);
	}

	@GetMapping("/skill/{id}")
	public Skill getskill(@PathVariable long id) {
		Optional<Skill> any = this.skills.stream().filter(s -> s.getId() == id).findAny();
		if (any.isPresent()) {
			return any.get();
		}
		return null;
	}

	@GetMapping("/skill/monster/{id}")
	public List<Skill> getSkillsByMonsterId(@PathVariable long id) {
		return this.skills.stream()
				.filter(s -> s.getMonsters().contains(id)).collect(Collectors.toList());
	}
}
