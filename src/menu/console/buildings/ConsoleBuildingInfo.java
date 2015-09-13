package menu.console.buildings;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import menu.console.OutsideWorld;
import town.buildings.base.BaseBuilding;

import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;

public class ConsoleBuildingInfo extends ConsoleSecond{

	public ConsoleBuildingInfo(String title, BaseBuilding building, ConsoleSecond update) {
		super(title);
		this.update = update;
		addComponent(new Label(building.getInfo()));
		addComponent(new Button("Build",Options.getInitiateThings().getMenuActions().build(OutsideWorld.world.getTowns().get(0),building,this)));
		addComponent(new Button("Close",Options.getInitiateThings().getMenuActions().close(this)));
	}

	@Override
	public void open(ConsoleFirst menu) {
		open = true;		
	}
}
