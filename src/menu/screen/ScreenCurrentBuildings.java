package menu.screen;


import java.util.Timer;
import java.util.TimerTask;

import com.googlecode.lanterna.terminal.Terminal;

import main.Options;

public class ScreenCurrentBuildings extends WindowBase{

	public ScreenCurrentBuildings(String title) {
		super(title);
		start(20, 20);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		open = true;
		screen.startScreen();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(int i = 0; i<Options.getTown().getCurrentBuilds().size();i++){
					screen.putString(0,i,Options.getTown().getCurrentBuilds().get(i).getName()
							+": "+Float.toString(Options.getTown().getCurrentBuilds().get(i).getPercentage())
							+"%", Terminal.Color.WHITE, Terminal.Color.BLACK);
				}
				screen.refresh();
				screen.clear();
			}
		}, 0,1);	
	}
}
