package menu.console.habitants;

import main.Options;
import menu.console.ConsoleFirst;
import menu.console.ConsoleSecond;
import characters.base.Characters;
import characters.jobs.JobBuilder;
import characters.jobs.JobFarmer;
import characters.jobs.JobStoneMiner;
import characters.jobs.JobWoodcutter;
import characters.jobs.Jobless;

import com.googlecode.lanterna.gui.component.Button;

public class ConsoleChangeJob extends ConsoleSecond{
	private Characters character;
	public ConsoleChangeJob(String title, Characters character2) {
		super(title);
		this.character = character2;
	}

	@Override
	public void open(ConsoleFirst menu) {
		open = true;
		addComponent(new Button("Jobless", Options.getInitiateThings().getMenuActions().changeJob(character, new Jobless(character),this)));
		addComponent(new Button("Farmer", Options.getInitiateThings().getMenuActions().changeJob(character, new JobFarmer(character),this)));
		addComponent(new Button("Woodcutter", Options.getInitiateThings().getMenuActions().changeJob(character, new JobWoodcutter(character),this)));
		addComponent(new Button("Builder", Options.getInitiateThings().getMenuActions().changeJob(character, new JobBuilder(character),this)));
		if(Options.isCanMine()){
			addComponent(new Button("Stone Miner", Options.getInitiateThings().getMenuActions().changeJob(character, new JobStoneMiner(character),this)));
		}
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	@Override
	public void close(ConsoleSecond console){
		removeAllComponents();
		close();
	}


}
