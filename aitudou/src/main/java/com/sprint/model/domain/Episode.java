package com.sprint.model.domain;

/**
 * 集
 */
public class Episode {
	/*第几集*/
	private String index;
	/*视频源地址*/
	private String value;

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndex() {
		return index;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
