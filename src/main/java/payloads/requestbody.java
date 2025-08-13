package payloads;

import java.util.Arrays;

import pojoclass.Addplace;
import pojoclass.location;

public class requestbody {

	public Addplace postbody() {
		Addplace addplace = new Addplace();
		addplace.setAccuracy(50);
		addplace.setName("Frontline house");
		addplace.setPhone_number("(+91) 983 893 3937");
		addplace.setAddress("29, side layout, cohen 09");
		addplace.setWebsite("http://google.com");
		addplace.setLanguage("French-IN");
		addplace.setTypes(Arrays.asList("shoe park", "shop"));
		
		//location object
		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		addplace.setLocation(loc);

		
		return addplace;
	}
	public String putbody(String placeId,String newAddress) {
		return "{\n"
				+ "\"place_id\":\""+placeId+"\",\n"
				+ "\"address\":\""+newAddress+"\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}";
	}
	public String deletebody(String placeId) {
		return "{\n"
				+ "\"place_id\":\""+placeId+"\",\n"
				+ "}";
	}

}
