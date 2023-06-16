package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import university.*;

public class ManagerMenu extends Menu{
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

	boolean reportingNews = false;
	boolean addingCourse = false;
	boolean droppingCourse = false;
	public ManagerMenu() {
		super();
	}
	public ManagerMenu(Manager user) {
		super(user);
	}

	public void displayMenu() {
		System.out.println("***********************Desktop***********************");
		System.out.println("=====================================================");
		System.out.println("           1.Add course to student                   ");
		System.out.println("           2.Drop course from student                ");
		System.out.println("           3.Report news                             ");
		System.out.println("           4.Remove news                             ");
		System.out.println("           5.View student info                       ");
		System.out.println("           6.View teacher info                       ");
		System.out.println("           7.Manage Request                          ");
		System.out.println("           8.Exit from account                          ");
		System.out.println("=====================================================");
		System.out.println("\nEnter your choice: ");
	}
	
	private void exit() throws Exception {
		System.out.println("\n\n\n\n\n\n");
		MainMenu.getMainMenu().displayMenu();
		MainMenu.getMainMenu().enterToTheSystem();
	
	}

	private void addCourseToStudent() throws Exception {
		System.out.println("Choose course that you want add to student : ");
		int ind = 1;
		for(Course c : UniSystem.getDatabase().getCourses()) {
			System.out.println(ind + ". " + c.getTitle());
			ind++;
		}

		int chCourse = Integer.parseInt(inp.readLine());
		Course course = UniSystem.getDatabase().getCourses().get(chCourse-1);
		System.out.println("Choose student whom want add to course : ");
		ind = 1;
		for(Student s : UniSystem.getDatabase().getStudents()) {
			System.out.println(ind + ". " + s.getName() + " " + s.getSurname());
			ind++;
		}
		int chStudent = Integer.parseInt(inp.readLine());
		Student student = UniSystem.getDatabase().getStudents().get(chStudent-1);
		if(student.getCourses().contains(course)) {
			System.out.println(student.getName() + "has already registred for " + course.getTitle() + "\n\n");
			addingCourse = false;
		}else {
			((Manager)user).addCoursetoStudent(course, student);
			System.out.println(course.getTitle()  + " was saccessfully added to " + student.getName() + "\n\n");
			addingCourse = true;
		}
	}
	
	private void DropCourseFromStudent() throws Exception {
		System.out.println("Choose student to drop from the course : ");
		int ind = 1;
		for(Student s : UniSystem.getDatabase().getStudents()) {
			System.out.println(ind + ". " + s.getName() + " " + s.getSurname());
			ind++;
		}
		int chStudent = Integer.parseInt(inp.readLine());
		Student student = UniSystem.getDatabase().getStudents().get(chStudent-1);
		if(student.getCourses().size()==0) {
			System.out.println(student.getName() + " has no lesson!");
			droppingCourse = false;
		}else {
			System.out.println("Choose students's course that you want to drop : ");
			ind = 1;
			for(Course c : student.getCourses()) {
				System.out.println(ind + ". " + c.getTitle());
				ind++;
			}
			int chCourse = Integer.parseInt(inp.readLine());;
			Course course = student.getCourses().get(chCourse-1);
			((Manager)user).dropCoursefromStudent(course, student);
			System.out.println(course.getTitle()  + " was saccessfully droped for + " + student.getName() + "\n\n");
			droppingCourse = true;
		}
	}

	private void reportNews() throws Exception {
		News n = new News();
		System.out.println("In which language will news be reported? ");
		Language[] ll = Language.values();
		int ind = 1;
		for (Language dir : ll) {
			System.out.println(ind + ". " + dir);
			ind++;
		}
		int chLanguage = Integer.parseInt(inp.readLine());
		Language l = (Language)Array.get(ll, chLanguage-1);
		System.out.print("Enter news title: ");
		String tit = inp.readLine();
		n.setTitle(tit);
		if(n.getTitle().length()!=0) {
			System.out.print("Enter information about news: ");
			String inf = inp.readLine();	
			n.setInfo(inf);
			if(n.getInfo().length()>0) {
				((Manager)user).reportNews(n);
				System.out.println("News was successfully reported!");	
				reportingNews = true;
			}
		}
	}
	
	private void removeNews() throws Exception {
		System.out.println("Choose news that you want remove: ");
		if(UniSystem.getDatabase().getNews().size() == 0) {
			System.out.println("No news in system");
		}else {
			int ind = 1;
			for(News n: UniSystem.getDatabase().getNews()) {
				System.out.println(ind + ". " + n.getTitle());
				ind++;
			}
			int chNews = Integer.parseInt(inp.readLine());
			News news = UniSystem.getDatabase().getNews().get(chNews-1);
			((Manager)user).removeNews(news);
			if(chNews > 0) {
				System.out.println("News successfully deleted!");
			}
		}
	}
	
