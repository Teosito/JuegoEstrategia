package menu.console;

import main.Options;
import menu.console.buildings.ConsoleBuilding;
import menu.console.explore.ConsoleExplore;
import menu.console.habitants.ConsoleHabitants;
import menu.console.workshop.WorkshopBase;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Button;


public class ConsoleFirst extends Window{
	private ConsoleHabitants habitants;
	private ConsoleBuilding building;
	private ConsoleExplore explore;
	private ConsoleScreenMenu screenMenu;
	private WorkshopBase workshop = new WorkshopBase("Select Items: ", 0);
	private Panel panel;
	private Panel firstRow;
	public ConsoleFirst(String title) {
		super(title);
		screenMenu = new ConsoleScreenMenu("Info");
		habitants = new ConsoleHabitants("Habitants");
		building = new ConsoleBuilding("Build");
		explore = new ConsoleExplore("Explore");
		panel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
		firstRow = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);
		firstRow.setVisible(true);
		panel.setVisible(true);
		update();
		addComponent(panel);
		addComponent(firstRow);
	}	
	
	public void update(){
		firstRow.removeAllComponents();
		firstRow.addComponent(new Button("Habitants", Options.getInitiateThings().getMenuActions().openMenu(habitants, firstRow,this)));
		firstRow.addComponent(new Button("Build", Options.getInitiateThings().getMenuActions().openMenu(building, firstRow, this)));
		firstRow.addComponent(new Button("Explore", Options.getInitiateThings().getMenuActions().openMenu(explore, firstRow, this)));
		if(Options.isCanWorkshop()){
			firstRow.addComponent(new Button("Workshop", Options.getInitiateThings().getMenuActions().openMenu(workshop, panel, this)));
		}
		firstRow.addComponent(new Button("Info", Options.getInitiateThings().getMenuActions().openMenu(screenMenu, panel, this)));
		
		firstRow.addComponent(new Button("Quit", Options.getInitiateThings().getMenuActions().quit()));
	}
}