package com.ssparrow.afi.ch04graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Team {
	private String name;
	private List<Player> palyers=new LinkedList<Player>();

	public Team(String name) {
		this.name = name;
	}
	
	public List<Player> getPalyers() {
		return palyers;
	}

	public void setPalyers(List<Player> palyers) {
		this.palyers = palyers;
	}
	
	public void addPlayer(Player player){
		palyers.add(player);
		player.setTeam(this);
	}

	public ComparationResult compareTo(Team target){
		List<Player> targetPlayers = new LinkedList(target.getPalyers());
		
		if(this.palyers.size()!=targetPlayers.size()){
			return ComparationResult.INCONSISTENT;
		}
		
		Comparator<Player> palyerComparator=new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.getHeight()-o2.getHeight();
			}
		};
		
		List<Player> sourcePlayers=new LinkedList(this.palyers);

		Collections.sort(sourcePlayers, palyerComparator);
		Collections.sort(targetPlayers, palyerComparator);
		
		int sum=0;
		
		for(int index=0;index<sourcePlayers.size();index++){
			int diff = sourcePlayers.get(index).getHeight() - targetPlayers.get(index).getHeight();

			if (diff == 0) {
				continue;
			} else if (sum == 0) {
				sum = diff;
				continue;
			} else if(sum*diff<0){
				return ComparationResult.INCONSISTENT;
			} else{
				sum+=diff;
			}
		}
		
		if(sum==0){
			return ComparationResult.EQUAL;
		}else if(sum>0){
			return ComparationResult.HIGHER;
		}else{
			return ComparationResult.LOWER;
		}
		
	}
}
