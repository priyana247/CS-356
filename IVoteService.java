/* Priyanka Patel
 * CS 356
 * Due: 07/05/2017
 */
import java.util.Hashtable;
public class IVoteService {
private Question select;
	private Hashtable<String, boolean[]> Answer = new Hashtable<String, boolean[]>();
	// numberOfAnswer : count the answers
	private int[] numberOfAnswers = { 0, 0, 0, 0 }; 
	// constructor
	public IVoteService(Question question) { 
		this.select = question;
	}
	public void updateAnswers(String student, boolean[] studentAnswers) {
		// as student submit answer, it increments the answers
		for (int i = 0; i < 4; i++) { 
			if (studentAnswers[i])
				numberOfAnswers[i]++;
		}
		// using hashtable's containsKey method, 
		// check if the student already has same answer, 
		//remove that particular student from the counter
		if (Answer.containsKey(student)) { 
			boolean[] lastAnswer = Answer.get(student);
			for (int i = 0; i < 4; i++) {
				if (lastAnswer[i])
					numberOfAnswers[i]--;
			}
			// submit the new answers
			Answer.put(student, studentAnswers); 
			// print answer of student who change their answer again
			System.out.println("ID: "+ student + " changed answer to "
					+ Answers(studentAnswers, select.getqueType()));
		} else {
			// submit answers for the first time
			Answer.put(student, studentAnswers); 
			// print student selected answer with that specific student's ID
			System.out.println("ID: " + student + " :chooses " 
					+ Answers(studentAnswers, select.getqueType()));
		}
	}
	private String Answers(boolean[] studentAnswers, int queType) {
		// choose answers based on question type
		String tmp = "";
		if (queType == 1) {
			if (studentAnswers[0]) {
				tmp += "True";
			}
			if (studentAnswers[1]) {
				tmp += "False";
			}
			
		} else {
			if (studentAnswers[0]) {
				tmp += "A";
			}
			if (studentAnswers[1]) {
				tmp += "B";
			}
			if (studentAnswers[2]) {
				tmp += "C";
			}
			if (studentAnswers[3]) {
				tmp += "D";
			}
		}
		// if student doesn't submit any answer then it returns 
		// blank for that student
		if (tmp == "") {
			return "blank"; 
		}
		return tmp;
	}
	// print answers
	public void printAnswers() { 
		System.out.println();
		if(select.getqueType() == 2) {
			System.out.println("Student choosen answers:");
			System.out.print("# of A's: ");
			System.out.println(" " + numberOfAnswers[0]);
			System.out.print("# of B's: ");
			System.out.println(" " + numberOfAnswers[1]);
			System.out.print("# of C's: ");
			System.out.println(" " + numberOfAnswers[2]);
			System.out.print("# of D's: ");
			System.out.println(" " + numberOfAnswers[3]);
		}else  {
			System.out.println("Student choosen answers:");
			System.out.print("# of True:  ");
			System.out.println(" " + numberOfAnswers[0]);
			System.out.print("# of False: ");
			System.out.println(" " + numberOfAnswers[1]);
		}
	}
}
