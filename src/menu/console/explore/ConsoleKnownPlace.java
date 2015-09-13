package menu.console.explore;

import world.places.BasePlaces;

import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;

import characters.base.Characters;
import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class ConsoleKnownPlace extends ConsoleSecond{
	private Characters character;
	private BasePlaces place;
	private ConsoleSecond update2;
	private ConsoleSecond update3;
	public ConsoleKnownPlace(String title, Characters character, BasePlaces place,ConsoleSecond update,ConsoleSecond update2,ConsoleSecond update3) {
		super(title);
		this.character = character;
		this.place = place;
		this.update=update;
		this.update2=update2;
		this.update3=update3;
	}

	@Override
	public void open(ConsoleFirst menu) {
		addComponent(new Label(place.getName()));
		addComponent(new Label(String.valueOf(place.getDanger())));
		addComponent(new Label("Traveling time: " + String.valueOf(place.getTravelingTime())));
		addComponent(new Button("Go",Options.getInitiateThings().getMenuActions().sendToPlace(character, this, place,update,update2,update3)));
		back();
	}

}
