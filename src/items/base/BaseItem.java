package items.base;

import characters.base.Characters;

public abstract class BaseItem {
	protected BaseItem typeItem;
	protected int upgrade;
	protected String name;
	protected Characters character;
	
	
	public abstract int use();
	public String getName() {
		return name;
	}
	public int getUpgrade() {
		return upgrade;
	}
	public void itemName(String name){
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BaseItem getTypeItem() {
		return typeItem;
	}
	public void setCharacter(Characters character) {
		this.character = character;
	}
}
