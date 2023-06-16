package university;

public class Mark {

    private MarkType markType;
    private double score;

    public Mark(MarkType mt, double score) {
    	this.markType = mt;
    	this.score = score;
    }

	public double getScore() {
		return score;
	}
	public String toString() {
		return "Mark [markType=" + markType + ", score=" + score + "]";
	}
    
}
