import java.util.ArrayList;
import java.util.Scanner;

public class AdminUser extends UserAccount{
	

	public AdminUser(String userid) {
		
		super(userid);
	}
	
	
	@Override
	public void welcome() {
		 
        Scanner input = new Scanner(System.in);
        String selection = "";
        
        System.out.println();
        System.out.println("**** Welcome Admin to Travelor Advisor ****");
        System.out.println();
         
        while(!selection.equals("x"))
        {
        	System.out.println();
            System.out.println("Please select your options");
            System.out.println("n: Approve or Reject Attraction");
            System.out.println("x: Sign out");
            
            //after display the menu, we ask the user to input selection
            selection = input.nextLine();
            
            if(selection.equals("n")){
            	
            	System.out.println("Please review the pending creation of attraction:");
            	DataStorage data = new SQL_Database();
            	ArrayList<Attraction> pendingAttration = new ArrayList<Attraction>();
            	
            	
            	while(!selection.equals("x")) {
            	
            	pendingAttration = data.pendingAttraction();
            	
            	if(pendingAttration.size() == 0) {
            		
            		System.out.println("No pending attraction!!!");
            		System.out.println();
            		break;
            	}
            		
            	else{
            		
            		for(int i=0; i<pendingAttration.size(); i++) {
                		
                		System.out.println(i+1+": "+pendingAttration.get(i).getTitle()+" "+pendingAttration.get(i).getCity());
                		
                	}
                	
                	System.out.println("Please enter the number of attraction you want to change:");
                	int attselect = Integer.valueOf(input.nextLine());
                	System.out.println();

                	System.out.println(pendingAttration.get(attselect-1).getTitle()+" "+
                			pendingAttration.get(attselect-1).getDescription()+" "+
                			pendingAttration.get(attselect-1).getTag()+" "+
                			pendingAttration.get(attselect-1).getCity()+" "+
                			pendingAttration.get(attselect-1).getStatus()+" "+
                			pendingAttration.get(attselect-1).getScore());
                	
                	System.out.println();
                	
                    System.out.println("Please choose next move:");
                    System.out.println("a: Approve");
                    System.out.println("r: Reject");
                    System.out.println("x: Exit");
                    
                    String appRej = input.nextLine();
                    
                    if(appRej.equals("a")) {
                    	String title = pendingAttration.get(attselect-1).getTitle();
                    	data.approveAttraction(title);
                    	System.out.println("Approval Successful!");
                    	continue;
                    }
                    else if(appRej.equals("r")) {
                    	
                    	String title = pendingAttration.get(attselect-1).getTitle();
                    	data.rejectAttraction(title);
                    	System.out.println("Rejection Successful!");
                    	continue;
                    }
                    else if(appRej.equals("x")) {
                    	break;
                    }
            		
            	}
            }
        }
            
       
        } 
            
            
	}
	
	}


