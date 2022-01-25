import java.util.Scanner;

public class TravelAdvisor {
//main 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//main menu
		Scanner input = new Scanner(System.in);
		String selection = "";
		DataStorage data = new SQL_Database();
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
			System.out.println("**** Welcome to Travel Advisor ****");
            System.out.println("Please make your selection");
            System.out.println("1: Create a new online ID");
            System.out.println("2: Login your online account");
            System.out.println("x: Leave the Travel Advisor system");
            System.out.println();
			
			//get the selection from the user
			selection = input.nextLine();
			System.out.println();
			
			//based on the input, go to different function
			if(selection.equals("1"))
			{
				//open a new checking 
				new Registration(data).enterInfo();
			}
			else if(selection.equals("2"))
			{
				new Login(data).enterInfo();
			}
			 	 
		}

	}
}
