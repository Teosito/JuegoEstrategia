package items.craft;

import items.work.WoodenHoe;

public class CraftWoodenHoe extends BaseCraft{
	public CraftWoodenHoe() {
		name = "Woodaxe";
		resources.add(new WoodenHoe());
		timeToCraft=5;
		item = new WoodenHoe();
	}
}
