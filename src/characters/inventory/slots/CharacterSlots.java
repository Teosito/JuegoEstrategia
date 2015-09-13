package characters.inventory.slots;

import items.Nothing;
import items.base.BaseItem;


public class CharacterSlots {
	private BaseItem itemType;
	private String place;
	private BaseItem currentItem = new Nothing();
	public CharacterSlots(BaseItem itemType, String place) {
		this.place = place;
		this.itemType = itemType;
		
	}
	public BaseItem getItemType() {
		return itemType;
	}
	public String getPlace() {
		return place;
	}
	public BaseItem getCurrentItem() {
		return currentItem;
	}
	public void setCurrentItem(BaseItem currentItem) {
		this.currentItem = currentItem;
	}
}
