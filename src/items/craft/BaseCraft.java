package items.craft;

import items.base.BaseItem;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import town.Town;
import main.Options;


public abstract class BaseCraft {
	protected ArrayList<BaseItem>resources = new ArrayList<BaseItem>();
	protected String name;
	protected int timeToCraft;
	protected BaseItem item;
	public String getName() {
		return name;
	}
	public ArrayList<BaseItem> getResources() {
		return resources;
	}
	
	public void craft(final Town town) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				town.getTownInventary().add(item);
			}
		}, timeToCraft*Options.getCicle());
	}
	public BaseItem getItem() {
		return item;
	}
	private static boolean inArray(BaseItem item, ArrayList<BaseItem>items){
		for(int i = 0; i<items.size(); i++){
			if(items.get(i)==item){
				return true;
			}
		}
		return false;
	}
	public static void doCraft(final ArrayList<BaseItem>items, final Town town){
		ArrayList<BaseCraft>checkItems = new ArrayList<BaseCraft>();
		int numberOfResources = 0;
		BaseCraft itemToCraft;
		for(int i = 0; i<items.size();i++){
			for(int l = 0;l<Options.getInitiateThings().getItemsToCraft().size();l++){
				if(items.size()==Options.getInitiateThings().getItemsToCraft().get(l).getResources().size()){
					checkItems.add(Options.getInitiateThings().getItemsToCraft().get(l));
				}
			}
		}
		for(int i=0; i<checkItems.size();i++){
			numberOfResources=0;
			for(int l = 0; l<checkItems.get(i).getResources().size();l++){
				for(int k = 0; k<items.size();k++){
					if(items.get(k).getClass().equals(checkItems.get(i).getResources().get(l).getClass())){
						numberOfResources++;
					}
				}
			}
			if(items.size()>0){
				if(numberOfResources==items.size()){
					itemToCraft = checkItems.get(i);
					for(int l = 0;l<items.size();l++){
						for(int k = 0; k<town.getTownInventary().size();k++){
							if(items.get(l)==town.getTownInventary().get(k)){
								town.getTownInventary().remove(k);
							}
						}
					}
					itemToCraft.craft(town);
					System.out.println(itemToCraft.getName());
					break;
				}
			}
		}
	}
	public static void Craft(final ArrayList<BaseItem>items, final BaseItem item){
		if(items.size()>0){
			if(inArray(item, items)){
				for(int i = 0; i<items.size();i++){
					if(items.get(i)==item){
						items.remove(i);
					}
				}
			}else{
				items.add(item);
			}
		}else{
			items.add(item);
		}
		for(int i = 0; i<items.size();i++){
			System.out.println(items.get(i).getName());
			System.out.println(items.size());
		}
	}
}
