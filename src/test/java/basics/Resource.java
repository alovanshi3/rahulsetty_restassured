package basics;

public enum Resource {

	
	postResource("/maps/api/place/add/json"),
	getResource("/maps/api/place/get/json"),
	putResource("/maps/api/place/update/json"),
	deleteResource("/maps/api/place/delete/json");
	
	
	private String Resource;
	
	public String getResource() {
		return Resource;
	}
	
	Resource(String Resource){
		this.Resource=Resource;
	}
	
}
