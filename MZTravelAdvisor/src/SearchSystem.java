import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchSystem extends RegularUser {
	
	public SearchSystem(String userid) {
		super(userid);
	}
	
	public void Search(String title) {
		
		DataStorage data = new SQL_Database();
		ArrayList<Attraction> result = new ArrayList<Attraction>();
		result = data.search(title);
			if(result.size()==0) {
				
				System.out.println("Nothing Found!!!");
			}
			else {
				
				for(int i=0; i< result.size(); i++) {
            		
					DecimalFormat df  = new DecimalFormat("#.#");
            		System.out.println(i+1+": "+result.get(i).getTitle()+" "+result.get(i).getCity()+" "+result.get(i).getTag()+ " "+df.format(result.get(i).getScore()));
            		
            	}
				System.out.println();
				System.out.println("Please enter the number of attraction you want to view:");
				System.out.println("0: Exist");
				Scanner input = new Scanner(System.in);
            	int attselect = Integer.valueOf(input.nextLine());
            	System.out.println();
            	
            	if (attselect!=0) {
            		
            		DecimalFormat df  = new DecimalFormat("#.#");
            		System.out.println();
                	System.out.println("Title:"+" "+result.get(attselect-1).getTitle());
                	System.out.println("Description:"+" "+result.get(attselect-1).getDescription());
                	System.out.println("Tag:"+" "+result.get(attselect-1).getTag());
                	System.out.println("City:"+" "+result.get(attselect-1).getCity());
                	System.out.println("Score:"+" "+df.format(result.get(attselect-1).getScore()));

                	System.out.println();
                	
                	String resultTitle = result.get(attselect-1).getTitle();
                	
                	System.out.println("w: Write Comments");
                	System.out.println("d: Display questions");
                	System.out.println("a: Ask question");
                	System.out.println("x: Exist");
                	
                	String selection = input.nextLine();
                     
                    if(selection.equals("w")){
                    	//pass value, test comment
                    	WriteComments(resultTitle);
                    }
                    
                    else if(selection.equals("a")){
                    	
                	QuestionandAnswer question = new QuestionandAnswer(userid);
                	question.ask(resultTitle);
                	
                    }
                    else if(selection.equals("d")){
                    	
                    	QuestionandAnswer question = new QuestionandAnswer(userid);
                    	question.display(resultTitle);
                    	
                        }
            	}
            	
            	else {
            		;
            	}
		
			}
		
	}

	
		
		public void WriteComments(String resultTitle){
			
			Scanner input = new Scanner(System.in);
	
			System.out.println("Please enter the comment: ");
			String content = input.nextLine();
			System.out.println("Please enter the score 1-5: ");
			int score = input.nextInt();
			String datetime = DateAndTime.DateTime();
		
			DataStorage data = new SQL_Database();
			data.writeComments(resultTitle, content, score, datetime, userid);
			
			// update avg to the attraction
			data.avgScore(resultTitle);
		
	}
		
}
