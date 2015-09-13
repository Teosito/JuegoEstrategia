package characters.jobs;

import characters.base.Characters;
import characters.base.StateJob;

public class JobFarmer extends StateJob{
	public JobFarmer(Characters character) {
		this.character = character;
		name = "Farmer";
	}
	public JobFarmer() {
		name = "Farmer";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void doJob() {
		character.setJobName(name);
		for(int i = 0; i< character.getWorkCapacity().size();i++){
			if(character.getWorkCapacity().get(i).getName().equals(name)){
				characterProduction = getCharacterProduction(character.getWorkCapacity().get(i).getWorkCapacity());
				jobProduction = characterProduction*character.getTown().getFoodProductionCapacity();
			}
		}
		//jobProduction = character.getFoodCapacity()*character.getTown().getFoodProductionCapacity();
		character.getTown().setFoodProduction(character.getTown().getFoodProduction()+jobProduction);
	}
}