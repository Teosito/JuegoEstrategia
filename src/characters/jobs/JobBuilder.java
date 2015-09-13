package characters.jobs;


import characters.base.Characters;
import characters.base.StateJob;

public class JobBuilder extends StateJob{
	public JobBuilder() {
		name="Builder";
		// TODO Auto-generated constructor stub
	}
	
	public JobBuilder(Characters character) {
		this.character = character;
	}
	@Override
	public void doJob() {
		character.setJobName("Builder");
	}
}
