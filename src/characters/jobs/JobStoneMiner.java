package characters.jobs;

import characters.base.Characters;
import characters.base.StateJob;

public class JobStoneMiner extends StateJob{
	public JobStoneMiner(Characters character) {
		this.character = character;
		name = "Stone Miner";
		// TODO Auto-generated constructor stub
	}
	public JobStoneMiner() {
		name = "Stone Miner";
	// TODO Auto-generated constructor stub
	}
	@Override
	public void doJob() {
		character.setJobName(name);for(int i = 0; i< character.getWorkCapacity().size();i++){
			if(character.getWorkCapacity().get(i).getName().equals(name)){
				characterProduction = getCharacterProduction(character.getWorkCapacity().get(i).getWorkCapacity());
				jobProduction = characterProduction*character.getTown().getStoneProductionCapacity();
				character.getTown().setStoneProduction(character.getTown().getStoneProduction()+jobProduction);
			}
		}
	}

}
