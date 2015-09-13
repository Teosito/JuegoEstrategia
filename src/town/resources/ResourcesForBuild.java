package town.resources;

public class ResourcesForBuild {
	private int cantity;
	private BaseResources resource;
	public ResourcesForBuild(int cantity, BaseResources resource) {
		this.cantity = cantity;
		this.resource = resource;
	}
	public int getCantity() {
		return cantity;
	}
	public BaseResources getResource() {
		return resource;
	}

}
