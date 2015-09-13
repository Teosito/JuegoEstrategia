package menu.console;

import com.googlecode.lanterna.gui.component.Button;

import main.Options;
import menu.screen.ScreenCurrentBuildings;
import menu.screen.ScreenMessage;
import menu.screen.ScreenResources;

public class ConsoleScreenMenu extends ConsoleSecond{

	private ScreenMessage messages;
	private ScreenResources resources;
	private ScreenCurrentBuildings currentBuildings;
	
	public ConsoleScreenMenu(String title) {
		super(title);
		currentBuildings = new ScreenCurrentBuildings("Current Buildings");
		messages = new ScreenMessage("Messages");
		resources = new ScreenResources("Resources");
	}

	@Override
	public void open(ConsoleFirst menu) {
		addComponent(new Button("Resources", Options.getInitiateThings().getMenuActions().openMenu(resources)));
		addComponent(new Button("Messages",Options.getInitiateThings().getMenuActions().openMenu(messages)));
		addComponent(new Button("Current Buildings", Options.getInitiateThings().getMenuActions().openMenu(currentBuildings)));
		back();
	}

}
