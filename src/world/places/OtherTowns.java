package world.places;

import items.base.BaseItem;

import java.util.ArrayList;
import java.util.Random;

import main.TownAI;
import town.resources.BaseResources;
import town.resources.ResourcesProduction;
import characters.Names;
import characters.base.Characters;

public class OtherTowns extends BasePlaces{
	private int diplomacy;
	private String name;
	private int defense;
	private int attack;
	private ArrayList<Characters>characters = new ArrayList<Characters>();
	private ArrayList<BaseResources>resources = new ArrayList<BaseResources>();
	private ArrayList<BaseItem>inventary = new ArrayList<BaseItem>();
	private ArrayList<ResourcesProduction>resourcesProduction = new ArrayList<ResourcesProduction>();
	private TownAI townAI = new TownAI(this);
	private int maxHabitants = 5;
	public OtherTowns() {
		name = putName(Names.getTownNames());
		travelingTime = 5;
		System.out.println(name);
		startResources();
		addPeople();
		townAI.start();
	}
	
	private void startResources(){
		for(int i = 0; i<BaseResources.resources.size();i++){
			Random num = new Random();
			int production = num.nextInt((3 - 1) + 1) + 1;
			resources.add(resources.get(i));
			resourcesProduction.add(new ResourcesProduction(resources.get(i), production));
		}
		for(int i = 0; i<resources.size();i++){
			if(resources.get(i).equals(BaseResources.FOOD)){
				resources.get(i).setCantity(maxHabitants*100);
			}
		}
	}
	private void addPeople(){
		for(int i = 0; i<maxHabitants; i++){
			characters.add(new Characters(this));
		}
	}
	public int getDiplomacy() {
		return diplomacy;
	}	
	public void setDiplomacy(int diplomacy) {
		this.diplomacy = diplomacy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public ArrayList<Characters> getCharacters() {
		return characters;
	}
	public void setCharacters(ArrayList<Characters> characters) {
		this.characters = characters;
	}
	public ArrayList<BaseResources> getResources() {
		return resources;
	}
	public void setResources(ArrayList<BaseResources> resources) {
		this.resources = resources;
	}
	public ArrayList<BaseItem> getInventary() {
		return inventary;
	}
	public void setInventary(ArrayList<BaseItem> inventary) {
		this.inventary = inventary;
	}
	public ArrayList<ResourcesProduction> getResourcesProduction() {
		return resourcesProduction;
	}
	public void setResourcesProduction(
			ArrayList<ResourcesProduction> resourcesProduction) {
		this.resourcesProduction = resourcesProduction;
	}
	
	
}
