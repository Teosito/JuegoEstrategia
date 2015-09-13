package world.places;

import characters.Names;


public class Woods extends BasePlaces{
	public Woods() {
		name = putName(Names.getWoodNames());
		travelingTime = 5;
		System.out.println(name);
	}	
}
