package university;

import java.time.LocalTime;
import java.util.*;
import java.util.Map.Entry;
public class AttendanceReport {
	private HashMap<Student, Presence> attendance;
	private LocalTime closeTime;

	public AttendanceReport(int minute){
		closeTime = LocalTime.now().plusMinutes(minute);
	}

	public HashMap<Student, Presence> getAttendance(){
		return attendance;
	}
	public LocalTime getCloseTime() {
		return closeTime;
	}
	
	@Override
	public String toString() {
		String res = "";
		
		for(Entry<Student, Presence> i : attendance.entrySet()) {
			res += i.getKey() + " - " + i.getValue() + "\n";
		}
		
		return res;
	}
}