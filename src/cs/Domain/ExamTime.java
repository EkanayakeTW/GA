package cs.Domain;

public class ExamTime {
	private String id = null;
	private String time = null;
	public ExamTime(String id,String time ) {
		this.time = time;
		this.id = id;
	}
	public String gettime() {
		return time;
	}
	public String getid() {
		return id;
	}
	
}
