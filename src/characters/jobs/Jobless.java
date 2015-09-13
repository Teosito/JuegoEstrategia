package characters.jobs;

import characters.base.Characters;
import characters.base.StateJob;

public class Jobless extends StateJob{
	public Jobless(Characters character) {
		this.character = character;		
	}
	@Override
	public void doJob() {
		character.setJobName("Jobless");
	}

}
