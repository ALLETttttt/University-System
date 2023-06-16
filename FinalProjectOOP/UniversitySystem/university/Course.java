package university;

import java.util.*;

public class Course {
    public TitleCourse title;
    public int credit;
    public int capacity = 300;
    public String code;
    public Vector<Teacher> instructors = new Vector<Teacher>();
    public Vector<Student> students = new Vector<Student>();
    public Vector<Course> prerequisites = new Vector<Course>();
    public Vector<Lesson> lessons = new Vector<Lesson>();
    public Vector<File> files = new Vector<File>();
    
	public Course() {
		
	}
	public Course(TitleCourse title, String code) {
		this.title = title;
		this.code = code;
	}
	public Course(TitleCourse title, String code, int credit, int capacity, Vector<Course> prereq) {
		this(title, code);
		this.credit = credit;
		this.capacity = capacity;
		this.prerequisites = prereq;
	}
	public Course(TitleCourse title, String code, int credit, int capacity, Vector<Course> prereq, Vector<Student> ss, Vector<Teacher> is) {
		this(title, code, credit, capacity, prereq);
		this.students = ss;
		this.instructors = is;
	}
	public Course(TitleCourse title, String code, int credit, int capacity, Vector<Course> prereq, Vector<Student> ss, Vector<Teacher> is, Vector<Lesson> ls) {
		this(title, code, credit, capacity, prereq, ss, is);
		this.lessons = ls;
	}
	
	public TitleCourse getTitle() {
		return title;
	}
	public void setTitle(TitleCourse title) {
		this.title = title;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Vector<Teacher> getInstructors() {
		return instructors;
	}
	public void setInstructors(Vector<Teacher> instructors) {
		this.instructors = instructors;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector<Student> students) {
		this.students = students;
	}
	public Vector<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(Vector<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	public Vector<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(Vector<Lesson> lessons) {
		this.lessons = lessons;
	}
	public Vector<File> getFiles() {
		return files;
	}
	public void addFile(File file) {
		files.add(file);
	}
	
	public boolean addStudent(Student s) {
		if(students.contains(s))
			return false;
		
		students.add(s);
		return true;
	}
	
	public boolean addInstructor(Teacher t) {
		if(instructors.contains(t))
			return false;
		
		instructors.add(t);
		return true;
	}
	
	public int hashCode() {
		return Objects.hash(capacity, code, credit, instructors, prerequisites, students, title);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return capacity == other.capacity && Objects.equals(code, other.code) && credit == other.credit
				&& Objects.equals(instructors, other.instructors) && Objects.equals(prerequisites, other.prerequisites)
				&& Objects.equals(students, other.students) && title == other.title;
		
	}
	public String toString() {
		return "Course [title=" + title + ", credit=" + credit + ", capacity=" + capacity + ", code=" + code
				+ ", instructors=" + instructors + ", students=" + students + ", prerequisites=" + prerequisites + "]";
	}
}
