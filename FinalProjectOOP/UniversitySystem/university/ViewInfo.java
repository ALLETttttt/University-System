package university;

public interface ViewInfo {
	String viewStudentInfo(Student student) throws StudentNotFoundException;
	String viewTeacherInfo(Teacher teacher) throws TeacherNotFoundException;	
}