package university;

import java.io.Serializable;
import java.util.*;
public class Faculty implements Serializable, Cloneable, Comparable<Object>{
    private static final long serialVersionUID = 1L;
    
	public TitleFaculty title;
    public Vector<Course> courses = new Vector<Course>();
    public Manager manager;
    
    public Faculty() {
    	
    }
    public Faculty(TitleFaculty title) {
    	this.title = title;
    }
    public Faculty(TitleFaculty title, Manager manager) {
    	this(title);
    	this.manager = manager;
    }
    public Faculty(TitleFaculty title, Manager manager, Vector<Course> courses) {
    	this(title, manager);
    	this.courses = courses;
    }
    
	public TitleFaculty getTitle() {
		return title;
	}
	public void setTitle(TitleFaculty title) {
		this.title = title;
	}
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Manager manager) {
		this.manager = manager;
	}
	public Manager getManager() {
		return manager;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(courses, manager, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(manager, other.manager) && title == other.title;
	}
	
	@Override
	public int compareTo(Object o) {
		Faculty f = (Faculty)o;
		
		return this.title.compareTo(f.title);
	}
	
	@Override
	public String toString() {
		return "Faculty [title=" + title + ", courses=" + courses + "]";
	}
}
