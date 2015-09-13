package town.buildings.base;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import menu.screen.ScreenMessage;
import messages.MessageBuild;
import characters.base.Characters;
import characters.base.StateJob;
import town.Town;
import town.resources.ResourcesForBuild;

public abstract class BaseBuilding {
	protected boolean done;
	protected ArrayList<ResourcesForBuild>requierements = new ArrayList<ResourcesForBuild>();
	protected String name;
	protected int constructionTime;
	protected int currentConstruction = 0;
	protected boolean builded = false;
	protected int woodRequirement;
	protected String info;
	protected float percentage = 0;
	
	public int getConstructionTime() {
		return constructionTime;
	}
	public void setConstructionTime(int constructionTime) {
		this.constructionTime = constructionTime;
	}
	public void setBuilded(boolean builded) {
		this.builded = builded;
	}
	public boolean isBuilded(){
		return builded;
	}
	public ArrayList<ResourcesForBuild> getRequierements() {
		return requierements;
	}
	
	public boolean isDone() {
		return done;
	}
	protected void useResources(BaseBuilding building, Town town){
		for(int i = 0; i<building.getRequierements().size();i++){
			for(int l = 0;l<town.getResources().size();l++){
				if(building.getRequierements().get(i).getResource().getClass().equals(town.getResources().get(l).getClass())){
					town.getResources().get(l).setCantity(town.getResources().get(l).getCantity()-building.getRequierements().get(i).getCantity());
				}
			}
		}
	}
	public void build(final BaseBuilding building, final Town town, final ArrayList<Characters> habitants, boolean done){
		ScreenMessage.getMessages().add(new MessageBuild(building.getName() + " "));
		final Timer timer = new Timer();
		town.getCurrentBuilds().add(building);
		useResources(building, town);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				for(int i = 0; i<habitants.size();i++){
					if(habitants.get(i).getJob().getClass().equals(StateJob.CONSTRUCTOR.getClass())){
						if(habitants.get(i).isExploring()==false){
							currentConstruction=currentConstruction+habitants.get(i).getConstructionCapacity();
						}
					}
				}
				if(currentConstruction>=building.getConstructionTime()){
					building.builded(town);
					ScreenMessage.getMessages().add(new MessageBuild(building.name));
					timer.cancel();
				}
				percentage = (((float)currentConstruction/(float)constructionTime)*100);
				if(percentage>100){
					percentage = 100;
				}
			}
		}, 1,1000);
	}
	public abstract void builded(Town town);
	public String getName() {
		return name;
	}
	public int getWoodRequirement() {
		return woodRequirement;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getCurrentConstruction() {
		return currentConstruction;
	}
	public void setCurrentConstruction(int currentConstruction) {
		this.currentConstruction = currentConstruction;
	}
	public float getPercentage() {
		return percentage;
	}
}
