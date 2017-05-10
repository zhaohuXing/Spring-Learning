package org.seckill.dto;

public class Exposer {
	private boolean exposed;
	private String md5;
	private long seckillId;
	private long now;
	private long start;
	private long end;

	public Exposer(boolean exposed, long seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, String md5, long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public boolean getExposed() {
		return exposed;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getMd5() {
		return md5;
	}
	
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getStart() {
		return start;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	public long getEnd() {
		return end;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getNow() {
		return now;
	}
}
