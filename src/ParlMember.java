
public class ParlMember {

	String name="";
	String province="";
	String politicalParty="";
	
	
	public ParlMember(String name){
		this.name=name;
	}
	public ParlMember(String name, String province) {
		
		this.name = name;
		this.province = province;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "ParlMember [name=" + name + ", province=" + province + "]";
	}
	
	
}
