package characters.jobs.workCapacity;

import characters.base.StateJob;

public class BaseWorkCapacity {
	protected String name;
	protected int workCapacity;
	protected StateJob job;
	
	public BaseWorkCapacity(String name, int workCapacity, StateJob job) {
		this.name = name;
		this.workCapacity = workCapacity;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public int getWorkCapacity() {
		return workCapacity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWorkCapacity(int workCapacity) {
		this.workCapacity = workCapacity;
	}
	public StateJob getJob() {
		return job;
	}
	public void setJob(StateJob job) {
		this.job = job;
	}
}