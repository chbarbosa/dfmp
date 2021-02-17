package com.dfmp.battles;

import java.util.Date;

abstract class Event {
	private long id;
	private Date data;
	private long targetedMonsterId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public long getTargetedMonsterId() {
		return targetedMonsterId;
	}
	public void setTargetedMonsterId(long targetedMonsterId) {
		this.targetedMonsterId = targetedMonsterId;
	}
}
