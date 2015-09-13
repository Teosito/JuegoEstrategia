package items.craft;

import items.work.Woodaxe;

public class CraftWoodaxe extends BaseCraft{
	public CraftWoodaxe() {
		name = "Woodaxe";
		resources.add(new Woodaxe());
		timeToCraft=5;
		item = new Woodaxe();
	}
}
