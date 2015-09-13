package town.buildings;

import main.Options;
import town.Town;
import town.buildings.base.BuildingOnce;
import town.resources.BaseResources;
import town.resources.ResourcesForBuild;

public class BuildingWorkshop extends BuildingOnce{

	public BuildingWorkshop() {
		done = Options.isWorkshop();
		name = "Workshop";
		constructionTime = 1;
		info = "Allows the construction of weapon and tools\n Wood: " + 200 + "\n Stone: " + 150;
		requierements.add(new ResourcesForBuild(0, BaseResources.WOOD));
		requierements.add(new ResourcesForBuild(0, BaseResources.STONE));
	}
	@Override
	public void builded(Town town) {
		Options.setCanWorkshop(true);
	}
}
