package com.dfmp.battles;


public class BattleEvent extends Event {
	private long agressorMonsterId;
	private String skillUsed;
	private long attackForce;
	public BattleEvent() {
		super();
	}
	public BattleEvent(long agressorMonsterId, String skillUsed, long attackForce) {
		super();
		this.agressorMonsterId = agressorMonsterId;
		this.skillUsed = skillUsed;
		this.attackForce = attackForce;
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
	public long getAttackForce() {
		return attackForce;
	}
	public void setAttackForce(long attackForce) {
		this.attackForce = attackForce;
	}

}
