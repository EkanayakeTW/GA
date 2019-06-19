package cs.Domain;

import java.util.ArrayList;

public class Invigilator {
	private String id;
	private String name;
	public Invigilator(String id,String name ) {
		this.name = name;
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public String getid() {
		return id;
	}
	public String toString() {
		return name;
	}

}
