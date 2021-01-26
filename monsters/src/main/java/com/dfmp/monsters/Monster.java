package com.dfmp.monsters;

public class Monster {
	private String name;
	private String[] type;
	private String size;
	private String[] locations;
	private Integer force;
	private String[] skills;

	public Monster() {
		super();
	}

	public Monster(String name, String[] type, String size, String[] locations, Integer force, String[] skills) {
		super();
		this.name = name;
		this.type = type;
		this.size = size;
		this.locations = locations;
		this.force = force;
		this.skills = skills;
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

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

}
