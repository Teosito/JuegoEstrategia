package main;

import items.craft.BaseCraft;
import items.craft.CraftWoodaxe;
import items.craft.CraftWoodenHoe;

import java.util.ArrayList;

import characters.base.StateJob;
import characters.jobs.JobBuilder;
import characters.jobs.JobFarmer;
import characters.jobs.JobSoldier;
import characters.jobs.JobStoneMiner;
import characters.jobs.JobWoodcutter;
import town.resources.BaseResources;
import world.places.BasePlaces;
import menu.MenuActions;

public class InitiateArrays {
	
	private static MenuActions menuActions = new MenuActions();
	private ArrayList<BasePlaces>places = new ArrayList<BasePlaces>();
	private ArrayList<BaseCraft>itemsToCraft = new ArrayList<BaseCraft>();
	private ArrayList<StateJob>jobs = new ArrayList<StateJob>();
	public InitiateArrays() {
		startItemsToCraft();
		initiateJobs();
		initiateResources();
	}
	private void initiateJobs(){
		jobs.add(new JobFarmer());
		jobs.add(new JobWoodcutter());
		jobs.add(new JobStoneMiner());
		jobs.add(new JobBuilder());
		jobs.add(new JobSoldier());
	}
	private void initiateResources(){
		BaseResources.resources.add(BaseResources.FOOD);
		BaseResources.resources.add(BaseResources.WOOD);
		BaseResources.resources.add(BaseResources.STONE);
	}
	
	private void startItemsToCraft(){
		itemsToCraft.add(new CraftWoodaxe());
		itemsToCraft.add(new CraftWoodenHoe());
	}
	public ArrayList<BaseCraft> getItemsToCraft() {
		return itemsToCraft;
	}
	public MenuActions getMenuActions() {
		return menuActions;
	}
	public ArrayList<BasePlaces> getPlaces() {
		return places;
	}
	public ArrayList<StateJob> getJobs() {
		return jobs;
	}
}
