/* Priyanka Patel
 * CS 356
 * Due: 07/05/2017
 */
public class Question {
	// queType: 1 = true/false,
	// queTyp :2 = multiple choice
	private int queType; 
	// questions 
	private String question; 
	//constructor
	public Question(int aueType, String question) { 
		this.queType = queType;
		this.question = question;
	}
	// accessor methods 
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getqueType() {
		return queType;
	}
	public void setqueType(int queType) {
		this.queType = queType;
	}

}
