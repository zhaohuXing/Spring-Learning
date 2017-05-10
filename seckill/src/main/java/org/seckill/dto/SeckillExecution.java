package org.seckill.dto;

import org.seckill.enums.SeckillStateEnum;
import org.seckill.entity.SuccessKilled;
public class SeckillExecution {
	private long seckillId;
	private int state;
	private String stateInfo;
	private SuccessKilled successKilled;
	
	/**
	 * 秒杀失败构造器
	 */
	public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 秒杀成功构造器
	 */
	public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
		this(seckillId, stateEnum);
		this.successKilled = successKilled;
	}
	//setter getter
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setState(int state) {
		this.state = state;
	}


	public int getState() {
		return state;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public String  getStateInfo() {
		return stateInfo;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
}
