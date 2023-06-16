package university;

import java.util.Set;
import java.util.Vector;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Teacher extends Employee implements CanBorrowBook, ManageCourseFiles, ViewInfo {
	private static final long serialVersionUID = 1L;

	private TitleTeacher title;
	private Double rating;
	private Double fee;

	public Teacher() {
    	super();
    }
    public Teacher(String name, String surname) {
    	super(name, surname);
    }
    public Teacher(String name, String surname, double workExperience, int salary, LocalDate hireDate) {
    	super(name, surname, workExperience, salary, hireDate);
    }
    public Teacher(String name, String surname, double workExperience, int salary, LocalDate hireDate, TitleTeacher title) {
    	super(name, surname, workExperience, salary, hireDate);
    	this.title = title;
    }

	public TitleTeacher getTitle() {
		return title;
	}
	public void setTitle(TitleTeacher title) {
		this.title = title;
	}
	public Double getRating() {
		return this.rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}

	public boolean putMark(Course c, Student s, Mark m) {
		if(UniSystem.getDatabase().getCourses().contains(c)) {
			if(c.getStudents().contains(s)) {
				s.getTranscript().addGradeForCourse(c,m);
				return true;
			}
			return false;
		}
		return false;
	}

	public Vector<Course> getCourses(){
		Vector<Course> myCourses = new Vector<Course>();
		for(Course c : UniSystem.getDatabase().getCourses()) {
			if(c.getInstructors().contains(this))
				myCourses.add(c);
		}

		return myCourses;
	}

	public Vector<Lesson> getLessons() {
		Vector<Lesson> myLessons = new Vector<Lesson>();
		for(Course c : getCourses()) {
			for(Lesson l : c.getLessons()) {
				if(l.getTeacher().equals(this))
					myLessons.add(l);
			}
		}
		return myLessons;
	}

	public HashMap<Course, Vector<Student>> getStudents(){
		HashMap<Course, Vector<Student>> students = new HashMap<Course, Vector<Student>>();
		for(Course c : getCourses()) {
			students.put(c, c.getStudents());
		}

		return students;
	}

	public boolean applyForRequest(Request r) {
		return UniSystem.getDatabase().getRequests().add(r);
	}

	@Override
	public String viewStudentInfo(Student s) {
		if(UniSystem.getDatabase().getStudents().contains(s)) {
			return s.toString();
		}
		return "No such student";
	}

	@Override
	public String viewTeacherInfo(Teacher t) {
		if(UniSystem.getDatabase().getTeachers().contains(t)) {
			return t.toString();
		}
		return "No such teacher";
	}

	@Override
	public boolean uploadFile(File file, Course c) {
		return c.getFiles().add(file);
	}

	@Override
	public boolean removeFile(File file, Course c) {
		return c.getFiles().remove(file);
	}	

	public void putLateAttendanceMark(Student s,AttendanceReport ar) {
		ar.getAttendance().replace(s,Presence.LATE);
	}

	public boolean startAttendance(Lesson l, int minute) {
		if(!getLessons().contains(l))
			return false;
		
		l.setAR(new AttendanceReport(minute));
		return true;
	}
}
