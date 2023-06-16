package university;
import java.util.*;
import java.util.Map.Entry;
public class Transcript {
    private HashMap<Course, Vector<Mark> > grades = new HashMap<Course, Vector<Mark>>();

    public Transcript() {
    	
    }
    
	public HashMap<Course, Vector<Mark>> getGrades() {
		return grades;
	}
	
	public void addGradeForCourse(Course c, Mark m) {
		grades.get(c).add(m);
	}	

	public double getTotalForCourse(Course c) {
		double res = 0;
		for(Mark m : grades.get(c)) {
			res += m.getScore();
		}
		return res;
	}
	
	public double getTotalScore() {
		double sum = 0;
		for(Entry<Course, Vector<Mark>> i : grades.entrySet()) {
			int credit = i.getKey().getCredit();
			double totalMark = getTotalForCourse(i.getKey());
			sum += totalMark * credit;
		}
		return sum/30;
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(Entry<Course, Vector<Mark>> i : grades.entrySet()) {
			res += i.getKey() + " - " + i.getValue().toString() + "\n";
		}
		return res;
	}
}
