

public abstract class UserAccount {

	//attributes
    
    public String userid;
    private DataStorage data;

    
    //constructor
    public UserAccount(String userid)
    {   
        this.userid = userid;
    }
    
    public void welcome() {
    	
    	;
    }

		
    //get methods and set methods
	  
	    public String getuserID() {
	        return userid;
	    }

	    public void setUuserID(String userid) {
	        this.userid = userid;
	    }

		public DataStorage getData() {
			return data;
		}

		public void setData(DataStorage data) {
			this.data = data;
		}
}
