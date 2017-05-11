package org.seckill.dto;

public class SeckillResult<T> {
	private boolean success;
	private T data;
	private String error;

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}
