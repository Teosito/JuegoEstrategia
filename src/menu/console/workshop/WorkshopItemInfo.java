package menu.console.workshop;

import items.craft.BaseCraft;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class WorkshopItemInfo extends ConsoleSecond{
	private BaseCraft craft;
	public WorkshopItemInfo(String title,BaseCraft craft, ConsoleSecond update) {
		super(title);
		this.craft = craft;
		
	}

	@Override
	public void open(ConsoleFirst menu) {
		// TODO Auto-generated method stub
		
	}
	public BaseCraft getCraft() {
		return craft;
	}

}
