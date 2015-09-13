package characters;

import java.util.ArrayList;

public class Names {
	private static ArrayList<String>names = new ArrayList<String>();
	private static ArrayList<String>lastNames = new ArrayList<String>();
	private static ArrayList<String>woodNames = new ArrayList<String>();
	private static ArrayList<String>townNames = new ArrayList<String>();
	
	public static void createNames(){
		names.add("Juan");
		names.add("Anto");
		names.add("Thore");
		names.add("Joseph");
		names.add("Adi");
		names.add("Tiernan");
		names.add("Adam");
		names.add("Dafina");
		names.add("Clarisa");
		lastNames.add("Lakeisha");
		lastNames.add("Kazmer");
		lastNames.add("Eardwulf");
		lastNames.add("Nika");
		lastNames.add("Kapono");
		lastNames.add("Raharjo");
		}
	public static void createPlacesNames(){
		woodNames.add("Woods");
		townNames.add("Town");
	}
	public static ArrayList<String> getWoodNames() {
		return woodNames;
	}
	public static ArrayList<String> getNames() {
		return names;
	}
	public static ArrayList<String> getLastNames() {
		return lastNames;
	}
	public static ArrayList<String> getTownNames() {
		return townNames;
	}
}