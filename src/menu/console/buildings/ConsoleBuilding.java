package menu.console.buildings;

import town.buildings.Barn;
import town.buildings.BuildingWorkshop;
import town.buildings.House;
import town.buildings.Mine;
import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

import com.googlecode.lanterna.gui.component.Button;

public class ConsoleBuilding extends ConsoleSecond{
	private Button stoneMine;
	public ConsoleBuilding(String title) {
		super(title);
		stoneMine = new Button("Stone Mine", Options.getInitiateThings().getMenuActions().openInfoMenu(new ConsoleBuildingInfo("Stone mine", new Mine(),this), panel, menu, new Mine(),this));
	}
	@Override
	public void open(ConsoleFirst menu) {
		open = true;
		addComponent(new Button("Barn",Options.getInitiateThings().getMenuActions().openInfoMenu(new ConsoleBuildingInfo("Barn",new Barn(),this), panel, menu, new Barn())));
		if(Options.isStoneMine()==false){
			addComponent(stoneMine);
		}
		addComponent(new Button("Simple House", Options.getInitiateThings().getMenuActions().openInfoMenu(new ConsoleBuildingInfo("Simple house", new House(),this), panel, menu, new House())));
		if(Options.isWorkshop()==false){
			addComponent(new Button("Workshop", Options.getInitiateThings().getMenuActions().openInfoMenu(new ConsoleBuildingInfo("Workshop", new BuildingWorkshop(),this), panel, menu, new BuildingWorkshop(),this)));
		}
		addComponent(new Button("Close",Options.getInitiateThings().getMenuActions().close(this)));
		
	}
	public void close(ConsoleSecond console){
		removeAllComponents();
		close();
	}
}
