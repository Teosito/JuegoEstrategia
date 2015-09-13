package town.buildings.base;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import main.Options;
import menu.screen.ScreenMessage;
import messages.MessageBuild;
import town.Town;
import town.buildings.BuildingWorkshop;
import town.buildings.Mine;
import characters.base.Characters;
import characters.base.StateJob;

public abstract class BuildingOnce extends BaseBuilding{
	
	@Override
	public void build(final BaseBuilding building, final Town town, final ArrayList<Characters> habitants, boolean done){
		ScreenMessage.getMessages().add(new MessageBuild(building.getName() + " "));
		useResources(building, town);
		town.getCurrentBuilds().add(building);
		if(building.getClass().equals(new Mine().getClass())){
			Options.setStoneMine(true);
		}
		if(building.getClass().equals(new BuildingWorkshop().getClass())){
			Options.setWorkshop(true);
		}
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(town.getCurrentBuilds().size());
				for(int i = 0; i<habitants.size();i++){
					if(habitants.get(i).getJob().getClass().equals(StateJob.CONSTRUCTOR.getClass())){
						if(habitants.get(i).isExploring()==false){
							currentConstruction=currentConstruction+habitants.get(i).getConstructionCapacity();
						}
					}
					if(currentConstruction>=building.getConstructionTime()){
						building.builded(town);
						timer.cancel();
					}
					percentage = (((float)currentConstruction/(float)constructionTime)*100);
				}
			}
		}, 1,1000);

	}
	public boolean isDone() {
		return done;
	}
}
