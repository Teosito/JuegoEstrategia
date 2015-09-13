package world;

import java.util.ArrayList;

import world.places.BasePlaces;

public class Map {
	private ArrayList<BasePlaces>placesToGo = new ArrayList<BasePlaces>();
	public Map() {
		
	}
	public ArrayList<BasePlaces> getPlacesToGo() {
		return placesToGo;
	}

}
