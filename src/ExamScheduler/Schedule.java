package ExamScheduler;
import java.util.ArrayList;
import cs.Domain.Examination;
import cs.Domain.Department;
public class Schedule {
	private ArrayList<Examination> examination;
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	private int examNumb = 0;
	private int numbOfConflicts = 0;
	private ClassData data;
	public ClassData getData() {
		return data;
	}
	public Schedule(ClassData data) {
		this.data = data;
		examination = new ArrayList<Examination>(data.getnumOfExams());
	}
	public Schedule initialize() {
		new ArrayList<Department>(data.getDepartment()).forEach(dept -> {
			dept.getCourse().forEach(course ->{
				Examination newExam = new Examination(examNumb++,dept,course); 
				newExam.setExamTime(data.getExamTime().get((int)(data.getExamTime().size()*Math.random())));
				newExam.setHall(data.getHall().get((int)(data.getExamTime().size()*Math.random())));
				newExam.setInvigilator(course.getInvigilators().get((int)(data.getExamTime().size()*Math.random())));
				examination.add(newExam);
			});
		});
		return this;
	}
	public int getnumbOfConflicts(){
		return numbOfConflicts;
	}
	public ArrayList<Examination> getexamination(){
		isFitnessChanged = true;
		return examination;
	}
	public double getFitness(){
		if(isFitnessChanged == true) {
			fitness = calculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}
	private double calculateFitness(){
		numbOfConflicts = 0;
		examination.forEach(x -> {
			if(x.getHall().getHallCapacity() < x.getCourse().maxNumberOfStudents()) numbOfConflicts++;
			examination.stream().filter(y -> examination.indexOf(y) >=examination.indexOf(x)).forEach(y -> {
				if(x.getExamTime() == y.getExamTime() && x.getId() != y.getId()) {
					if(x.getHall() == y.getHall()) numbOfConflicts++;
					if(x.getInvigilator() == y.getInvigilator()) numbOfConflicts++;
				}
			});
		});
		return 1/(double)(numbOfConflicts + 1);
	}
	public String toString(){
		String returnValue = new String();
		for (int x = 0; x < examination.size()-1; x++) returnValue += examination.get(x) + ",";
		returnValue += examination.get(examination.size()-1);
		return returnValue;
	}

}
