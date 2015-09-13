package town.buildings;

import town.Town;
import town.buildings.base.ExpandResourcesBuilding;
import town.resources.BaseResources;
import town.resources.ResourcesForBuild;

public class House extends ExpandResourcesBuilding{
	public House() {
		name = "House";
		addSpace=2;
		woodRequirement=50;
		constructionTime=5;
		info="Allows your town to have more people\n Wood: "+ woodRequirement;	
		requierements.add(new ResourcesForBuild(50, BaseResources.WOOD));
	}
	@Override
	public void builded(Town town) {
		town.setMaxHabitants(town.getMaxHabitants()+addSpace);
	}
}
