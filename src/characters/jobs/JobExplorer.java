package characters.jobs;

import items.base.BaseItem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import world.places.BasePlaces;
import world.places.Woods;
import main.Options;
import menu.screen.ScreenMessage;
import messages.MessageExploreBack;
import messages.MessageExploreLost;
import messages.MessageExploreNewPlace;
import characters.base.Characters;

public class JobExplorer{
	private Characters character;
	private int explorerCapacity;
	private int minimumAlive = 50;
	private int findStuff = 70;
	private ArrayList<BaseItem>rewards = new ArrayList<BaseItem>();
	public JobExplorer(Characters character) {
		this.character = character;
		Random rand = new Random();
		explorerCapacity = rand.nextInt((3-1)+1)+1;
		System.out.println(explorerCapacity);
	}
	
	
	
	public void explore(){
		character.setExploring(true);
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				sendExplorer();
			}
		}, 5000);
	}
	public void goTo(final BasePlaces place){
		character.setExploring(true);
		Random rand = new Random();
		final int randomNum = rand.nextInt((100 - 1) + 1) + 1;
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println(randomNum);
				if(randomNum>=0&&randomNum<minimumAlive*place.getDanger()){
					missingInAction();
				}else{
					String nameOfRewards = new String();
					findRewards(place.getRewards(), nameOfRewards);
					character.setExploring(true);
				}
			}
		}, place.getTravelingTime()*Options.getCicle());
	}
	
	private void sendExplorer(){
		Random rand = new Random();
		int randomNum = rand.nextInt((100 - 1) + 1) + 1;			//Dies
		if(randomNum>0&&randomNum<minimumAlive/explorerCapacity){
			missingInAction();
			ScreenMessage.getMessages().add(new MessageExploreLost("", character.getName()));
		}
		if(randomNum>minimumAlive/explorerCapacity){				//Returns
			character.setExploring(false);
			if(randomNum>findStuff/explorerCapacity){
				String nameOfRewards = new String();
				findRewards(rewards, nameOfRewards);
				ScreenMessage.getMessages().add(new MessageExploreBack(nameOfRewards,character.getName()));
			}
		}
		if(randomNum>90){
			character.setExploring(false);
			Options.getMap().getPlacesToGo().add(new Woods());		//New Place
			ScreenMessage.getMessages().add(new MessageExploreNewPlace("", character.getName()));
		}
		System.out.println(randomNum);
	}
	
	private void findRewards(ArrayList<BaseItem> rewards, String nameOfRewards){
		for(int i = 0; 0<rewards.size();i++){
			Random rand = new Random();
			int randomNum = rand.nextInt((100 - 1) + 1) + 1;
			if(randomNum > 70){
				nameOfRewards = nameOfRewards + rewards.get(i).getName() + " ";
				character.getTown().getTownInventary().add(rewards.get(i));
			}
		}
	}
	public int getExplorerCapacity() {
		return explorerCapacity;
	}
	public void setExplorerCapacity(int explorerCapacity) {
		this.explorerCapacity = explorerCapacity;
	}
	private void missingInAction(){
		for(int i = 0; i<character.getTown().getTownHabitant().size();i++){
			if(character==character.getTown().getTownHabitant().get(i)){
				character.getTown().getTownHabitant().remove(i);
			}
		}
	}
}