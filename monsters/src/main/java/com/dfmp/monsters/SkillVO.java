package com.dfmp.monsters;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SkillVO {
	private long id;
	private String description;
	private Date creation;
	private Date lastModification;
	private Long force;
	private Long heal;
	private String status;
	private double levelMultiplier;
	private List<Long> monsters;
	public SkillVO(long id, String description, Long force, Long heal,
			String status, double levelMultiplier, List<Long> monsters) {
		super();
		this.id = id;
		this.description = description;
		this.creation = Calendar.getInstance().getTime();
		this.force = force;
		this.heal = heal;
		this.status = status;
		this.levelMultiplier = levelMultiplier;
		this.monsters = monsters;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Date getLastModification() {
		return lastModification;
	}
	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}
	public Long getForce() {
		return force;
	}
	public void setForce(Long force) {
		this.force = force;
	}
	public Long getHeal() {
		return heal;
	}
	public void setHeal(Long heal) {
		this.heal = heal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getLevelMultiplier() {
		return levelMultiplier;
	}
	public void setLevelMultiplier(double levelMultiplier) {
		this.levelMultiplier = levelMultiplier;
	}
	public List<Long> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<Long> monsters) {
		this.monsters = monsters;
	}

}
