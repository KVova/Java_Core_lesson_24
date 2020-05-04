package volodymyr;

public class Seance{
	
	public Seance(Movie movie, Time startTime) throws Exception {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = Time.allTime(startTime, movie.getDuration()); //why is don`t work???!!!
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Seance: movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime;
	}

	private Movie movie;
	private Time startTime;
	private Time endTime;
	
}
