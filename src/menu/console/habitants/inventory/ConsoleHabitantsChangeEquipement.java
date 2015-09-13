package menu.console.habitants.inventory;


import items.Nothing;
import items.base.BaseItem;
import characters.base.Characters;

import com.googlecode.lanterna.gui.component.Button;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class ConsoleHabitantsChangeEquipement extends ConsoleSecond{
	protected BaseItem itemType;
	protected Characters character;
	public ConsoleHabitantsChangeEquipement(String title, Characters character, BaseItem itemType, ConsoleSecond update) {
		super(title);
		this.itemType = itemType;
		this.character=character;
		this.update = update;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(ConsoleFirst menu) {
		for(int i = 0;i<Options.getTown().getTownInventary().size();i++){
			if(Options.getTown().getTownInventary().get(i).getClass().getSuperclass().equals(itemType.getClass())){
				addComponent(new Button(Options.getTown().getTownInventary().get(i).getName()
						,Options.getInitiateThings().getMenuActions().changeEquipment(character,
								Options.getTown().getTownInventary().get(i),this)));
			}
		}
		addComponent(new Button("Nothing", Options.getInitiateThings().getMenuActions().changeEquipment(character, new Nothing(), this)));
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
}
