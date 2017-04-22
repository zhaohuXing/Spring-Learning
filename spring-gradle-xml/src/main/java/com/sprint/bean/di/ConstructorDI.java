package com.sprint.bean.di;

public class ConstructorDI {
	private int years;
	private String ultimateAnswer;

	public ConstructorDI(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}

	@Override
	public String toString() {
		return "years:" + years + ",ultimateAnswer:" + ultimateAnswer;
	}
}
