package items.work;

import items.base.ItemWorkTool;
import characters.base.StateJob;

public class WoodenHoe extends ItemWorkTool{
	public WoodenHoe() {
		itemName("Wooden Hoe");
		typeItem = new ItemWorkTool();
		upgrade = 1;
	}

	@Override
	public int use() {
		if(toolFor(StateJob.FARMER)){
			return upgrade;
		}
		return 0;
	}
}

