package characters.jobs;

import characters.base.Characters;
import characters.base.StateJob;

public class JobWoodcutter extends StateJob{
	public JobWoodcutter(Characters character) {
		this.character = character;
		name = "Woodcutter";
	}
	public JobWoodcutter() {
		name = "Woodcutter";
	}

	@Override
	public void doJob() {
		character.setJobName(name);
		for(int i = 0; i< character.getWorkCapacity().size();i++){
			if(character.getWorkCapacity().get(i).getName().equals(name)){
				characterProduction = getCharacterProduction(character.getWorkCapacity().get(i).getWorkCapacity());
				jobProduction = characterProduction*character.getTown().getWoodProductionCapacity();
				character.getTown().setWoodProduction(character.getTown().getWoodProduction()+jobProduction);
			}
		}
	}
}
