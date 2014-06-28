
public class ParlReport extends ParliamentaryThing {

	ParlMember reporter;
	String body;
	public ParlReport(ParlMember reporter, String body) {
		super();
		this.reporter = reporter;
		this.body = body;
	}
	
	public ParlMember getReporter() {
		return reporter;
	}

	public void setReporter(ParlMember reporter) {
		this.reporter = reporter;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ParlReport [reporter=" + reporter + ", body=" + body + "]"+ "\n";
	}
}
