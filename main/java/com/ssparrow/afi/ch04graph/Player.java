package com.ssparrow.afi.ch04graph;

public class Player {
	private Team team;
	private String name;
	private int height;
	
	
	public Player(String name) {
		this.name = name;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getName() {
		return name;
	}
	
	
}
