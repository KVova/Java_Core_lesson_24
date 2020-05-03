package volodymyr;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Schedule {

	Set<Seance> seances = new TreeSet<>();

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}
	
	
	public void addSeance(Seance seance) {
		seances.add(seance);
	}
	
	public void removeSeance(Seance seance) {
		seances.remove(seance);
	}

	@Override
	public String toString() {
		return "Schedule: " + seances;
	}

}