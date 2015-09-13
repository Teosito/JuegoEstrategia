package town.buildings;

import town.Town;
import town.buildings.base.ExpandResourcesBuilding;
import town.resources.BaseResources;
import town.resources.ResourcesForBuild;

public class Barn extends ExpandResourcesBuilding{
	public Barn() {
		name = "Barn";
		addSpace = 100;
		constructionTime = 4;
		woodRequirement = 100;
		requierements.add(new ResourcesForBuild(100,BaseResources.WOOD));
		info ="Allows more food to be stored\n Wood:" + woodRequirement;
	}
	@Override
	public void builded(Town town) {
		town.setMaxFood(town.getMaxFood()+addSpace);
	}
}
