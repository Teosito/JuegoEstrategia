package menu.console.explore;

import com.googlecode.lanterna.gui.component.Button;

import characters.base.Characters;
import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class ConsoleSendExplorer extends ConsoleSecond{
	private Characters character;
	public ConsoleSendExplorer(String title, Characters character, ConsoleSecond update) {
		super(title);
		this.character = character;
		this.update = update;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(ConsoleFirst menu) {
		addComponent(new Button("Explore", Options.getInitiateThings().getMenuActions().explore(character,this)));
		addComponent(new Button("Open Map", Options.getInitiateThings().getMenuActions().openMenu(new ConsoleGoToPlace("Known Places:", character,update,this), panel, menu)));
		back();
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}

}
