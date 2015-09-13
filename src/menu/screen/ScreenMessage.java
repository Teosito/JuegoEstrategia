package menu.screen;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import messages.MessageBase;

import com.googlecode.lanterna.terminal.Terminal;

public class ScreenMessage extends WindowBase{
	private static ArrayList<MessageBase>messages = new ArrayList<MessageBase>();
	public ScreenMessage(String title) {
		super(title);
		start(40,20);
	}
	@Override
	public void open() {
		open = true;
		screen.startScreen();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				screen.clear();
				int pos = 0;
				for(int i = messages.size()-1;i>0;i--){
					screen.putString(0, pos, messages.get(i).getMessage(), Terminal.Color.WHITE, Terminal.Color.BLACK);
					pos++;
				}
				pos = 0;
				screen.completeRefresh();
			}
		}, 0,1000);	
	}
	public static ArrayList<MessageBase> getMessages() {
		return messages;
	}
}
