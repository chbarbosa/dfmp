package com.dfmp.skills;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

	private List<Skill> skills = null;

	public SkillController() {
		super();
		this.skills = Arrays.asList(
				new Skill(1L, "", 50L, null, null, 0.05D));
	}


}
