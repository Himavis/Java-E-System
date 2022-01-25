import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularUser extends UserAccount{
	
	
	public RegularUser(String userid) {
		super(userid);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void welcome() {
 
        Scanner input = new Scanner(System.in);
        String selection = "";
        
        System.out.println();
        System.out.println("**** Hello "+userid+"! Welcome to Travelor Advisor ****");
        System.out.println();
         
        while(!selection.equals("x"))
        {
        	System.out.println();
            System.out.println("Please select your options");
            System.out.println("c: Create an attraction");
            System.out.println("s: Search");
            //comments and Q and A is under this function
            System.out.println("f: Favorite");
            System.out.println("r: Show Recommendation");
            System.out.println("n: Notification");
            System.out.println("x: Sign out\n");
            
            //after display the menu, we ask the user to input selection
            selection = input.nextLine();
            
            if(selection.equals("c")){
            	
            	Attraction createattraction = new Attraction();
            	createattraction.createAttraction();
            }

            else if(selection.equals("s")) {
                
            	System.out.println("Please enter the attraction's city or tag:");
                String name = input.nextLine();
                SearchSystem search = new SearchSystem(userid);
            	search.Search(name);
            }
            else if(selection.equals("r")) {

            	recommendation(userid);
            }
            else if(selection.equals("f")) {

            	favor();
            }
            else if(selection.equals("n")) {

            	Notification msg = new Notification(userid);
            	msg.notification();
            }
        }
	}
	
		
		public void recommendation(String userid) {
			
			DataStorage data = new SQL_Database();
			
			ArrayList<String> tag = new ArrayList<String>();
			tag = data.getTag(userid);
			String tag1 = tag.get(0);
			String tag2 = tag.get(1);
			System.out.println("Recommendation based on your tags:");
			System.out.println("Tag 1: "+tag1+" Tag 2: "+tag2);
			
			System.out.println();
			
			ArrayList<Attraction> result = new ArrayList<Attraction>();
			result = data.recommendation(tag1, tag2);
			if(result.size() == 0) {
				System.out.println("No matching recommendation");
			}
			
			else {
				for(int i =0;i <result.size();i++){
					DecimalFormat df  = new DecimalFormat("#.#");
					System.out.println("Recommendation "+(i+1)+" : "+result.get(i).getTitle()+" "+df.format(result.get(i).getScore()));
					
				}
				
			System.out.println();
			
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the number of attraction you want to view:");
        	int attselect = Integer.valueOf(input.nextLine());
        	System.out.println();
        	DecimalFormat df  = new DecimalFormat("#.#");
        	
        	System.out.println("Title:"+" "+result.get(attselect-1).getTitle());
        	System.out.println("Description:"+" "+result.get(attselect-1).getDescription());
        	System.out.println("Tag:"+" "+result.get(attselect-1).getTag());
        	System.out.println("City:"+" "+result.get(attselect-1).getCity());
        	System.out.println("Score:"+" "+df.format(result.get(attselect-1).getScore()));
        	
        	System.out.println();          
			}
			
	}
			
			
			public void favor() {
				
				DataStorage data = new SQL_Database();
				Scanner input = new Scanner(System.in);
		        String selection = "";
		        
				while(!selection.equals("x"))
		        {
		            System.out.println("v: View favor");
		            System.out.println("a: Add favor");
		            System.out.println("x: Exist");
		            
		            //after display the menu, we ask the user to input selection
		            selection = input.nextLine();
		            
		            if(selection.equals("v")){
		            	
		            	ArrayList<Attraction> favor = new ArrayList<Attraction>();
		            	favor = data.viewFavor(userid);
		            	
		            	if(favor.size() == 0) {
		    				System.out.println("No matching recommendation");
		    			}
		    			
		    			else {
		    				for(int i =0;i <favor.size();i++){
		    					DecimalFormat df  = new DecimalFormat("#.#");
		    					System.out.println("Favorite "+(i+1)+" : "+favor.get(i).getTitle()+" "+df.format(favor.get(i).getScore()));
		    					
		    				}
		    				
		    			System.out.println();

		    			System.out.println("Please enter the number of attraction you want to view:");
		            	int attselect = Integer.valueOf(input.nextLine());
		            	System.out.println();
		            	DecimalFormat df  = new DecimalFormat("#.#");
		            	
	                	System.out.println("Title:"+" "+favor.get(attselect-1).getTitle());
	                	System.out.println("Description:"+" "+favor.get(attselect-1).getDescription());
	                	System.out.println("Tag:"+" "+favor.get(attselect-1).getTag());
	                	System.out.println("City:"+" "+favor.get(attselect-1).getCity());
	                	System.out.println("Score:"+" "+df.format(favor.get(attselect-1).getScore()));
           	
		            	System.out.println();
		            	
		            	//display the favor as a attraction arraylist
		    			}
		            }
		            
		            else if(selection.equals("a"))
		            {
		            	System.out.println("Please enter attraction's name:");
		            	String title = input.nextLine();
		            	data.addFavor(title,userid);
		            	
		            }
		            else {

		            	break;
		            }
				
			}
			
		}
		

        
}
			
		

