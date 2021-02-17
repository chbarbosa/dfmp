package com.dfmp.battles;

import java.util.Calendar;

public class BattleEvent extends Event {
	private long agressorMonsterId;
	private String skillUsed;
	private long attackDamage;
	public BattleEvent() {
		super();
	}
	public BattleEvent(long targetedMonsterId, long agressorMonsterId, String skillUsed, long attackDamage) {
		super();
		this.setData(Calendar.getInstance().getTime());
		this.setTargetedMonsterId(targetedMonsterId);
		this.agressorMonsterId = agressorMonsterId;
		this.skillUsed = skillUsed;
		this.attackDamage = attackDamage;
	}
	public long getAgressorMonsterId() {
		return agressorMonsterId;
	}
	public void setAgressorMonsterId(long agressorMonsterId) {
		this.agressorMonsterId = agressorMonsterId;
	}
	public String getSkillUsed() {
		return skillUsed;
	}
	public void setSkillUsed(String skillUsed) {
		this.skillUsed = skillUsed;
	}
	public long getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(long attackDamage) {
		this.attackDamage = attackDamage;
	}

}
