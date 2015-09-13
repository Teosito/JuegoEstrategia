package menu.console;


import main.Options;
import menu.MenuActions;

import org.newdawn.slick.SlickException;

import world.ControlTowns;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;

public class OutsideWorld {
	private ConsoleFirst console;
	public static GUIScreen gui;
	private MenuActions menuActions;
	public static ControlTowns world;
		public OutsideWorld()throws SlickException {
			world = new ControlTowns();
			console = new ConsoleFirst("Town");
			menuActions = new MenuActions();
			Options.getInitiateThings().getMenuActions().setMenu(console);
			gui = TerminalFacade.createGUIScreen();
			gui.getScreen().startScreen();
			gui.showWindow(console, GUIScreen.Position.FULL_SCREEN);
			gui.showWindow(console);
			gui.getScreen().stopScreen();

	}
		
		public MenuActions getMenuActions() {
			return menuActions;
		}
		
}
