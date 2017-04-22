package com.sprint.bean.di;

public class SetterDI {
	
	private int years;
	private String ultimateAnswer;

	public void setYears(int years) {
		this.years = years;
	}

	public void setUltimateAnswer(String ultimateAnswer) {
		this.ultimateAnswer = ultimateAnswer;
	}

	@Override
	public String toString() {
		return "years:" + years + ",ultimateAnswer:" + ultimateAnswer;
	}
}
