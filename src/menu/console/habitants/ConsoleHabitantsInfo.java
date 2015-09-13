package menu.console.habitants;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import characters.base.Characters;

import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;

public class ConsoleHabitantsInfo extends ConsoleSecond{
	private Characters character;
	public ConsoleHabitantsInfo(String title, Characters character2) {
		super(title);
		this.character = character2;
	}

	@Override
	public void open(ConsoleFirst menu) {
		addComponent(new Label(character.getJobName()));
		for(int i = 0; i< character.getWorkCapacity().size();i++){
			addComponent(new Label(character.getWorkCapacity().get(i).getName() + ": " + character.getWorkCapacity().get(i).getWorkCapacity()));
		}
		addComponent(new Label("Explorer: " + String.valueOf(character.getExplorer().getExplorerCapacity())));
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
	

}
