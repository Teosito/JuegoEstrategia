package characters.inventory;


import java.util.ArrayList;

import characters.base.Characters;
import characters.inventory.slots.CharacterSlots;
import items.base.BaseItem;
import items.base.ItemHead;
import items.base.ItemWeapon;
import items.base.ItemWorkTool;

public class InventoryCharacter {
	private ArrayList<CharacterSlots>slots = new ArrayList<CharacterSlots>();
	
	public InventoryCharacter() {
		slots.add(new CharacterSlots(new ItemHead(), "Head"));
		slots.add(new CharacterSlots(new ItemWeapon(), "Weapon"));
		slots.add(new CharacterSlots(new ItemWorkTool(), "Tool"));
	}
	public void changeEquipment(Characters character, BaseItem item){
		for(int i = 0; i<character.getTown().getTownInventary().size();i++){
			if(character.getTown().getTownInventary().get(i)==item){
				character.getTown().getTownInventary().remove(i);
				break;
			}
		}
		for(int i = 0; i< character.getInventory().getSlots().size();i++){
			if(character.getInventory().getSlots().get(i).getItemType().getClass().equals(item.getTypeItem().getClass())){
					character.getTown().getTownInventary().add(character.getInventory().getSlots().get(i).getCurrentItem());
				character.getInventory().getSlots().get(i).setCurrentItem(item);
				item.setCharacter(character);
				System.out.println(character.getInventory().getSlots().get(i).getCurrentItem().getName());
				break;
			}
		}
	}
	
	public ArrayList<CharacterSlots> getSlots() {
		return slots;
	}
	
}
