package items.work;

import items.base.ItemWorkTool;
import characters.base.StateJob;

public class Woodaxe extends ItemWorkTool{
	
	public Woodaxe() {
		itemName("Wood Axe");
		typeItem = new ItemWorkTool();
		upgrade = 1;
	}

	@Override
	public int use() {
		if(toolFor(StateJob.WOODCUTTER)){
			return upgrade;
		}
		return 0;
	}
}
