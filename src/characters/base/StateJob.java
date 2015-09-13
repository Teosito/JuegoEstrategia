package characters.base;

import items.base.ItemWorkTool;
import characters.jobs.JobBuilder;
import characters.jobs.JobFarmer;
import characters.jobs.JobStoneMiner;
import characters.jobs.JobWoodcutter;

public abstract class StateJob {
	protected int jobProduction;
	protected String name;
	protected int characterProduction;
	protected Characters character;
	public static StateJob FARMER = new JobFarmer();
	public static StateJob WOODCUTTER = new JobWoodcutter();
	public static StateJob STONEMINER = new JobStoneMiner();
	public static StateJob CONSTRUCTOR = new JobBuilder();
	public int getJobProduction() {
		return jobProduction;
	}

	public void setJobProduction(int jobProduction) {
		this.jobProduction = jobProduction;
	}

	public abstract void doJob();
	public int getCharacterProduction(int characterProduction){
		for(int i=0;i<character.getInventory().getSlots().size();i++){
			if(character.getInventory().getSlots().get(i).getItemType().getClass().equals(new ItemWorkTool().getClass())){
				return characterProduction+character.getInventory().getSlots().get(i).getCurrentItem().getUpgrade();
				
			}
		}
		return characterProduction;
	}
	public String getName() {
		return name;
	}
}
