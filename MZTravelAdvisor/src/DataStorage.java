import java.util.ArrayList;

public interface DataStorage {

	void createUserAccount(String userID, String password, String tag1, String tag2, String type);
	String login(String userID, String password);
	void createAttraction(String title, String description, String tag, String city, String status, double score);
	ArrayList<Attraction> pendingAttraction();
	void approveAttraction(String title);
	void rejectAttraction(String title);
	void writeComments(String title, String content, int score, String datetime, String userID);
	void avgScore(String title);
	ArrayList<Attraction> search(String title);
	ArrayList<Attraction> recommendation(String tag1, String tag2);
	ArrayList<String> getTag(String userid);
	
	ArrayList<Attraction> viewFavor(String userid);
	void addFavor(String title, String userid);
	
	void askQuestion(String title, String question, String userid, String datetime, String status);
	ArrayList<QuestionandAnswer> getQuestion(String title);
	String getQuestion(String questionID,String title);
	
	void answerQuestion(String questionID, String title, String answer, String userid, String datetime, String status);
	ArrayList<QuestionandAnswer> getAnswer(String userid);
	
	void readAnswer(ArrayList<String> listid);
	void readAnswer(String questionID, String userid);

}
