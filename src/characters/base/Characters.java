package characters.base;

import java.util.ArrayList;

import main.Options;
import characters.inventory.InventoryCharacter;
import characters.jobs.JobExplorer;
import characters.jobs.Jobless;
import characters.jobs.workCapacity.BaseWorkCapacity;
import town.Town;
import world.places.OtherTowns;

public class Characters {

	protected StateJob job;
	protected ArrayList<BaseWorkCapacity>workCapacity = new ArrayList<BaseWorkCapacity>();
	protected InventoryCharacter inventory = new InventoryCharacter();
	protected int foodConsumption = 1;
	protected int constructionCapacity= 1;
	protected Town town;
	protected String name;
	protected String jobName = "Jobless";
	protected JobExplorer explorer = new JobExplorer(this);
	protected boolean exploring = false;
	public Characters(Town town) {
		this.town = town;
		job = new Jobless(this);
		for(int i = 0; i<Options.getInitiateThings().getJobs().size();i++){
			workCapacity.add(new BaseWorkCapacity(Options.getInitiateThings().getJobs().get(i).getName(), 1, Options.getInitiateThings().getJobs().get(i)));
		}
		setSkills();
	}
	public Characters(OtherTowns town){
		for(int i = 0; i<Options.getInitiateThings().getJobs().size();i++){
			workCapacity.add(new BaseWorkCapacity(Options.getInitiateThings().getJobs().get(i).getName(), 1, Options.getInitiateThings().getJobs().get(i)));
		}
		setSkills();
	}
	public boolean isExploring() {
		return exploring;
	}
	public void setExploring(boolean exploring) {
		this.exploring = exploring;
	}

	public JobExplorer getExplorer() {
		return explorer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<BaseWorkCapacity> getWorkCapacity() {
		return workCapacity;
	}
	public void setWorkCapacity(ArrayList<BaseWorkCapacity> workCapacity) {
		this.workCapacity = workCapacity;
	}
	public int getFoodConsumption() {
		return foodConsumption;
	}
	public void setFoodConsumption(int foodConsumption) {
		this.foodConsumption = foodConsumption;
	}
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	public StateJob getJob() {
		return job;
	}
	public void setJob(StateJob job) {
		this.job = job;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getConstructionCapacity() {
		return constructionCapacity;
	}
	public void setConstructionCapacity(int constructionCapacity) {
		this.constructionCapacity = constructionCapacity;
	}	
	public InventoryCharacter getInventory() {
		return inventory;
	}
	public void setSkills(){
		for(int i = 0; i<workCapacity.size();i++){
			workCapacity.get(i).setWorkCapacity((int)(Math.random()*3+1));
			System.out.println(Math.random()*5+1);
		}
	}	
}
