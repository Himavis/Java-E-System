package ESystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EService {

	Scanner input = new Scanner(System.in);
	Hibernate data = new Hibernate();
	
	
	public void studentEService(User user) {
		
		User student = new User();
		student = user;
		
		String selection = "";
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
			System.out.println("**** Welcome to Student E-Service ****");
            System.out.println("Please make your selection");
            System.out.println("v: View my courses");
            System.out.println("r: Register a course");
            System.out.println("x: Logout");
            System.out.println();
			
			//get the selection from the user
			selection = input.nextLine();
			System.out.println();
			
			//based on the input, go to different function
			if(selection.equals("v"))
			{
				data.setup();
				ArrayList<Enrollment> results = new ArrayList<Enrollment>();
				results = data.studentEnrollment(user.getId());
				data.exit();
				
				if(results.isEmpty()) {
					
					System.out.println("None");
					
				}
				else {
					
					for(Enrollment r:results) {
	        			
	    				System.out.println(r.getCourseID()+ ", " + "Instructor: Dr." + r.getInstructor());
	        			
	        			}
				}
				
			}
			else if(selection.equals("r"))
			{
				
				while(!selection.equals("x"))  //while not x, keep displaying the menu
				{
					data.setup();
					ArrayList<Course> results = new ArrayList<Course>();
					results = data.searchCourse(user.getMajor());
					data.exit();
					
					if(results.isEmpty()) {
            		
						System.out.println("Welcome to register a new course!");
						System.out.println("Sorry there is no courses available to you.");
						break;//try here
            		
            		}
            		
					else {
            		
						System.out.println("Welcome to register a new course!");
						System.out.println("These are the courses available to you:");
    				
						for(int i =0;i < results.size();i++) {
							
							System.out.println((i+1) +": "+results.get(i).getCourseID());
						}
						
						System.out.println("b: Back");
            		}
				
				selection = input.nextLine();
				
				if(selection.equals("b")) {
					
					break;
					
				}
				
				else {
					
					try {
	            		
	            		int atselect = Integer.valueOf(selection);
	            		String currentcourseID = results.get(atselect-1).getCourseID();
	            	}
	            	
	            	catch(Exception e){
	            		
	            		break;
	            		
	            	}
	            	
	            	int atselect = Integer.valueOf(selection);
	            	String chosenCourseID = results.get(atselect-1).getCourseID();
	            	String instructor = results.get(atselect-1).getInstructor();
	            	
	            	data.setup();
	            	data.registerCourse(user.getId(),chosenCourseID,instructor);
	            	data.exit();
	            	
	            	continue;
					
						}
				}

				    
			}
		}
	}
	
	
	
	public void facultyEService(User user) {
		
		User faculty = new User();
		faculty = user;

		String selection = "";
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
			System.out.println("**** Welcome to Faculty E-Service ****");
            System.out.println("Please make your selection");
            System.out.println("v: View my courses");
            System.out.println("x: Logout");
            System.out.println();
			
			//get the selection from the user
			selection = input.nextLine();
			System.out.println();
			
			//based on the input, go to different function
			if(selection.equals("v"))
			{
				data.setup();
				ArrayList<Course> courses = data.facultyCourse(faculty.getId());
				ArrayList<Enrollment> students = data.facultyEnrollment(faculty.getId());
				data.exit();
			
				for(Course b:courses) {
					System.out.println(b.getCourseID());
					System.out.println("Students enrolled:");
					
					for(Enrollment s:students) {
						
						if(b.getCourseID().equals(s.getCourseID())) {
							
							System.out.println(s.getId());
						}
					}
					//nest loop for student list 
					System.out.println();
				}			    
			}
		}
	}
}
