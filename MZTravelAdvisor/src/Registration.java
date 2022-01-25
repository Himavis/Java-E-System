import java.util.Scanner;

public class Registration {
	
	DataStorage data; 

    public Registration(DataStorage d)
    {
    	data = d;
    }

	public void enterInfo()
    {
    	 Scanner input = new Scanner(System.in);
         //get the id, password, tag1, tag2
         String accountID, password, tag1, tag2;
         
         System.out.println("Please enter your login ID");
         accountID = input.nextLine();
         System.out.println("Please enter your new password");
         password = input.nextLine();
         System.out.println("Please enter your first tag");
         tag1 = input.nextLine();
         System.out.println("Please enter your second tag");
         tag2 = input.nextLine();
         
         String type = "Regular";
         
     	 data.createUserAccount(accountID, password, tag1, tag2, type); 
        
    }

}
