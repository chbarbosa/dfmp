package com.dfmp.monsters;

import java.util.List;

public class Monster {
	private long id;
	private String name;
	private String[] type;
	private String size;
	private String[] locations;
	private Integer force;
	private List<Long> skills;

	public Monster() {
		super();
	}

	public Monster(long id, String name, String[] type, String size, String[] locations, Integer force,
			List<Long> skills) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.locations = locations;
		this.force = force;
		this.skills = skills;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

	public Integer getForce() {
		return force;
	}

	public void setForce(Integer force) {
		this.force = force;
	}

	public List<Long> getSkills() {
		return skills;
	}

	public void setSkills(List<Long> skills) {
		this.skills = skills;
	}

}
