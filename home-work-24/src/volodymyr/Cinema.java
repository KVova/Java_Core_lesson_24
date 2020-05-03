package volodymyr;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Cinema {

	private Time open;
	private Time close;
	private TreeMap<Days, Schedule> schedules;
	private ArrayList<Movie> moviesLibrary = new ArrayList<>();

	public Cinema(Time open, Time close) {
		super();
		this.open = open;
		this.close = close;
	}

	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}

	public void addMovie(Movie movie, Time... time) {
		moviesLibrary.add(movie);
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < Days.values().length; j++) {
				try {
					schedules.get(Days.values()[j]).addSeance(new Seance(movie, time[i]));
				} catch (Exception e) {
					e.fillInStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void addSeance(Seance seance, String day) {
		if ((seance.getStartTime().getHour() >= open.getHour()) & (seance.getEndTime().getHour() < close.getHour())) {
			Optional<Map.Entry<Days, Schedule>> schedulesDay = schedules.entrySet().stream()
																	.filter(x -> x.getKey().equals(day)).findFirst();
			if (schedulesDay.isPresent()) {
				schedulesDay.get().getValue().addSeance(seance);
			} else {
				schedules.put(Days.valueOf(day), new Schedule());
				schedules.entrySet().stream().filter(x -> x.getKey().equals(day))
															  .findFirst().get().getValue().getSeances().add(seance);
			}
		} else {
			System.out.println("In this time " + getClose() + " to " + getOpen() + " cinema is close!");
		}
	}

	public void removeMovie(Movie movie) {
		moviesLibrary.remove(movie);
	}
	
//	public void allMovie() {
//		moviesLibrary.forEach(System.out::println); ;
//	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeSeance(Seance seance, String day) {
		if(schedules.containsValue(seance)&(schedules.containsKey(day))) {
			schedules.remove(seance);
		}else {
			System.out.println("This seance not found!");
		}
	}
	
}
