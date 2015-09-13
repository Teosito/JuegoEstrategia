package menu.console.habitants;

import items.base.BaseItem;

import com.googlecode.lanterna.gui.component.Button;

import characters.base.Characters;
import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import menu.console.habitants.inventory.ConsoleHabitantsChangeEquipement;

public class ConsoleHabitantsInventory extends ConsoleSecond{
	private Characters character;
	public ConsoleHabitantsInventory(String title, Characters character) {
		super(title);
		this.character = character;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(ConsoleFirst menu) {
		for(int i=0;i<character.getInventory().getSlots().size();i++){
		addComponent(new Button(character.getInventory().getSlots().get(i).getPlace() + ": " + nothing(character.getInventory().getSlots().get(i).getCurrentItem())
				,Options.getInitiateThings().getMenuActions().openMenu(new ConsoleHabitantsChangeEquipement("Change Equipment",
						character,character.getInventory().getSlots().get(i).getItemType(),this), panel, menu)));
		}
		/*
		addComponent(new Button("Weapon: " + nothing(character.getInventory().getWeapon())
				,Options.getMenuActions().openMenu(new ConsoleHabitantsChangeEquipement("Change Equipment",character, new ItemWeapon()), panel, menu)));
		addComponent(new Button("Head Equipement: " + nothing(character.getInventory().getHead())
				,Options.getMenuActions().openMenu(new ConsoleHabitantsChangeEquipement("Change Equipment",character, new ItemHead()), panel, menu)));
		addComponent(new Button("Back Equipement: " + nothing(character.getInventory().getBack())
				,Options.getMenuActions().openMenu(new ConsoleHabitantsChangeEquipement("Change Equipment",character, new ItemBack()), panel, menu)));*/
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	private String nothing(BaseItem item){
		if(item==null){
		return "Nothing";
		}
		return item.getName();
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
}
