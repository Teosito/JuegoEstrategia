package menu.console.habitants;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import characters.base.Characters;

import com.googlecode.lanterna.gui.component.Button;

public class ConsoleHabitantsSelected extends ConsoleSecond{
	private Characters character;
	
	public ConsoleHabitantsSelected(String title,Characters character) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public ConsoleHabitantsSelected(Characters characters) {
		super(characters.getName());
		this.character = characters;
	}

	@Override
	public void open(ConsoleFirst menu) {
		addComponent(new Button("Change Job",Options.getInitiateThings().getMenuActions().openMenu(new ConsoleChangeJob("Change Job", character), panel, menu)));
		addComponent(new Button("Inventory",Options.getInitiateThings().getMenuActions().openMenu(new ConsoleHabitantsInventory("Inventory", character), panel, menu)));
		addComponent(new Button("Info",Options.getInitiateThings().getMenuActions().openMenu(new ConsoleHabitantsInfo("Info", character), panel, menu)));
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
}