package cs.Domain;

import java.util.ArrayList;

public class Course {
	private String number = null;
	private String name = null;
	private int maxNumberOfStudents;
	private ArrayList<Invigilator> invigilators;
	public Course(String number, String name, int maxNumberOfStudents, ArrayList<Invigilator> invigilators) {
		this.number = number;
		this.name = name;
		this.maxNumberOfStudents = maxNumberOfStudents;
		this.invigilators = invigilators;
	}
	public String getNumber() {
		return number;
	}
	public String getname() {
		return name;
	}
	public int maxNumberOfStudents() {
		return maxNumberOfStudents;
	}
	public ArrayList<Invigilator> getInvigilators(){
		return invigilators;
	}
	public String toString() {
		return name;
	}

}
