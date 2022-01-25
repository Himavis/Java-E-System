package ESystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard {

	Scanner input = new Scanner(System.in);
	Hibernate data = new Hibernate();
	
	
	public void studentBB(User user) {
		
		User student = new User();
		student = user;

		String selection = "";
		
		data.setup();
		ArrayList<Enrollment> studentcourses = new ArrayList<Enrollment>();
		studentcourses = data.studentEnrollment(student.getId());
		data.exit();
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			
			System.out.println();
			System.out.println("**** Welcome to Student Blackboard ****");
			
			if(studentcourses.isEmpty()) {
				
				 System.out.println("x: Leave Blackboad");
		         System.out.println();
				selection = input.nextLine();	
				
				}
			
			else {
				
				System.out.println("Please select your course:");
		   		
	            for(int i =0;i < studentcourses.size();i++) {
	    			
	            	System.out.println((i+1) +": "+ studentcourses.get(i).getCourseID());
	    			
	    			}
				 System.out.println("x: Leave Blackboad");
				 selection = input.nextLine();
				 
				
				 if(!selection.equals("x"))
					{
		            	try {
		            		
		            		int atselect = Integer.valueOf(selection);
		            		String currentcourseID = studentcourses.get(atselect-1).getCourseID();
		            	}
		            	
		            	catch(Exception e){
		            		
		            		System.out.println("Please enter again!");
		            		continue;
		            		
		            	}
		            	
		            	int atselect = Integer.valueOf(selection);
		        		System.out.println(studentcourses.get(atselect-1).getCourseID());
		        		String currentcourseID = studentcourses.get(atselect-1).getCourseID();
		        		
		        		while(!selection.equals("x")) {
		        		
		        		System.out.println("v: View course note");
		                System.out.println("x: Leave the course");
		                System.out.println();
		                
		                String courseselect = input.nextLine();
		                
		                if(courseselect.equals("v")) {
		                	
		                	data.setup();
		                	ArrayList<Post> posts = new ArrayList<Post>();
		                	posts = data.viewPost(currentcourseID);
		                	data.exit();
		                	
		                	if(posts.isEmpty()) {
		                		
		                		System.out.println("None");
		                		
		                		}
		                		
		                	else {
		                			for(Post p:posts) {
		                			
		            				System.out.println("Course notes of " + p.getCourseID()+ ":");
		            				System.out.println(p.getDatetime()+": " +p.getPost());
		                			
		                			}
		                			
		                			break;
		                			
		                		}
		                	
		                }
		                else {

		                	break;
		                }
	        		}
					}
			}
		}		
		}

	
	
	
	public void facultyBB(User user) {
		
		User faculty = new User();
		faculty = user;

		String selection = "";
        
        data.setup();
		ArrayList<Course> courses = data.facultyCourse(faculty.getId());
		data.exit();
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
			System.out.println("**** Welcome to Faculty Blackboard ****");
            System.out.println("Please select your course:");

			for(int i =0;i < courses.size();i++) {
				System.out.println((i+1) +": "+courses.get(i).getCourseID());
			}

            System.out.println("x: Leave Blackboad");
            System.out.println();
			
			//get the selection of course from the 
            selection = input.nextLine();
            
            if(!selection.equals("x"))
			{
            	try {
            		
            		int atselect = Integer.valueOf(selection);
            		String currentcourseID = courses.get(atselect-1).getCourseID();
            	}
            	
            	catch(Exception e){
            		
            		System.out.println("Please enter again!");
            		continue;
            		
            	}
            	
            	int atselect = Integer.valueOf(selection);
        		System.out.println(courses.get(atselect-1).getCourseID());
        		String currentcourseID = courses.get(atselect-1).getCourseID();
        		
        		while(!selection.equals("x")) {
        		
        		System.out.println("v: View course note");
                System.out.println("p: Post new note");
                System.out.println("x: Leave the course");
                System.out.println();
                
                String courseselect = input.nextLine();
                
                if(courseselect.equals("v")) {
                	
                	data.setup();
                	ArrayList<Post> posts = new ArrayList<Post>();
                	posts = data.viewPost(currentcourseID);
                	data.exit();
                	
                	if(posts.isEmpty()) {
                		
                		System.out.println("None");
                		
                		}
                		
                	else {
                			for(Post p:posts) {
                			
            				System.out.println("Course notes of " + p.getCourseID()+ ":");
            				System.out.println(p.getDatetime()+": " +p.getPost());
                			
                			}
                		}
                	
                }
                else if(courseselect.equals("p")) {
                	
                	System.out.println("Please enter your note:");
                	String newpost = input.nextLine();
                	String datetime = DateAndTime.DateTime();
                    System.out.println();
                    
                    data.setup();
                    data.newPost(currentcourseID, newpost, datetime);
                    data.exit();
                    System.out.println("Your note is added to the course. Your students can see it now.");
                	
                }
                else {

                	break;
                }
				    
			}
		}
			
		}
	}
}

