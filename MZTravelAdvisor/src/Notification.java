import java.util.ArrayList;
import java.util.Scanner;

public class Notification extends RegularUser {



	public Notification(String userid) {
		super(userid);
	}
	
	
	public void notification() {

		while(true) {
			
			DataStorage data = new SQL_Database();
			ArrayList<QuestionandAnswer> display = new ArrayList<QuestionandAnswer>();
			display = data.getAnswer(userid);
			
		if(display.size() == 0) {
			System.out.println("No Notification!!!");
			System.out.println();
			break;
		}
		
		else {

			ArrayList<String> listid  = new ArrayList<String>();
			
			for(int i =0;i <display.size();i++){

				
				String question = data.getQuestion(display.get(i).getQuestionID(), userid);
				
				System.out.println("Question: "+(i+1)+" : "+ question);
				System.out.println("Answer: "+(i+1)+" : "+ display.get(i).getQuestion());
				System.out.println("Attraction: " + display.get(i).getTitle());
				System.out.println("User: " + display.get(i).getUserid());
				System.out.println("Time: " + display.get(i).getDatetime());
				
				System.out.println();
				
				listid.add(display.get(i).getQuestionID());
			}
			System.out.println();
			System.out.println("1: Mark 1 as read");
			System.out.println("m: Mark all as read");
			System.out.println("x: Exist");
			
			Scanner input = new Scanner(System.in);
        	String attselect = input.nextLine();
        	System.out.println();
        	
        	if (attselect.equals("m")) {
        		
            	data.readAnswer(listid);
            	break;
        	}
        	else if(attselect.equals("x")) {
        		
        		break;
        	}
        	else if (attselect.equals("1")) {
        		
        		System.out.println();
        		System.out.println("Enter the number of answer you would like to mark read:");
        		int select = Integer.valueOf(input.nextLine());
        		
        		String questionID = display.get(select-1).getQuestionID();
        		String answerUserid = display.get(select-1).getUserid();
        		data.readAnswer(questionID,answerUserid);
        		
        		continue;
        		
        		
        		}
		}
	}
	}
}
