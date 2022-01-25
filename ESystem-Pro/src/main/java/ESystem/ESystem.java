package ESystem;

import java.util.Scanner;

public class ESystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//main menu
				Scanner input = new Scanner(System.in);
				String selection = "";
				
				while(!selection.equals("x"))  //while not x, keep displaying the menu
				{
					//display the menu
					System.out.println();
					System.out.println("**** Go Hawks! ****");
		            System.out.println("Please make your selection");
		            System.out.println("1: e-Service");
		            System.out.println("2: BlackBoard");
		            System.out.println("x: Leave");
		            System.out.println();
					
					//get the selection from the user
					selection = input.nextLine();
					System.out.println();
					
					ESystem login = new ESystem();
					User user = new User();
					EService eservice = new EService();
					Blackboard bb = new Blackboard();
					
					user = login.login();
					
					if(user == null)
				    {
				        System.out.println("The login failed");
				        System.out.println();
				        continue;
				    }
					
					else {
						//based on the input, go to different function
						if(selection.equals("1"))
						{
						    String type = user.getType();
								
							if(type.equals("student")) {
							    		
								eservice.studentEService(user);
							  }
							else if(type.equals("faculty")) {
							    		
							    eservice.facultyEService(user);
							    	}
							    
						}
						else if(selection.equals("2"))
						{
							
						    	String type = user.getType();
								
								if(type.equals("student")) {
							    		
							    		bb.studentBB(user);
							    	}
							    	else if(type.equals("faculty")) {
							    		
							    		bb.facultyBB(user);
							    	}
							    }

					}
					
				}

			}

	
	
	
      public User login() {
			
			Hibernate data = new Hibernate();
			
			Scanner input = new Scanner(System.in);
		    String id ="";
		    String password ="";
		    
		    //get the login info.
		    System.out.println("Please enter your ID");
		    id = input.nextLine();
		    System.out.println("Please enter your password");
		    password = input.nextLine();

	    data.setup();
	    User user = data.login(id, password);
	    data.exit();
	    
	    return user;
	
	}
		
}



