package characters.jobs;

import characters.base.StateJob;

public class JobSoldier extends StateJob{
	public JobSoldier() {
		name = "Soldier";
	}

	@Override
	public void doJob() {
		character.setJobName(name);
	}

}
