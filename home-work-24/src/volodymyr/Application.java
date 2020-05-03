package volodymyr;

import java.util.Optional;
import java.util.Scanner;

public class Application {

	public static void menu() {
		System.out.println("Enter 1 to add movie");
		System.out.println("Enter 2 to add seance");
		System.out.println("Enter 3 to remove movie");
		System.out.println("Enter 4 to remove seance");
		System.out.println("Enter 5 to visual all movie");
		System.out.println("Enter 0 to exit");
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws Exception {
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new Time (00 , 7), new Time(00, 23));
		
		while (true) {
			menu();

			switch (scan.next()) {
			case "1": 
				System.out.println("Enter name of movie: ");
				String nameMovie = sc.nextLine();
				System.out.println("Enter duration: hour/minute");
				int hourMovie = Integer.parseInt(sc.nextLine());
				int minuteMovie = Integer.parseInt(sc.nextLine());
				cinema.addMovie(new Movie(nameMovie, new Time(minuteMovie, hourMovie)));
				System.out.println("You add movie: " + (cinema));
				break;
			
			case "2": 
				System.out.println("Enter name of movie: ");
				nameMovie = sc.nextLine();
				Optional<Movie> movie = cinema.getMoviesLibrary().stream().filter(x->x.getTitle().equalsIgnoreCase(nameMovie)).findFirst();
				if(movie.isPresent()) {
					System.out.println("Enter time to movie is start: hour/minute");
					int hourStart = Integer.parseInt(sc.nextLine());
					int minuteStart = Integer.parseInt(sc.nextLine());
					System.out.println("Enter day: ");
					String dayMovie = sc.nextLine().toUpperCase();
					cinema.addSeance(new Seance(movie.get(), new Time(minuteStart, hourStart)), dayMovie);
					System.out.println("You add seance: "+ cinema);
				}else {
					System.err.println("The movie " + nameMovie + " isn`t find!");
				}
				break;
			
			case "3": 
				System.out.println("Enter name movie to remove: ");
				nameMovie = sc.nextLine();
				Optional<Movie> findMovie = cinema.getMoviesLibrary().stream().filter(x->x.getTitle().equalsIgnoreCase(nameMovie)).findFirst();
				if(findMovie.isPresent()) {
					cinema.removeMovie(findMovie.get());
					System.out.println("You remove movie: "+ cinema);
				}else {
					System.err.println("Movie "+nameMovie+" isn`t find in movie library");
				}
				break;
						
			case "4": 
				System.out.println("Enter day and name of movie to remove seance: ");
				String dayMovie = sc.nextLine().toUpperCase();
				nameMovie = sc.nextLine();
				Optional<Seance> findSeance = cinema.getSchedules().get(dayMovie).getSeances().stream().filter(x->x.getMovie().getTitle().equalsIgnoreCase(nameMovie)).findFirst();
				if(findSeance.isPresent()) {
				cinema.removeSeance(findSeance.get(), dayMovie);
				System.out.println("You remove seance: " + findSeance);
				}else {
					System.err.println("Seance: "+findSeance+" isn`t find in day: " + dayMovie);
				}
				break;
						
			case "5": 
				System.out.println("All Movie in Library:");
				System.out.println(cinema.getMoviesLibrary().toString());
				break;
				
			case "0": 
				System.exit(0);
				break;
			
			}
	}
}
}