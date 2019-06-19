package cs.Domain;

import java.util.ArrayList;

public class Department {
	private String name;
	private ArrayList<Course> courses;
	public Department(String name, ArrayList<Course> courses) {
		this.name = name;
		this.courses = courses;
	}
	public String getname() {
		return name;
	}
	public ArrayList<Course> getCourse(){
		return courses;
	}
	
}
