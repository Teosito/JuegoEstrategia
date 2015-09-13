package main;

import town.Town;
import world.Map;
import menu.console.OutsideWorld;

public class Options {
	private static boolean workshop = false;
	private static boolean stoneMine = false;
	private static boolean canMine = false;
	private static boolean canWorkshop = false;
	private static int maxNumberOfCraft = 5;
	private static Map map = new Map();
	private static InitiateArrays initiateThings = new InitiateArrays();
	private static int cicle = 1000;
	public static Town getTown(){
		return OutsideWorld.world.getTowns().get(0);
	}
	public static int getMaxNumberOfCraft() {
		return maxNumberOfCraft;
	}
	public static Map getMap() {
		return map;
	}
	public static InitiateArrays getInitiateThings() {
		return initiateThings;
	}
	public static void setCanMine(boolean canMine) {
		Options.canMine = canMine;
	}
	public static boolean isCanMine(){
		return canMine;
	}
	
	public static int getCicle() {
		return cicle;
	}
	public static void setCanWorkshop(boolean canWorkshop) {
		Options.canWorkshop = canWorkshop;
	}
	public static boolean isCanWorkshop(){
		return canWorkshop;
	}

	public static boolean isWorkshop() {
		return workshop;
	}

	public static void setWorkshop(boolean workshop) {
		Options.workshop = workshop;
	}

	public static boolean isStoneMine() {
		return stoneMine;
	}

	public static void setStoneMine(boolean stoneMine) {
		Options.stoneMine = stoneMine;
	}
	
}
