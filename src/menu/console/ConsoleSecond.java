package menu.console;

import main.Options;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;

public abstract class ConsoleSecond extends Window{
	protected boolean open = false;
	protected Panel panel;
	protected ConsoleFirst menu;
	protected ConsoleSecond update;
	protected int positionInArray;
	public ConsoleSecond(String title) {
		super(title);
	}
	public ConsoleSecond(String title, ConsoleSecond update) {
		super(title);
		this.update = update;
	}
	public abstract void open(ConsoleFirst menu);
	public void close(ConsoleSecond console){
		setOpen(false);
		close();
	}
	public void close(ConsoleSecond console, ConsoleSecond update){
		setOpen(false);
		close();
		update.removeAllComponents();
		update.open(menu);
		this.update.removeAllComponents();
		this.update.open(menu);
	}
	public ConsoleSecond getUpdate() {
		return update;
	}
	public void back(){
		addComponent(new Button("Back", Options.getInitiateThings().getMenuActions().close(this)));
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isOpen() {
		return open;
	}
	public void setMenu(ConsoleFirst menu) {
		this.menu = menu;
	}
	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	public ConsoleFirst getMenu() {
		return menu;
	}
	public Panel getPanel() {
		return panel;
	}
	public void setPositionInArray(int positionInArray) {
		this.positionInArray = positionInArray;
	}
	public int getPositionInArray() {
		return positionInArray;
	}
	public void update(ConsoleSecond console, ConsoleFirst menu){
		console.removeAllComponents();
		console.open(menu);
	}
}
