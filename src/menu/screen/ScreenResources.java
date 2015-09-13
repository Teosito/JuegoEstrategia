package menu.screen;

import java.util.Timer;
import java.util.TimerTask;

import main.Options;
import town.resources.BaseResources;

import com.googlecode.lanterna.terminal.Terminal;

public class ScreenResources extends WindowBase{
	public ScreenResources(String title) {
		super(title);
		start(14,10);
		open();
	}
	public void getResource(BaseResources resource, int i){
		screen.putString(0, i, resource.getName() + 
				Integer.toString(resource.getCantity()), Terminal.Color.WHITE, Terminal.Color.BLACK);
	}
	
	@Override
	public void open() {
		open=true;
		screen.startScreen();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(int i = 0; i<BaseResources.resources.size();i++){
				getResource(Options.getTown().getResources(Options.getTown().getResources().get(i)),i);
				}
				screen.refresh();
				screen.clear();
			}
		}, 0,1);
	}
}
