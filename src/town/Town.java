package town;

import items.base.BaseItem;
import items.head.LeatherHelmet;
import items.work.Woodaxe;
import items.work.WoodenHoe;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import town.buildings.base.BaseBuilding;
import town.resources.BaseResources;
import town.resources.Food;
import town.resources.Stone;
import town.resources.Wood;
import characters.Names;
import characters.base.Characters;

public class Town {
	private ArrayList<Characters>townHabitant = new ArrayList<Characters>();
	private ArrayList<BaseItem>townInventary = new ArrayList<BaseItem>();
	private ArrayList<BaseResources>resources = new ArrayList<BaseResources>();
	private ArrayList<BaseBuilding>currentBuilds = new ArrayList<BaseBuilding>();
	private char townName;
	private int maxFood = 500;
	private int foodProductionCapacity=2;
	private int foodProduction = 0;
	private int woodProduction = 0;
	private int woodProductionCapacity = 1;
	private int stoneProduction = 0;
	private int stoneProductionCapacity = 1;
	private int maxStone = 100;
	private int maxHabitants = 4;
	private int secondsBeforeNewHabitant = 1;
	private int niceTown = 20;
	
	
	protected boolean buyingFood = false;
	public Town(int numberOfHabitants) {
		townInventary.add(new LeatherHelmet());
		townInventary.add(new Woodaxe());
		townInventary.add(new WoodenHoe());
		resources.add(new Food());
		resources.add(new Wood());
		resources.add(new Stone());
		
		for(int i=0;i<numberOfHabitants;i++){
			townHabitant.add(new Characters(this));
			setNames(i);
			//setSkills(townHabitant.get(i));
		}
		getResources(new Food()).setCantity(townHabitant.get(0).getFoodConsumption()*townHabitant.size()*100);
	}
	public BaseResources getResources(BaseResources resource){
		for(int i = 0; i< resources.size();i++){
			if(resources.get(i).getClass().equals(resource.getClass())){
				return resources.get(i);
			}
		}
		return null;
	}
	public void addNewHabitant(){
		Characters habitant = new Characters(this);
		townHabitant.add(habitant);
		setNames(townHabitant.size()-1);
	}
	
	public void newHabitant(){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("lele");
				int random = (int) (Math.random()*100-0);
				if(random<niceTown){
					addNewHabitant();
				}
			}
		}, secondsBeforeNewHabitant*1000);
	}
	public void useFood(){
		if(townHabitant.size()<maxHabitants){
			System.out.println(maxHabitants);
			newHabitant();
		}
		for(int i = 0;i<townHabitant.size();i++){
			if(i>maxHabitants){
				townHabitant.remove(i);
				i--;
			}
		}
		for(int i=0;i<townHabitant.size();i++){
			if(getResources(BaseResources.FOOD).getCantity()>=townHabitant.get(i).getFoodConsumption()){
				getResources(BaseResources.FOOD).setCantity(getResources(BaseResources.FOOD).getCantity()-townHabitant.get(i).getFoodConsumption());
			}
			else{
				townHabitant.remove(i);
				i--;
			}
		}
	}
	public void doWork(){
		for(int i = 0; i<townHabitant.size();i++){
			if(townHabitant.get(i).isExploring()==false){
				townHabitant.get(i).getJob().doJob();
			}
		}
		getResources(BaseResources.FOOD).setCantity(getResources(BaseResources.FOOD).getCantity()+foodProduction);
		getResources(BaseResources.WOOD).setCantity(getResources(BaseResources.WOOD).getCantity()+woodProduction);
		getResources(BaseResources.STONE).setCantity(getResources(BaseResources.STONE).getCantity()+stoneProduction);
		
		if(getResources(new Food()).getCantity()>maxFood){
			getResources(new Food()).setCantity(maxFood);
		}
		foodProduction = 0;
		stoneProduction = 0;
		woodProduction = 0;
		for(int i = 0; i<currentBuilds.size();i++){
			if(currentBuilds.get(i).getPercentage()>=100){
				currentBuilds.remove(i);
			}
		}
	}
	public void setNames(int i){
		townHabitant.get(i).setName(Names.getNames().get((1 + (int)(Math.random()*Names.getNames().size()))-1 )+" "+
				Names.getLastNames().get((1 + (int)(Math.random()*Names.getLastNames().size()))-1));
	}
	public ArrayList<BaseBuilding> getCurrentBuilds() {
		return currentBuilds;
	}
	public ArrayList<BaseItem> getTownInventary() {
		return townInventary;
	}
	public char getTownName() {
		return townName;
	}
	public void setTownName(char townName) {
		this.townName = townName;
	}
	public ArrayList<Characters> getTownHabitant() {
		return townHabitant;
	}
	public void setTownHabitant(ArrayList<Characters> townHabitant) {
		this.townHabitant = townHabitant;
	}
	public int getFoodProductionCapacity() {
		return foodProductionCapacity;
	}
	public void setFoodProductionCapacity(int foodProductionCapacity) {
		this.foodProductionCapacity = foodProductionCapacity;
	}
	public int getFoodProduction() {
		return foodProduction;
	}
	public void setFoodProduction(int foodProduction) {
		this.foodProduction = foodProduction;
	}
	public boolean isBuyingFood() {
		return buyingFood;
	}
	public void setBuyingFood(boolean buyingFood) {
		this.buyingFood = buyingFood;
	}
	public int getWoodProduction() {
		return woodProduction;
	}
	public void setWoodProduction(int woodProduction) {
		this.woodProduction = woodProduction;
	}
	public int getWoodProductionCapacity() {
		return woodProductionCapacity;
	}
	public void setWoodProductionCapacity(int woodProductionCapacity) {
		this.woodProductionCapacity = woodProductionCapacity;
	}
	public void setMaxFood(int maxFood) {
		this.maxFood = maxFood;
	}
	public int getMaxFood() {
		return maxFood;
	}
	public int getMaxStone() {
		return maxStone;
	}
	public void setMaxStone(int maxStone) {
		this.maxStone = maxStone;
	}
	public int getStoneProduction() {
		return stoneProduction;
	}
	public void setStoneProduction(int stoneProduction) {
		this.stoneProduction = stoneProduction;
	}
	public int getStoneProductionCapacity() {
		return stoneProductionCapacity;
	}
	public void setStoneProductionCapacity(int stoneProductionCapacity) {
		this.stoneProductionCapacity = stoneProductionCapacity;
	}
	public ArrayList<BaseResources> getResources(){
		return resources;
	}
	public void setMaxHabitants(int maxHabitants) {
		this.maxHabitants = maxHabitants;
	}
	public int getMaxHabitants() {
		return maxHabitants;
	}
}
