import java.util.Scanner;

public class Login {
	
	private DataStorage data;
	public String type;


	public Login(DataStorage d) {
		
		data= d;
		
	}
	public void enterInfo() {
	
		Scanner input = new Scanner(System.in);
	    String id ="";
	    String password ="";
	    
	    //get the login info.
	    System.out.println("Please enter your ID");
	    id = input.nextLine();
	    System.out.println("Please enter your password");
	    password = input.nextLine();

    
    type = data.login(id, password);
    //database and sql
    if(type != null)
    {
    	if(type.equals("Regular")) {
    		
    		RegularUser regular = new RegularUser(id);
    		regular.welcome();
    	}
    	else if(type.equals("admin")) {
    		
    		AdminUser admin = new AdminUser(id);
    		admin.welcome();
    	}
    }
    else
    {
        System.out.println("The login failed");
        System.out.println();
    }
	}
}
