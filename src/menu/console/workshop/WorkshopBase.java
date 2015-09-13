package menu.console.workshop;

import items.base.BaseItem;

import java.util.ArrayList;

import com.googlecode.lanterna.gui.component.Button;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class WorkshopBase extends ConsoleSecond{
	private ArrayList<BaseItem>items = new ArrayList<BaseItem>();
	public WorkshopBase(String title, int numberOfItems) {
		super(title);
	}

	@Override
	public void open(ConsoleFirst menu) {
		items = new ArrayList<BaseItem>();
		for(int i = 0; i<Options.getTown().getTownInventary().size();i++){
			addComponent(new Button(Options.getTown().getTownInventary().get(i).getName(),Options.getInitiateThings().getMenuActions().craft(items, Options.getTown().getTownInventary().get(i))));
		}
		addComponent(new Button("Craft",Options.getInitiateThings().getMenuActions().doCraft(items,this,Options.getTown())));
		back();
	}
	@Override
	public void close(){
		removeAllComponents();
		super.close();
	}
	public ArrayList<BaseItem> getItems() {
		return items;
	}
}
