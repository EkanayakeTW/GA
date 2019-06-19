package cs.Domain;

public class Examination {
	private int id;
	private Department dept;
	private Course course;
	private Invigilator invigilator;
	private ExamTime examtime;
	private Hall hall;	
	
	public Examination(int id, Department dept, Course course) {
		this.id = id;
		this.dept = dept;
		this.course = course;
	}
	public void setInvigilator(Invigilator invigilator) {
		this.invigilator = invigilator;
	}
	public void setExamTime(ExamTime examtime) {
		this.examtime = examtime;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public int getId(){
		return id;
	}
	public Department getDepartment(){
		return dept;
	}
	public Course getCourse(){
		return course;
	}
	public Invigilator getInvigilator(){
		return invigilator;
	}
	public ExamTime getExamTime(){
		return examtime;
	}
	public Hall getHall(){
		return hall;
	}
	public String toString() {
		return "["+dept.getname()+","+course.getNumber()+","+hall.getnumber()+","
	+invigilator.getid()+","+examtime.getid()+"]";
	}
	
	
}
