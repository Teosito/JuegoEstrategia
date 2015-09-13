package menu.screen;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

public abstract class WindowBase extends Window implements Screens{
	protected Screen screen;
	protected Terminal terminal;
	protected boolean open = false;
	public WindowBase(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void start(int columns, int rows){
		Terminal terminal = TerminalFacade.createTerminal();
		terminal.getTerminalSize().setColumns(columns);
		terminal.getTerminalSize().setRows(rows);
		screen = new Screen(terminal);
		ScreenWriter gui = new ScreenWriter(screen);
		gui.setBackgroundColor(Color.BLACK);
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isOpen() {
		return open;
	}
	
	public void close(){
		screen.stopScreen();
		open=false;
	}
}
