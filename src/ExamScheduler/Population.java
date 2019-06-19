package ExamScheduler;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {
	private ArrayList<Schedule> schedule;
	public Population(int size, ClassData data) {
		schedule = new ArrayList<Schedule>(size);
		IntStream.range(0, size).forEach(x -> schedule.add(new Schedule(data).initialize()));
	}
	public ArrayList<Schedule> getSchedule(){
		return this.schedule;
	}
	public Population sortByFitness(){
		schedule.sort((schedule1, schedule2) -> {
			int returnvalue = 0;
			if(schedule1.getFitness() > schedule2.getFitness()) returnvalue = -1;
			else if (schedule1.getFitness() < schedule2.getFitness()) returnvalue = 1;
			return returnvalue;
		});
		return this;
	}

}
