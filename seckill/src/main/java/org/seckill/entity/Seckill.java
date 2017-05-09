package org.seckill.entity;

import java.util.Date;
public class Seckill {
	private long seckillId;
	private String name;
	private int number;
	private Date startTime;
	private Date endTime;
	private Date createTime;

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
	
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "Seckill{" +
			"seckillId=" + seckillId +
			", name=" + name +
			", number=" + number +
			", startTime=" + startTime +
			", entTime=" + endTime + 
			", createTime=" + createTime +
			"}";
	}
}
