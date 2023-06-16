package university;

import java.time.LocalTime;
import java.util.*;

public class Lesson {
    private Day day;
    private FormatLesson format;
    private TypeLesson type;
    private Teacher teacher;
    private LocalTime time;
    private Room room;
    private AttendanceReport ar;
    private Vector<Student> students = new Vector<Student>();
    
    public Lesson(){
    	
    }
    public Lesson(Day day, FormatLesson format, TypeLesson type) {
    	this.day = day;
    	this.format = format;
    	this.type = type;
    }
    public Lesson(Day day, FormatLesson format, TypeLesson type, LocalTime time, Room room) {
    	this(day, format, type);
    	this.time = time;
    	this.room = room;
    }
    public Lesson(Day day, FormatLesson format, TypeLesson type, LocalTime time, Room room, Teacher teacher, Vector<Student> students) {
    	this(day, format, type, time, room);
    	this.teacher = teacher;
    	this.students = students;
    }
    
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public AttendanceReport getAR() {
		return ar;
	}
	public void setAR(AttendanceReport ar) {
		this.ar = ar;
		
		for(Student s : this.getStudents()) {
			this.ar.getAttendance().put(s, Presence.ABSENT);
		}
	} 
	
	public FormatLesson getFormat() {
		return format;
	}
	public void setFormat(FormatLesson format) {
		this.format = format;
	}
	public TypeLesson getType() {
		return type;
	}
	public void setType(TypeLesson type) {
		this.type = type;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Lesson [day=" + day + ", format=" + format + ", type=" + type + ", teacher=" + teacher + ", time="
				+ time + ", room=" + room + ", students=" + students + "]";
	}  
}
