package com.dfmp.monsters;

import java.util.Date;

public class TamedMonster {
	private long id;
	private long tamedByUser;
	private long level = 1L;
	private Date tamedDate;
	private Monster monster;
	public TamedMonster() {
		super();
	}
	public TamedMonster(long id, long tamedByUser, Date tamedDate, Monster monster) {
		super();
		this.id = id;
		this.tamedByUser = tamedByUser;
		this.tamedDate = tamedDate;
		this.monster = monster;
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

}
