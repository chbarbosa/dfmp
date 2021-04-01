package com.dfmp.monsters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TamedMonsterVO {
	private long id;
	private long tamedByUser;
	private long level = 1L;
	private Date tamedDate;
	private Monster monster;
	private List<SkillVO> skills;
	public TamedMonsterVO(TamedMonster tamedMonster) {
		super();
		this.id = tamedMonster.getId();
		this.tamedByUser = tamedMonster.getTamedByUser();
		this.tamedDate = tamedMonster.getTamedDate();
		this.monster = tamedMonster.getMonster();
	}
	void levelUp() {
		this.level = level++;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTamedByUser() {
		return tamedByUser;
	}
	public void setTamedByUser(long tamedByUser) {
		this.tamedByUser = tamedByUser;
	}
	public Date getTamedDate() {
		return tamedDate;
	}
	public void setTamedDate(Date tamedDate) {
		this.tamedDate = tamedDate;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
	public List<SkillVO> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillVO> skills) {
		this.skills = skills;
	}
	public void add(SkillVO skill) {
		if (this.skills == null) {
			this.skills = new ArrayList<>();
		}
		this.skills.add(skill);
	}

}
