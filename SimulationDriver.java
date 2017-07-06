/* Priyanka Patel
 * CS 356
 * Due: 07/05/2017
 */
import java.util.Random;
public class SimulationDriver {
	public static void main(String[] args) {
		// create questions for testing
		driver(1, " An interface can extend or implement another interface.");
		driver(2, " Which of the following cannot be declared static?");
	}
	// method for creating a question and getting it's random answers
	public static void driver(int queType, String question) {

		Random rand = new Random();
		// generate random students between 10 and 60 
		int StudentRandom = rand.nextInt(50) + 10; 
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Question Type:" + queType + " -->" + question );
		System.out.println("-------------------------------------------------------------------------");
		// initialize first with false value
		boolean[] keepAnswer = { true, true, true, true };
		Question tmp = new Question(queType, question);
		IVoteService ivs = new IVoteService(tmp);
		for (int i = 0; i < StudentRandom; i++) {
			// generate random student Id for students
			Student ranGenStudent = new Student(rand.nextInt(150) + ""); 
			if (tmp.getqueType() == 2) {
				for (int j = 0; j < keepAnswer.length; j++) {
					// generate random answer(s) for multiple choice
					keepAnswer[j] = (rand.nextInt(2) != 0); 
				} 
			} else{
				// generate random answer for true & false
				keepAnswer[rand.nextInt(2)] = false; 
			}
			// keep update of every students answers
			ivs.updateAnswers(ranGenStudent.getStudentID(), keepAnswer); 
			// reset answer for upcoming student
			for (int k = 0; k < keepAnswer.length; k++) { 
				keepAnswer[k] = true;
			}
		}
		// printAnsers: prints the random generated answers
		ivs.printAnswers();
		System.out.println("Total number of answer submitted: " + StudentRandom);
		System.out.println();

	}
}