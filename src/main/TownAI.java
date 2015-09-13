package main;

import java.util.ArrayList;

import characters.base.Characters;
import characters.base.StateJob;
import characters.jobs.JobFarmer;
import world.places.OtherTowns;

public class TownAI {
	private OtherTowns town;
	private int foodConsumption = 0;
	private int foodProduction = 0;
	private ArrayList<Characters>freePeople = new ArrayList<Characters>();
	private ArrayList<Characters>jobPeople = new ArrayList<Characters>();
	public TownAI(OtherTowns town) {
		this.town = town;
	}
	public void start(){
		reset();
		bestForResource(new JobFarmer()).setJob(new JobFarmer());
		foodProduction = calculateWorkProduction(new JobFarmer());
		if(foodProduction<foodConsumption){			
		}
	}
	private Characters bestForResource(StateJob job){
		Characters character = freePeople.get(0);
		for(int i = 0;i<freePeople.size();i++){
			for(int l = 0;l<freePeople.get(i).getWorkCapacity().size();l++){
				if(freePeople.get(i).getWorkCapacity().get(l).getJob().equals(job)){
					for(int k = i+1;k<freePeople.size();k++){
						if(freePeople.get(i).getWorkCapacity().get(k).getWorkCapacity()>freePeople.get(k).getWorkCapacity().get(l).getWorkCapacity()){
							character = freePeople.get(i);
						}
					}
				}
			}
		}
		freePeople.remove(character);
		jobPeople.add(character);
		return character;
	}
	private void reset(){
		freePeople.clear();
		foodConsumption = 0;
		foodProduction = 0;
		for(int i = 0;i<town.getCharacters().size();i++){
			freePeople.add(town.getCharacters().get(i));
			foodConsumption = foodConsumption + freePeople.get(i).getFoodConsumption();
		}
	}
	private int calculateWorkProduction(StateJob job){
		int workProduction = 0;
		for(int i =0;i<jobPeople.size();i++){
			if(jobPeople.get(i).getJob().equals(job)){
				for(int l = 0; l<jobPeople.get(i).getWorkCapacity().size();l++){
					if(jobPeople.get(i).getWorkCapacity().get(l).getJob().equals(job)){
						workProduction = workProduction + jobPeople.get(i).getWorkCapacity().get(l).getWorkCapacity();
					}
				}
			}
		}
		return workProduction;
	}
}