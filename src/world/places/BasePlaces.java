package world.places;

import items.base.BaseItem;

import java.util.ArrayList;
import java.util.Random;


public abstract class BasePlaces {
	protected ArrayList<BaseItem>rewards = new ArrayList<BaseItem>();
	protected String name;
	protected int danger;
	protected int travelingTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDanger() {
		return danger;
	}
	public void setDanger(int danger) {
		this.danger = danger;
	}
	public int getTravelingTime() {
		return travelingTime;
	}
	public void setTravelingTime(int travelingTime) {
		this.travelingTime = travelingTime;
	}
	public ArrayList<BaseItem> getRewards() {
		return rewards;
	}
	public void setRewards(ArrayList<BaseItem> rewards) {
		this.rewards = rewards;
	}
	protected String putName(ArrayList<String>putName){
		Random rand = new Random();
		int randomNum = rand.nextInt((putName.size() - 1) + 1) + 1;
		return putName.get(randomNum-1);
	}
	
	

}