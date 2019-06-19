package ExamScheduler;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GeneticAlgorithm {
	private ClassData data;
	public GeneticAlgorithm(ClassData data) {
		this.data = data;
	}
	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	Population crossoverPopulation(Population population) {
		Population crossoverPopulation = new Population(population.getSchedule().size(),data);	
		IntStream.range(0, Driver.NUMB_OF_ELITE_SCHEDULES).forEach(x -> crossoverPopulation.getSchedule().set(x, 
				                                                                   population.getSchedule().get(x)));
		IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES, population.getSchedule().size()).forEach(x -> {
			if(Driver.CROSSOVER_RATE > Math.random()) {
				Schedule schedule1 = selectTournamentPopulation(population).sortByFitness().getSchedule().get(0);
				Schedule schedule2 = selectTournamentPopulation(population).sortByFitness().getSchedule().get(0);
				crossoverPopulation.getSchedule().set(x, crossoverschedule(schedule1, schedule2));
			}else crossoverPopulation.getSchedule().set(x, population.getSchedule().get(x));
		});
		return crossoverPopulation;
	}
	Schedule crossoverschedule(Schedule schedule1,Schedule schedule2 ) {
		Schedule crossoverschedule = new Schedule(data).initialize();
		IntStream.range(0,crossoverschedule.getexamination().size()).forEach(x -> {
			if(Math.random() > 0.5) crossoverschedule.getexamination().set(x, schedule1.getexamination().get(x));
			else crossoverschedule.getexamination().set(x, schedule2.getexamination().get(x));
		});
		return crossoverschedule;
	}
	Population mutatePopulation(Population population) {
		Population mutatePopulation = new Population(population.getSchedule().size(),data);
		ArrayList<Schedule> schedules = mutatePopulation.getSchedule();
		IntStream.range(0, Driver.NUMB_OF_ELITE_SCHEDULES).forEach(x -> schedules.set(x,population.getSchedule().get(x)));
		IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES, population.getSchedule().size()).forEach(x -> {
			schedules.set(x, mutateschedule(population.getSchedule().get(x)));
		});
		return mutatePopulation;
	}
	Schedule mutateschedule(Schedule mutateschedule) {
		Schedule schedule = new Schedule(data).initialize();
		IntStream.range(0, mutateschedule.getexamination().size()).forEach(x -> {
			if(Driver.MUTATION_RATE > Math.random()) mutateschedule.getexamination().
			                                                                 set(x, schedule.getexamination().get(x));
		});
		return mutateschedule;
	}
	Population selectTournamentPopulation(Population population) {
		Population tournamentPopulation = new Population(Driver.TORNAMENT_SELECTION_SIZE,data);
		IntStream.range(0, Driver.TORNAMENT_SELECTION_SIZE).forEach(x -> {
			tournamentPopulation.getSchedule().set(x, population.getSchedule().
					get((int)(Math.random()*population.getSchedule().size())));
		});
		return null;
	}

}
