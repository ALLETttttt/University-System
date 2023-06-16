package university;

public class StudentRequest extends Request {
	private StudentRequestType type;
	
	
    public StudentRequest(Language language, RequestForm form, StudentRequestType type) {
		super(language, form);
		this.type = type;
	}
	public StudentRequestType getType() {
        return this.type;
    }
    public void setType(StudentRequestType type) {
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
		StudentRequest other = (StudentRequest) obj;
		return super.equals(obj) && type == other.type;
	}
	@Override
	public String toString() {
		return super.toString() + "StudentRequestType: " + this.type;
	}
    
}
