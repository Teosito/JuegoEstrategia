package menu.console.explore;


import com.googlecode.lanterna.gui.component.Button;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

public class ConsoleExplore extends ConsoleSecond{

	public ConsoleExplore(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(ConsoleFirst menu) {
		for(int i = 0; i<Options.getTown().getTownHabitant().size();i++){
			if(Options.getTown().getTownHabitant().get(i).isExploring()==false){
				addComponent(new Button(Options.getTown().getTownHabitant().get(i).getName(),
						Options.getInitiateThings().getMenuActions().openMenu(new ConsoleSendExplorer("Send " + Options.getTown().getTownHabitant().get(i).getName(),
						Options.getTown().getTownHabitant().get(i),this), panel, menu)));
				}
			}
		back();
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
}