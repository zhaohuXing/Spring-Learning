package org.seckill.entity;

import java.util.Date;
public class SuccessKilled {
	private long seckillId;
	private long userPhone;
	private short state;
	private Date createTime;

	private Seckill seckill;

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setState(short state) {
		this.state = state;
	}

	public short getState() {
		return state;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}
}
