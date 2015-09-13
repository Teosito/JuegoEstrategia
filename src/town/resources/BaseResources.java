package town.resources;

import java.util.ArrayList;

public abstract class BaseResources {
	protected int cantity;
	protected String name;

	public static Food FOOD = new Food();
	public static Wood WOOD = new Wood();
	public static Stone STONE= new Stone();
	public static ArrayList<BaseResources> resources = new ArrayList<BaseResources>();
	public int getCantity() {
		return cantity;
	}
	public void setCantity(int cantity) {
		this.cantity = cantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
