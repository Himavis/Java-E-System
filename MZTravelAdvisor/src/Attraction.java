import java.util.Scanner;

public class Attraction {
	
	public String title;
	public String description;
	public String tag;
	public String city;
	public String status;
	public double score;
	
	
		public Attraction(String title, String description, String tag, String city, String status, double score) {
		
			this.title = title;
			this.description = description;
			this.tag = tag;
			this.city = city;
			this.status = status;
			this.score = score;
	}
		public Attraction() {
			;
		};

		 public void createAttraction() {
	        	
       	  Scanner input = new Scanner(System.in);
       	  String title, description, tag, city, status;
       	  double score;
             
             System.out.println("Please enter the tile:");
             title = input.nextLine();
             System.out.println("Please enter description");
             description = input.nextLine();
             System.out.println("Please enter a tag");
             tag = input.nextLine();
             System.out.println("Please enter city");
             city = input.nextLine();
             
             status = "Pending";
             score = 0;
             
             DataStorage data = new SQL_Database();
             
             data.createAttraction(title, description, tag, city, status, score);
       	  
             System.out.println("Please wait for approval.");
             System.out.println();
             
		 }
		public void pendingAttraction() {
			
            DataStorage data = new SQL_Database();
			
			System.out.println("pending attraction display here");
		}
		
		public void approveAttraction() {
			System.out.println("display here");
		}

		

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}
		
}
