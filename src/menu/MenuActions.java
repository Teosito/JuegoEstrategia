package menu;


import java.util.ArrayList;

import items.base.BaseItem;
import items.craft.BaseCraft;
import town.Town;
import town.buildings.base.BaseBuilding;
import town.resources.BaseResources;
import world.places.BasePlaces;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import menu.console.OutsideWorld;
import menu.console.buildings.ConsoleBuilding;
import menu.screen.WindowBase;
import characters.base.Characters;
import characters.base.StateJob;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.LayoutParameter;

public class MenuActions {	
	public static final LayoutParameter CENTER = new LayoutParameter("Center");
	private ConsoleFirst menu;
	
	public void setMenu(ConsoleFirst menu) {
		this.menu = menu;
	}
	public Action build(final Town town, final BaseBuilding building, final ConsoleSecond console) {
		Action build = new Action() {
		int can = 0;
			@Override
			public void doAction() {
				for(int i=0;i<town.getResources().size();i++){
					for(int l = 0; l<building.getRequierements().size();l++){
						if(town.getResources().get(i).getName().equals(building.getRequierements().get(l).getResource().getName())){
							if(town.getResources().get(i).getCantity()>=building.getRequierements().get(l).getCantity()){
								can++;
							}
						}
					}
				}
				if(can==building.getRequierements().size()){
					building.build(building, town, town.getTownHabitant(),building.isDone());
					consoleUpdate(console);
				}
			}
		};
		return build;
	}
	
	public Action changeEquipment(final Characters character, final BaseItem item,final ConsoleSecond console){
		Action changeEquipment = new Action(){
			@Override
			public void doAction(){
				character.getInventory().changeEquipment(character, item);
				consoleUpdate(console);
			}			
		};
		return changeEquipment;
	}
	public Action changeJob(final Characters character,final StateJob job, final ConsoleSecond console) {
		Action changeJob = new Action() {
			@Override
			public void doAction() {
				character.setJob(job);
				console.removeAllComponents();
				console.setOpen(false);
				console.close();
			}
		};
		return changeJob;
	}
	public Action close(final ConsoleSecond console) {
		Action close = new Action(){
			@Override
			public void doAction() {
				console.close(console);
				console.setOpen(false);
			}
		};
		return close;
	}
	public Action openMenu(final WindowBase screen) {
		Action closeGame = new Action() {
			@Override
			public void doAction() {
				if(screen.isOpen()){
					screen.close();
				}else{
					screen.open();
				}
			}
		};
		return closeGame;
	}
	
	public Action openMenu(final ConsoleSecond console, Panel panel, final ConsoleFirst menu) {
		console.setPanel(panel);
		console.setMenu(menu);
		Action openMenu = new Action(){
			@Override
			public void doAction() {
				menu.update();
				if(console.isOpen()){
					console.removeAllComponents();
				}else{
					console.open(menu);
					OutsideWorld.gui.showWindow(console,GUIScreen.Position.NEW_CORNER_WINDOW);		
				}
			}
		};
		return openMenu;
	}

	public Action openInfoMenu(final ConsoleSecond console, Panel panel, ConsoleFirst menu, BaseBuilding building) {
		console.setPanel(panel);
		console.setMenu(menu);
		menu.update();
		Action openMenu = new Action(){
			@Override
			public void doAction() {
				if(console.isOpen()){
					console.removeAllComponents();
				}else{
					OutsideWorld.gui.showWindow(console,GUIScreen.Position.NEW_CORNER_WINDOW);					
				}
			}
		};
		return openMenu;
	}
	public Action openInfoMenu(final ConsoleSecond console, Panel panel, ConsoleFirst menu, BaseBuilding building,
			ConsoleBuilding consoleBuilding) {
			console.setPanel(panel);
			console.setMenu(menu);
			Action openMenu = new Action(){
				@Override
				public void doAction() {
					if(console.isOpen()){
						console.removeAllComponents();
					}else{
						OutsideWorld.gui.showWindow(console,GUIScreen.Position.NEW_CORNER_WINDOW);					
					}
				}
			};
			return openMenu;
	}
	 
	public Action out() {
		Action openMenu = new Action(){
			@Override
			public void doAction() {
				System.out.print(OutsideWorld.world.getTowns().get(0).getResources(BaseResources.FOOD).getCantity());
			}
		};
		return openMenu;
	}
	
	public Action quit() {
		Action quit = new Action(){
			@Override
			public void doAction(){
				System.exit(0);
			}
		};
		return quit;
	}
	public Action explore(final Characters character,final ConsoleSecond console){
		Action explore = new Action() {
			
			@Override
			public void doAction() {
				character.getExplorer().explore();
				consoleUpdate(console);
			}
		};
		return explore;
	}
	public Action sendToPlace(final Characters character,final ConsoleSecond console, final BasePlaces place,final ConsoleSecond update,final ConsoleSecond update2,final ConsoleSecond update3){
		Action sendToPlace = new Action() {
			@Override
			public void doAction() {
				character.getExplorer().goTo(place);
				console.close();
				update3.close();
				update2.close();
				update.removeAllComponents();
				update.open(menu);
			}
		};
		return sendToPlace;
	}
	private void consoleUpdate(ConsoleSecond console){
		console.close();
		console.getUpdate().removeAllComponents();
		console.getUpdate().open(menu);		
	}
	public Action craft(final ArrayList<BaseItem>items, final BaseItem item){
		Action craft = new Action() {
			@Override
			public void doAction() {
				BaseCraft.Craft(items, item);
			}
		};
		return craft;
	}
	
	public Action doCraft(final ArrayList<BaseItem>items, final ConsoleSecond console, final Town town){
		Action doCraft = new Action() {
			@Override
			public void doAction() {
				BaseCraft.doCraft(items, town);
				console.close();
			}
		};
		return doCraft;
	}
}