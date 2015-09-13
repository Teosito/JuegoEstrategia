package menu.console.explore;

import com.googlecode.lanterna.gui.component.Button;

import characters.base.Characters;
import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class ConsoleGoToPlace extends ConsoleSecond{
	private Characters character;
	private ConsoleSecond update2;
	public ConsoleGoToPlace(String title, Characters character,ConsoleSecond update,ConsoleSecond update2) {
		super(title);
		this.character = character;
		this.update = update;
		this.update2=update2;
		
	}

	@Override
	public void open(ConsoleFirst menu) {
		for(int i = 0; i<Options.getMap().getPlacesToGo().size();i++){
			addComponent(new Button(Options.getMap().getPlacesToGo().get(i).getName(),Options.getInitiateThings().getMenuActions().openMenu(
					new ConsoleKnownPlace(Options.getMap().getPlacesToGo().get(i).getName(), character, Options.getMap().getPlacesToGo().get(i),update,update2,this), panel, menu)));
		}
		back();
	}
	@Override
	public void close(){
			removeAllComponents();
			setOpen(false);
			super.close();
	}
}