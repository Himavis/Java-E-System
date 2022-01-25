import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionandAnswer {

	public String userid;
	public String question;
	public String title;
	public String datetime;
	public String status;
	public String questionID;
	
	public QuestionandAnswer(String userid) {
		this.userid = userid;
		
		// TODO Auto-generated constructor stub
	}
	
	public QuestionandAnswer(String userid, String title) {
		this.title = title;
		this.userid = userid;
	}
	
	public QuestionandAnswer(String questionID, String title, String question, String userid, String datetime, String status) {
		
		this.questionID = questionID;
		this.title = title;
		this.question = question;
		this.userid = userid;
		this.datetime= datetime;
		this.status = status;
	}
	
	
	public void ask(String title) {
		
		Scanner input = new Scanner(System.in);
		DataStorage data = new SQL_Database();
		
			System.out.println("Please enter your question:");
			String question = input.nextLine();
			
			String status = "Unanswered";
			String datetime = DateAndTime.DateTime();
			
			data.askQuestion(title, question, userid, datetime, status);
		
	}
	
	public void display(String title) {
		
		DataStorage data = new SQL_Database();
		ArrayList<QuestionandAnswer> display = new ArrayList<QuestionandAnswer>();
		display = data.getQuestion(title);
		
		if(display.size() == 0) {
			System.out.println("No questions found!!!");
			System.out.println();
		}
		
		else {
			for(int i =0;i <display.size();i++){
				System.out.println("Question: "+(i+1)+" : "+ display.get(i).getQuestion()+" ");
				System.out.println();
			}
			System.out.println("Please enter the number of question you want to answer:");
			System.out.println("0: Exist");
			
			Scanner input = new Scanner(System.in);
        	int attselect = Integer.valueOf(input.nextLine());
        	System.out.println();
        	
        	if (attselect!=0) {
        		String currentid = display.get(attselect-1).getQuestionID(); 	
        		String currenttitle = display.get(attselect-1).getTitle();
        		answer(currentid,currenttitle);
        	}
		
		}
	}
	
	public void answer(String questionID,String title) {
		
		Scanner input = new Scanner(System.in);
		DataStorage data = new SQL_Database();
		
			System.out.println("Please enter your answer:");
			String answer = input.nextLine();
			
			String status = "Unread";
			String datetime = DateAndTime.DateTime();
		
		data.answerQuestion(questionID, title, answer, userid, datetime, status);

		
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
