package menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Scanner;


import university.*;

public class TeacherMenu extends Menu{
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	public TeacherMenu() {
		super();
	}
	public TeacherMenu(Teacher user) {
		super(user);
	}

	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		System.out.println("***********************Desktop***********************");
		System.out.println("=====================================================");
		System.out.println("           1.Put Mark                                ");
		System.out.println("           2.Personal info                           ");
		System.out.println("           3.Start attendance                        ");
		System.out.println("           4.News                                    ");
		System.out.println("           5.Put later attendance mark to Student    ");
		System.out.println("=====================================================");
	}

	private void viewPersonalInfo() throws Exception {
		System.out.println(((Teacher)user).toString());
	}


	public void action() throws FileNotFoundException, IOException {
		try {
			menu : while(true){
				displayMenu();
				int choice = sc.nextInt();
				System.out.print("Enter Your Choice ");
				switch (choice) {
				case 1:
					while(true) {
						System.out.println("Choose the course you want to rate : ");

						int ind = 1;
						for(Course c : ((Teacher) user).getCourses()) {
							System.out.println(ind + ". " + c.getTitle());
							ind++;
						}
						ind = 1;
						int chCourse = Integer.parseInt(inp.readLine());
						Course c = ((Teacher) user).getCourses().get(chCourse-1);
						System.out.println("Choose student you want to rate : ");
						for(Student s : c.getStudents()) {
							System.out.println(ind + ". " + s.getName() + " " + s.getSurname());
							ind++;
						}
						ind = 1;
						int chStudent = Integer.parseInt(inp.readLine());
						Student s = c.getStudents().get(chStudent-1);
						System.out.println("Choose type of mark you want to put : ");
						MarkType[] mt = MarkType.values();
						for (MarkType dir : mt) {
							System.out.println(ind + ". " + dir);
							ind++;
						}
						int chMark = Integer.parseInt(inp.readLine());
						MarkType m = (MarkType)Array.get(mt, chMark);
						System.out.println("Write marks value you want put: ");
						int MarkVal = Integer.parseInt(inp.readLine());
						((Teacher) user).putMark(c, s, new Mark(m, MarkVal));
						break;
					}
				case 2:
					while(true) {
						viewPersonalInfo();

						System.out.println("For return back enter [back]");
						String back = inp.readLine();
						if(back.equals("back")) continue menu;
						else {
							System.out.println("You don't enter [back] but i already return back");
							continue menu;
						}
					}
				case 3:
					while(true) {
						System.out.println("Select course where your lesson provite: ");
						int ind = 1;
						for(Course c : UniSystem.getDatabase().getCourses()) {
							System.out.println(ind + ". " + c.getTitle());
							ind++;
						}
						int chCourse = Integer.parseInt(inp.readLine());
						Course c = UniSystem.getDatabase().getCourses().get(chCourse-1);
						System.out.println("Select lesson for conduct attendance: ");
						ind = 1;
						for(Lesson l : c.getLessons()) {
							System.out.println(ind + ". " + l.toString());
							ind++;
						}
						int chLesson = Integer.parseInt(inp.readLine());
						Lesson l = c.getLessons().get(chLesson-1);
						System.out.println("Enter minute for what you want open attendance: ");
						int min = Integer.parseInt(inp.readLine());
						((Teacher)user).startAttendance(l, min);
					}
				case 4:
					for(News n : UniSystem.getDatabase().getNews()) {
						System.out.println(n.getTitle());
					}
				case 5:
					System.out.println("Select course where your lesson provite: ");
					int ind = 1;
					for(Course c : UniSystem.getDatabase().getCourses()) {
						System.out.println(ind + ". " + c.getTitle());
						ind++;
					}
					int chCourse = Integer.parseInt(inp.readLine());
					Course c = UniSystem.getDatabase().getCourses().get(chCourse-1);
					System.out.println("Select lesson for view attendance: ");
					ind = 1;
					for(Lesson l : c.getLessons()) {
						System.out.println(ind + ". " + l.toString());
						ind++;
					}
					int chLesson = Integer.parseInt(inp.readLine());
					Lesson l = c.getLessons().get(chLesson-1);
					System.out.println("Select student for what you want put late mark: ");
					ind = 1;
					for(Student s : l.getStudents()) {
						System.out.println(ind + ". " + s.getName() + s.getSurname());
						ind++;
					}
					int chSt = Integer.parseInt(inp.readLine());
					Student s = l.getStudents().get(chSt-1);

					((Teacher)user).putLateAttendanceMark(s, l.getAR());
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			UniSystem.getDatabase().write();
		}
	}
}