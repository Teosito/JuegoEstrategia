package town.buildings;

import main.Options;
import town.Town;
import town.buildings.base.BuildingOnce;
import town.resources.BaseResources;
import town.resources.ResourcesForBuild;

public class Mine extends BuildingOnce{
	public Mine() {
		done = Options.isStoneMine();
		name = "Stone Mine";
		constructionTime = 10;
		woodRequirement = 50;
		info="Allows your habitants to mine stone\n Wood: " + woodRequirement;
		requierements.add(new ResourcesForBuild(50, BaseResources.WOOD));
	}
	@Override
	public void builded(Town town) {
		Options.setCanMine(true);
	}
}
