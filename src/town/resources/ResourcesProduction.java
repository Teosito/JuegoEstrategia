package town.resources;

public class ResourcesProduction {
	private int production;
	private BaseResources resource;
	public ResourcesProduction(BaseResources resources, int production) {
		this.resource = resources;
		this.production = production;
	}
	public int getProduction() {
		return production;
	}
	public BaseResources getResource() {
		return resource;
	}
	public void setProduction(int production) {
		this.production = production;
	}

}
