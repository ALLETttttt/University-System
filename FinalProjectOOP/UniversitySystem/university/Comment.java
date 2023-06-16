package university;


import java.time.LocalDate;

public class Comment {
    private String text;
    private LocalDate date;
    
    public Comment() {
    	this.date = LocalDate.now();
    }
    public Comment(String text) {
    	this();
		this.text = text;
	}
    
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDate getDate() {
        return this.date;
    }
    
	@Override
	public String toString() {
		return "Comment [text=" + text + ", date=" + date + "]";
	}
    
}
