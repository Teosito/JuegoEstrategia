package items.base;

import characters.base.Characters;
import characters.base.StateJob;
import characters.jobs.workCapacity.BaseWorkCapacity;

public  class ItemWorkTool extends BaseItem{
	protected BaseWorkCapacity work;
	public ItemWorkTool(Characters character, BaseWorkCapacity work) {
		this.character = character;
	}
	public ItemWorkTool() {
	}
	public boolean toolFor(StateJob job){
		System.out.println(character.getJob().getClass());
		System.out.println(job.getClass());
		/*if(character.getJob().getClass().equals(job.getClass())){
			return true;
		}*/
		return false;
	}
	@Override
	public int use() {
		// TODO Auto-generated method stub
		return 0;
	}
}
