package world;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import main.Options;

import org.newdawn.slick.SlickException;

import characters.Names;
import town.Town;


public class ControlTowns {
	protected ArrayList<Town>towns = new ArrayList<Town>();
	protected Timer useFood = new Timer();
	protected Timer buyFood = new Timer();
	
	public ControlTowns()throws SlickException {
		Names.createNames();
		Names.createPlacesNames();
		System.out.println(Names.getWoodNames().get(0));
		towns.add(new Town(5));
		townsUseFood();
		showValues();
		System.out.println(towns.size());
	}
	
	public void createTown(int numberOfPeople){
		towns.add(new Town(numberOfPeople));
	}
	
	public void start(){
		townsUseFood();
	}
	
	public ArrayList<Town> getTowns() {
		return towns;
	}
	public void townsUseFood(){
		useFood.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(int i = 0;i<towns.size();i++){
					towns.get(i).doWork();
					towns.get(i).useFood();
				}
			}
			
		}, 1, Options.getCicle());
	}
	public void showValues(){
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(int i = 0;i<towns.size();i++){
				}
			}
		}, 1, Options.getCicle());
	}
}
