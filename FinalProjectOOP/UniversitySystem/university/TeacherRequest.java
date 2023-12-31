package university;

import java.util.*;

public class TeacherRequest extends Request {
	private TeacherRequestType type;
	
	public TeacherRequest(Language language, RequestForm form, TeacherRequestType type) {
		super(language, form);
		this.type = type;
	}
	public TeacherRequestType getType() {
        return this.type;
    }
    public void setType(TeacherRequestType type) {
        this.type = type;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherRequest other = (TeacherRequest) obj;
		return super.equals(obj) && type == other.type;
	}
	@Override
	public String toString() {
		return super.toString() + "TeacherRequestType: " + this.type;
	}
    
    
}
