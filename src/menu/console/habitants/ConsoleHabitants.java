package menu.console.habitants;


import java.util.ArrayList;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;

import com.googlecode.lanterna.gui.component.Button;

public class ConsoleHabitants extends ConsoleSecond{
	private ArrayList<ConsoleSecond>changeJob;
	public ConsoleHabitants(String title) {
		super(title);
	}

	@Override
	public void open(ConsoleFirst menu) {
		changeJob = new ArrayList<ConsoleSecond>();
		for(int i=0;i<Options.getTown().getTownHabitant().size();i++){
			changeJob.add(new ConsoleHabitantsSelected(Options.getTown().getTownHabitant().get(i)));
			addComponent(new Button(Options.getTown().getTownHabitant().get(i).getName(),Options.getInitiateThings().getMenuActions().openMenu(changeJob.get(i), panel, menu)));
		}
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	@Override
	public void close(){
		removeAllComponents();
		setOpen(false);
		super.close();
	}
}