	private void viewStudentInfo() throws Exception {
		System.out.println("select the student from whom you want to view the full information : ");
		int ind = 1;
		for(Student s : UniSystem.getDatabase().getStudents()) {
			System.out.println(ind + ". " + s.getName() +  " "  + s.getSurname());
			ind++;
		}
		int chStudent = Integer.parseInt(inp.readLine());
		Student s = UniSystem.getDatabase().getStudents().get(chStudent-1);
		System.out.println(s.toString());
	}
	
	private void viewTeacherInfo() throws Exception {
		System.out.println("select the teacher from whom you want to view the full information : ");
		int ind = 1;
		for(Teacher s : UniSystem.getDatabase().getTeachers()) {
			System.out.println(ind + ". " + s.getName() +  " "  + s.getSurname());
			ind++;
		}
		int chTeacher = Integer.parseInt(inp.readLine());
		Teacher t = UniSystem.getDatabase().getTeachers().get(chTeacher-1);
		System.out.println(t.toString());
	}
	
	private void manageRequest() throws Exception{
		System.out.println("Choose request that you want execute: ");
		int ind = 1;
		for(Request r : UniSystem.getDatabase().getRequests()) {
			System.out.println(ind + ". " + r.toString());
			ind++;
		}
		int chReq = Integer.parseInt(inp.readLine());
		Request r = UniSystem.getDatabase().getRequests().get(chReq-1);
		r.setStatus(RequestStatus.COMPLETED);
		System.out.println(r.toString()  + "request successfully accepted");
	}
	
	public void action() throws Exception {
		try {
			menu : while(true){
				displayMenu();
				int choice = Integer.parseInt(inp.readLine());
				if(choice==1){
					addCourseToStudent: while(true){
						addCourseToStudent();
						if(addingCourse) {
							System.out.println("Whould you like to add another course to this student? \n 1.Yes \n 2.Return back \n");
							choice = Integer.parseInt(inp.readLine());
							if(choice==1) continue addCourseToStudent;
							if(choice==2) continue menu;
							break;
						}else {
							System.out.println("Whould you like to try again? \n 1.Yes \n 2.Return back \n");
							choice = Integer.parseInt(inp.readLine());
							if(choice==1) continue addCourseToStudent;
							if(choice==2) continue menu;
							break;
						}
					}
				}else if(choice==2) {
					dropCourseFromStudent: while(true) {
						DropCourseFromStudent();
						if(droppingCourse) {
							System.out.println(" Whould you like to drop another course for this student? \n 1.Yes \n 2.Return back \n");
							choice = Integer.parseInt(inp.readLine());
							if(choice==1) continue dropCourseFromStudent;
							if(choice==2) continue menu;
							break;
						}else {
							System.out.println("You have already back to Main Menu");
							continue menu;
						}
					
					}
				}else if(choice==3) {
					reportNews : while(true) {
						reportNews();
						if(reportingNews) {
							reportingNews = false;
							System.out.println(" Whould you like to report another news? \n 1.Yes \n 2.Return back \n");
							choice = Integer.parseInt(inp.readLine());
							if(choice==1) continue reportNews;
							if(choice==2) continue menu;
							break;
						}
						break;
					}
				}else if(choice==4) {
					removeNews : while(true) {
						removeNews();
						
						System.out.println("Whould you like to remove another news? \n 1.Yes \n 2.Return back \n ");
						choice = Integer.parseInt(inp.readLine());
						if(choice==1) continue removeNews;
						if(choice==2) continue menu;
						break;

					}
				}else if(choice==5) {
					viewStudentInfo : while(true) {
						viewStudentInfo();
						
						System.out.println("Whould you like to view info another student? \n 1.Yes \n 2.Return back \n");
						choice = Integer.parseInt(inp.readLine());
						if(choice==1) continue viewStudentInfo;
						if(choice==2) continue menu;
						break;
					}
				}else if(choice==6) {
					viewTeacherInfo : while(true) {
						viewTeacherInfo();
						System.out.println("Whould you like to view info another teacher? \n 1.Yes \n 2.Return back \n");
						choice = Integer.parseInt(inp.readLine());
						if(choice==1) continue viewTeacherInfo;
						if(choice==2) continue menu;
						break;
					}
				}else if(choice==7) {
					manageRequest : while(true) {
						manageRequest();
						System.out.println("Whould you like to accept another request? \n 1.Yes \n 2.Return back \n");
						choice = Integer.parseInt(inp.readLine());
						if(choice==1) continue manageRequest;
						if(choice==2) continue menu;
						break;
					}
				}else if(choice==8) {
					exit();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			UniSystem.getDatabase().write();
		}
	}
}