package ExamScheduler;

import java.util.ArrayList;
import java.util.Arrays;

import cs.Domain.Course;
import cs.Domain.Department;
import cs.Domain.ExamTime;
import cs.Domain.Hall;
import cs.Domain.Invigilator;

public class ClassData { 
	
	private ArrayList<Hall> hall;
	private ArrayList<Invigilator> invigilator;
	private ArrayList<Course> course;
	private ArrayList<Department> dept;
	private ArrayList<ExamTime> examtime;
	private int numOfExams = 0;
	public ClassData() {
		initialize();
		}
	private ClassData initialize() {
		Hall hall1 = new Hall("H1", 120);
		Hall hall2 = new Hall("H2", 100);
		Hall hall3 = new Hall("H3", 90);
		Hall hall4 = new Hall("H4", 70);
		hall = new ArrayList<Hall>(Arrays.asList(hall1,hall2,hall3,hall4));
		ExamTime examtime1 = new ExamTime("ET1", "MWF 08:30 - 10:30");
		ExamTime examtime2 = new ExamTime("ET2", "MWF 11:00 - 13:00");
		ExamTime examtime3 = new ExamTime("ET3", "TTF 08:30 - 10:30");
		ExamTime examtime4 = new ExamTime("ET4", "TTF 11:00 - 13:00");
		examtime = new ArrayList<ExamTime>(Arrays.asList(examtime1,examtime2,examtime3,examtime4));
		Invigilator inv1 = new Invigilator("Inv1", "Senior Lect Anjalie Gamage");
		Invigilator inv2 = new Invigilator("Inv2", "Dr.Dasuni Navinnna");
		Invigilator inv3 = new Invigilator("Inv3", "Dr.Kavinga Abeygunawardena");
		Invigilator inv4 = new Invigilator("Inv4", "Dr.Pradeepa Samarasinghe");
		invigilator = new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4));
		Course c1 = new Course("C1", "OOP",150,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c2 = new Course("C2", "DAA",100,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c3 = new Course("C3", "UEE",80,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c4 = new Course("C4", "CTSE",120,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c5 = new Course("C5", "ML",90,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c6 = new Course("C6", "CSSE",110,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		Course c7 = new Course("C7", "SPM",60,new ArrayList<Invigilator>(Arrays.asList(inv1,inv2,inv3,inv4)));
		course = new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7));
		Department dept1 = new Department("SE",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		Department dept2 = new Department("IT",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		Department dept3 = new Department("CS",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		Department dept4 = new Department("DS",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		Department dept5 = new Department("CSN",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		Department dept6 = new Department("ISE",new ArrayList<Course>(Arrays.asList(c1,c2,c3,c4,c4,c5,c6,c7)));
		dept = new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3,dept4,dept5,dept6));
		dept.forEach(x -> numOfExams += x.getCourse().size());
		return this;
	}
	
	public ArrayList<Hall> getHall(){
		return hall;
	}
	public ArrayList<Invigilator> getInvigilator(){
		return invigilator;
	}
	public ArrayList<Course> getCourse(){
		return  course;
	}
	public ArrayList<Department> getDepartment(){
		return dept;
	}
	public ArrayList<ExamTime> getExamTime(){
		return examtime;
	}
	public int getnumOfExams(){
		return this.numOfExams;
	}
	

}
