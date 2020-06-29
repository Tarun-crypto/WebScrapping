import java.io.IOException;
import java.io.Serializable;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class RealityObject implements Serializable,Cloneable {

	String name;
	String email;
	String phone;
	String beds;
	String baths;
	String address;
	
	
	public RealityObject(String name, String email, String phone, String beds, String baths, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.beds = beds;
		this.baths = baths;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBeds() {
		return beds;
	}
	public void setBeds(String beds) {
		this.beds = beds;
	}
	public String getBaths() {
		return baths;
	}
	public void setBaths(String baths) {
		this.baths = baths;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	String getJSON() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

		
}

