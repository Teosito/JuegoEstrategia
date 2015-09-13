package menu.screen;

import java.util.Timer;
import java.util.TimerTask;

import menu.console.OutsideWorld;

import com.googlecode.lanterna.terminal.Terminal;

public class ScreenHabitants extends WindowBase{

	public ScreenHabitants(String title) {
		super(title);
		start(20,OutsideWorld.world.getTowns().get(0).getTownHabitant().size());
	}

	@Override
	public void open() {
		open=true;
		screen.startScreen();
		for(int i=0;i<OutsideWorld.world.getTowns().get(0).getTownHabitant().size();i++){
			screen.putString(0, i,OutsideWorld.world.getTowns().get(0).getTownHabitant().get(i).getName(), Terminal.Color.WHITE, Terminal.Color.BLACK);
		}
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(int i=0;i<OutsideWorld.world.getTowns().get(0).getTownHabitant().size();i++){
					screen.putString(0, 0,OutsideWorld.world.getTowns().get(0).getTownHabitant().get(i).getName(), Terminal.Color.WHITE, Terminal.Color.BLACK);
				}
				screen.refresh();
			}
		}, 0,1);
		
		
	}

}
