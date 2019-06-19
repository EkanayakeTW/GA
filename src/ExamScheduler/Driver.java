package ExamScheduler;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import cs.Domain.Examination;

public class Driver {
	public static final int POPULATION_SIZE = 9;
	public static final double MUTATION_RATE = 0.25;
	public static final double CROSSOVER_RATE = 0.9;
	public static final int TORNAMENT_SELECTION_SIZE = 3;
	public static final int NUMB_OF_ELITE_SCHEDULES = 1;
	private int scheduleNumb = 0;
	private int ExamNumber = 1;
	private ClassData data;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		int generationNumber = 0;
		driver.data = new ClassData();
		driver.printAvailableData();
		System.out.print("> Generation #"+generationNumber);
		System.out.print	(" Schedule # |                                           ");
		System.out.println("                                                                                                                                                                 Exams [dept,exam,hall,invigilator,exam-time]            ");
		System.out.println("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | Fitness | Conflicts");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
		Population population = new Population(Driver.POPULATION_SIZE,driver.data).sortByFitness();
		population.getSchedule().forEach(Schedule -> System.out.println("     "+driver.scheduleNumb++ +
				"  |"+Schedule+ " |" +String.format("%.5f",Schedule.getFitness())+ 
				" | "+Schedule.getnumbOfConflicts()));
		driver.printScheduleAsTable(population.getSchedule().get(0), generationNumber);
		driver.ExamNumber = 1;
		while(population.getSchedule().get(0).getFitness() != 1.0) {
			System.out.println("> Generation # "+ ++generationNumber);
			System.out.println(" schedule # |                                                      ");
			System.out.print("Exam # | Dept | Course (number, max # of students) | Hall(Capacity) | Invigilator (Id) | ExamTime (Id");
			System.out.println("                                                        | Fitness | Conflicts");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------");
			population = geneticAlgorithm.evolve(population).sortByFitness();
			driver.scheduleNumb = 0;
			population.getSchedule().forEach(Schedule -> System.out.println("               "+driver.scheduleNumb++ +"   | "+Schedule+"   |   "+
			String.format("%.5f",Schedule.getFitness())+"   |  "+Schedule.getnumbOfConflicts()));
			driver.printScheduleAsTable(population.getSchedule().get(0), generationNumber);
			driver.ExamNumber = 1;
		}

	}
	private void printScheduleAsTable(Schedule schedule,int generation) {
		ArrayList<Examination> examination = schedule.getexamination();
		System.out.println("\n                                     ");
		System.out.print("Exam # | Dept | Course (number, max # of students) | Hall(Capacity) | Invigilator (Id) | ExamTime (Id");
		System.out.println("                                    ");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------");
		examination.forEach(x -> {
			int majorIndex = data.getDepartment().indexOf(x.getDepartment());
			int coursesIndex = data.getCourse().indexOf(x.getCourse());
			int hallIndex = data.getHall().indexOf(x.getHall());
			int invigilatorIndex = data.getInvigilator().indexOf(x.getInvigilator());
			int examtimeIndex = data.getExamTime().indexOf(x.getExamTime());
			System.out.println("                                          ");
			System.out.println(String.format("%1$02d",ExamNumber)+ " | ");
			System.out.println(String.format("%1$4s",data.getDepartment().get(majorIndex).getname())+ " | ");
			System.out.println(String.format("%1$21s",data.getCourse().get(coursesIndex).getname()+ 
					"("+x.getHall().getHallCapacity())+")  | ");
			System.out.println(String.format("%1$10s",data.getHall().get(hallIndex).getnumber	()+ 
					"("+data.getCourse().get(coursesIndex).getNumber()+","+
					x.getCourse().maxNumberOfStudents())+")  | ");
			System.out.println(String.format("%1$15s",data.getInvigilator().get(invigilatorIndex).getname()+ 
					"("+data.getInvigilator().get(invigilatorIndex).getid())+")  | ");
			System.out.println(data.getExamTime().get(examtimeIndex).gettime()+ 
					"("+data.getExamTime().get(examtimeIndex).getid()+")  | ");
			ExamNumber++;
		});
		if (schedule.getFitness() == 1) System.out.println("> Solution Found in "+ (generation + 1)+"generations");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------");
	}
	private void printAvailableData() {
		System.out.println("Available Departments ==>");
		data.getDepartment().forEach(x -> System.out.println("name : "+x.getname()+", courses : "+x.getCourse()));
		System.out.println("\nAvaiable Courses ==>");
		data.getCourse().forEach(x -> System.out.println("Course # : "+x.getNumber()+", name : "+x.
					getname()+", max # of students :"+x.maxNumberOfStudents()+", invigilators :"+ x.getInvigilators()));
		System.out.println("\nAvailable Halls ==>");
		data.getHall().forEach(x -> System.out.println("Hall # : "+x.getnumber()+", max seating capacity:"+x.getHallCapacity()));
		System.out.println("\nAvailable Invigilators ==>");
		data.getInvigilator().forEach(x -> System.out.println("id : "+x.getid()+", name:"+x.getname()));
		System.out.println("\nAvailable ExamTime ==>");
		data.getExamTime().forEach(x -> System.out.println("id : "+x.getid()+", Exam Time:"+x.gettime()));
		System.out.print("-------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
	}

}
