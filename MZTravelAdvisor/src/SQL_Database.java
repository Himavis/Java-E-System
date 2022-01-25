import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SQL_Database implements DataStorage{
	
	 final String DATABASE_URL = 
             "jdbc:mysql://mis-sql.uhcl.edu/zhangm3210?useSSL=false";
	 final String db_id = "zhangm3210";
	 final String db_psw = "1767795";
     
	 Connection connection = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	 
	 
	 public void createUserAccount(String userID, String password, String tag1, String tag2, String type)
	 {
	     
		try
        {
            
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "zhangm3210", "1767795");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
            
            //do a query
            resultSet = statement.executeQuery(
            		"Select * from userinfo " + " where userID = '" + userID + "'");
            
            if(resultSet.next())
            {
                System.out.println("Account creation failed");
            }
            else
            {
                //insert a record into userID
            	int r = statement.executeUpdate("insert into userinfo values"
                        + "('" + userID + "', '" + password + "', '"
                        + tag1 +"','"+ tag2 +"','"+ type + "')");
            }
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
	     
	 }
 
	 @Override
	 public String login(String id, String password)
	 {
		try
        {
            
            //connect to the database
			connection = DriverManager.getConnection(DATABASE_URL, 
                  "zhangm3210", "1767795");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from userinfo "
                    + "where userID = '" + id + "'");
            
            if(resultSet.next())
            {
                //the id is found, check the password
                if(password.equals(resultSet.getString(2)))
                {
                  return resultSet.getString(5);
                }
                else
                {
                    //password is not correct
                    return null;
                }
            }
            else
            {
            	return null;
            }
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
	 }

	 public void createAttraction(String title, String description, String tag, String city, String status, double score)
	 {
	     
		try
        {
            
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "zhangm3210", "1767795");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
            
            //do a query
            resultSet = statement.executeQuery(
            		"Select * from attractions " + " where title = '" + title + "'");
            
            if(resultSet.next())
            {
                System.out.println("Attraction creation failed");
            }
            else
            {
                //insert a record into attractions
            	int r = statement.executeUpdate("insert into attractions values"
                        + "('" + title + "', '" + description + "', '"
                        + tag +"','"+ city +"','"+ status + "','"+ score + "')");
            }
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
	     
	 }
	 @Override
	 public ArrayList<Attraction> pendingAttraction()
	 {
		try
        {
            
            //connect to the database
			connection = DriverManager.getConnection(DATABASE_URL, 
                  "zhangm3210", "1767795");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from attractions where status = 'Pending'");
            ArrayList<Attraction> aPendingAttraction = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
            	Attraction pendingAttraction = new Attraction(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(6));
            	aPendingAttraction.add(pendingAttraction);
            }
            return aPendingAttraction;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }
            
        }
		return null;
		
	 }
	 
	 public void approveAttraction(String title)
	 {
	     
		try
        {
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "zhangm3210", "1767795");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
            
            //do a query
            resultSet = statement.executeQuery("Select * from attractions "
                    + "where title = '" + title + "'");
            
            if(resultSet.next())
            {
                int r = statement.executeUpdate("Update attractions set status = 'Success' " + "where title = '" + title + "'");
        
            }
            else
            {
            	;
            }
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
	     
	 }
	 
	 
	 public void rejectAttraction(String title)
	 {
	     
		try
        {
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "zhangm3210", "1767795");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
            
            //do a query
            resultSet = statement.executeQuery("Select * from attractions "
                    + "where title = '" + title + "'");
            
            if(resultSet.next())
            {
                int r = statement.executeUpdate("Update attractions set status = 'Reject' " + "where title = '" + title + "'");
        
            }
            else
            {
            	;
            }
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
	     
	 }
	 
	@Override
	public void writeComments(String title, String content, int score, String datetime, String userID) {
	
		try
    {
        
        //connect to the database
        connection = DriverManager.getConnection(DATABASE_URL, 
                "zhangm3210", "1767795");
        connection.setAutoCommit(false);
        //crate the statement
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * from attractions " + " where title = '" + title + "' and status = 'Success'");
        if(resultSet.next()) {
        	int r = statement.executeUpdate("insert into comment values"
                    + "('" + title + "', '" + content + "', '"
                    + score +"','"+ datetime +"','"+ userID + "')");
			System.out.println("Thank you for your comment. ");
			System.out.println();
        }
        else 
        {
        	System.out.println("No such attraction exists!");
        	System.out.println();
        }
        
        connection.commit();
        connection.setAutoCommit(true);
        
    } 
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    finally
    {
         //close the database
         try
         {
             resultSet.close();
             statement.close();
             connection.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
     
 }
 
	
	public void avgScore(String title)
	 {
	     
		try
       {
           //connect to the database
           connection = DriverManager.getConnection(DATABASE_URL, 
                   "zhangm3210", "1767795");
           connection.setAutoCommit(false);
           //crate the statement
           statement = connection.createStatement();
           
           //do a query
           resultSet = statement.executeQuery("Select avg(score) from comment "
                   + "where attraction = '" + title + "'");
           
           
           if(resultSet.next())
           {
        	   double avg = resultSet.getDouble(1);
               int r = statement.executeUpdate("Update attractions set score = '" + avg + "' where title = '" + title + "'");
           }
           else
           {
           	;
           }
           connection.commit();
           connection.setAutoCommit(true);
           
       }
       catch (SQLException e)
       {
           e.printStackTrace();
       }
       finally
       {
            //close the database
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
       }
      }
		
		public ArrayList<Attraction> search(String title) {
			
			try
	    {
	        
	        //connect to the database
	        connection = DriverManager.getConnection(DATABASE_URL, 
	                "zhangm3210", "1767795");
	        connection.setAutoCommit(false);
	        //crate the statement
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("Select * from attractions " + " where (city = '" + title + "' or tag = '" + title + "' or title = '" + title + "') and status = 'Success' order by score desc");
	        ArrayList<Attraction> searchResult = new ArrayList<Attraction>();
	        
	        while(resultSet.next()) {
	        	
				Attraction record = new Attraction(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(6));
	        	searchResult.add(record);

			}
	        return searchResult;
	        
	        //connection.commit();
	        //connection.setAutoCommit(true);
	        
	    } 
	    catch (SQLException e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	    finally
	    {
	         //close the database
	         try
	         {
	             resultSet.close();
	             statement.close();
	             connection.close();
	         }
	         catch(Exception e)
	         {
	             e.printStackTrace();
	         }
	    }

	     
	 }
		
		
      public ArrayList<String> getTag(String userid) {
			
			try
	    {
	        
	        //connect to the database
	        connection = DriverManager.getConnection(DATABASE_URL, 
	                "zhangm3210", "1767795");
	        connection.setAutoCommit(false);
	        //crate the statement
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("Select * from userinfo " + " where userID = '" + userid + "'");
	        ArrayList<String> getTag = new ArrayList<String>();
	        
	        if(!resultSet.next()) {
	        	
	        	System.out.println("Nothing Found!!!");
	        }
	        else {
	        	
	        	getTag.add(resultSet.getString(3));
	        	getTag.add(resultSet.getString(4));
				
				return getTag;
	       }
	        
	        connection.commit();
	        connection.setAutoCommit(true);
	        
	    } 
	    catch (SQLException e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	    finally
	    {
	         //close the database
	         try
	         {
	             resultSet.close();
	             statement.close();
	             connection.close();
	         }
	         catch(Exception e)
	         {
	             e.printStackTrace();
	         }
	    }
			return null;

	     
	 }
		
		
		
	public ArrayList<Attraction> recommendation(String tag1, String tag2) {
			
			try
	    {
	        
	        //connect to the database
	        connection = DriverManager.getConnection(DATABASE_URL, 
	                "zhangm3210", "1767795");
	        connection.setAutoCommit(false);
	        //crate the statement
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("Select * from attractions " + " where (tag = '" + tag1 + "' or tag = '" + tag2 + "') and status = 'Success' order by score desc");
	        ArrayList<Attraction> recommendationResult = new ArrayList<Attraction>();
		
				while(resultSet.next()) {
		        	int i = 1;
		        	
		        	if(i>2) {
		        		
		        		break;
		        	}
					Attraction record = new Attraction(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getDouble(6));
					recommendationResult.add(record);
		        	i++;

				}
				return recommendationResult;
        
	       //connection.commit();
	        //connection.setAutoCommit(true);
	        
	    } 
	    catch (SQLException e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	    finally
	    {
	         //close the database
	         try
	         {
	             resultSet.close();
	             statement.close();
	             connection.close();
	         }
	         catch(Exception e)
	         {
	             e.printStackTrace();
	         }
	    }
	     
	 }
	
	public ArrayList<Attraction> viewFavor(String userid) {
		
		try
    {
        
        //connect to the database
        connection = DriverManager.getConnection(DATABASE_URL, 
                "zhangm3210", "1767795");
        connection.setAutoCommit(false);
        //crate the statement
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * from favor, attractions " + " where favor.title = attractions.title and userID = '" + userid + "'");
        ArrayList<Attraction> searchResult = new ArrayList<Attraction>();
        
        
			
			while(resultSet.next()) {
	        	
				Attraction record2 = new Attraction(resultSet.getString(1),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getDouble(8));
	        	searchResult.add(record2);

			}
			return searchResult;
        
        //connection.commit();
        //connection.setAutoCommit(true);
        
    } 
    catch (SQLException e)
    {
        e.printStackTrace();
        return null;
    }
    finally
    {
         //close the database
         try
         {
             resultSet.close();
             statement.close();
             connection.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }

     
 }
	public void addFavor(String title, String userid) {
		
		try
    {
        
        //connect to the database
        connection = DriverManager.getConnection(DATABASE_URL, 
                "zhangm3210", "1767795");
        connection.setAutoCommit(false);
        //crate the statement
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * from attractions " + " where title = '" + title + "' and status = 'Success'");
        if(resultSet.next()) {
        	int r = statement.executeUpdate("insert into favor values"
                    + "('" + title + "', '"+ userid + "')");
			System.out.println("Success!");
			System.out.println();
        }
        else 
        {
        	System.out.println("No such attraction exists!");
        	System.out.println();
        }
        
        connection.commit();
        connection.setAutoCommit(true);
        
    } 
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    finally
    {
         //close the database
         try
         {
             resultSet.close();
             statement.close();
             connection.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
     
 }
	
	public void askQuestion(String title, String question, String userid, String datetime, String status)
	 {       
       try
       {
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, 
                    "zhangm3210", "1767795");       
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * "
                    + "from nextquestionnumber");
            
            int nextNum = 0;  
            String questionNum = "";
            while(resultSet.next())
            {
                questionNum = "" + resultSet.getInt(1);
                nextNum = resultSet.getInt(1) + 1; 
            }
            
            //rolled back to here if anything wrong
            connection.setAutoCommit(false);

            int t = statement.executeUpdate("Update nextquestionnumber set "
                    + "nextID = '" + nextNum + "'");


            int r = statement.executeUpdate("insert into question values "
                    + "('" + questionNum + "', '" + title + "', '" 
                    + question + "', '" + userid + "', '" + datetime + "', '" + status + "')");
            
            connection.commit();
            connection.setAutoCommit(true);
            
             //display msg
           System.out.println("Question created successfully!");
           System.out.println();
            
        }
        catch(SQLException e)
        {
            //handle the exceptions
            System.out.println("Question creation failed");
            e.printStackTrace();
        }
        finally
        {
            //close the database
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
       
	 }
       
       public ArrayList<QuestionandAnswer> getQuestion(String title){
   		
   		try
       {
           
           //connect to the database
           connection = DriverManager.getConnection(DATABASE_URL, 
                   "zhangm3210", "1767795");
           connection.setAutoCommit(false);
           //crate the statement
           statement = connection.createStatement();
           resultSet = statement.executeQuery("Select * from question " + " where title = '" + title + "'");
           ArrayList<QuestionandAnswer> questions = new ArrayList<QuestionandAnswer>();
   			
   			while(resultSet.next()) {
   	        	
   				QuestionandAnswer record = new QuestionandAnswer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
   				questions.add(record);

   			}
   			
   			return questions;
           
           //connection.commit();
           //connection.setAutoCommit(true);
           
       } 
       catch (SQLException e)
       {
           e.printStackTrace();
           return null;
       }
       finally
       {
            //close the database
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
       }

        
    }
       
       public String getQuestion(String questionID, String title){
      		//leave for get question in notification
      		try
          {
              
              //connect to the database
              connection = DriverManager.getConnection(DATABASE_URL, 
                      "zhangm3210", "1767795");
              connection.setAutoCommit(false);
              //crate the statement
              statement = connection.createStatement();
              resultSet = statement.executeQuery("Select * from question " + " where questionID = '" + questionID + "'");
              //String question = resultSet.getString(3);
              //System.out.println(question);
              
              if(resultSet.next()) {
                  return resultSet.getString(3);
              }
              return null;    
              //connection.commit();
              //connection.setAutoCommit(true);
              
          } 
          catch (SQLException e)
          {
              e.printStackTrace();
              return null;
          }
          finally
          {
               //close the database
               try
               {
                   resultSet.close();
                   statement.close();
                   connection.close();
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
          }

           
       }
       
       
       
       public void answerQuestion(String questionID, String title, String answer, String userid, String datetime, String status)
  	 {       
         try
         {
              //connect to the database
              connection = DriverManager.getConnection(DATABASE_URL, 
                      "zhangm3210", "1767795");       
              statement = connection.createStatement();
              
              //rolled back to here if anything wrong
              connection.setAutoCommit(false);
              
              resultSet = statement.executeQuery("select * from answer where userID = '" +userid+"' and questionID = '" +questionID+"'");
              
              if(resultSet.next()) {
            	  System.out.println("Answer creation failed since you have answered this question!");
                  System.out.println();
                   
              }
              else {
            	  int t = statement.executeUpdate("Update question set "
                          + "status = 'Answered' where questionID = '" + questionID + "'");

                  int r = statement.executeUpdate("insert into answer values "
                          + "('" + questionID + "', '" + title + "', '" 
                          + answer + "', '" + userid + "', '" + datetime + "', '" + status + "')");
                  
                  connection.commit();
                  connection.setAutoCommit(true);
                  
                   //display msg
                 System.out.println("Answer created successfully!");
                 System.out.println();

              }
              
                            
          }
          catch(SQLException e)
          {
              //handle the exceptions
              System.out.println("Answer creation failed");
              e.printStackTrace();
          }
          finally
          {
              //close the database
              try
              {
                  //resultSet.close();
                  statement.close();
                  connection.close();
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
         
  	 }
       
       
       public ArrayList<QuestionandAnswer> getAnswer(String userid){
      		
      		try
          {
              
              //connect to the database
              connection = DriverManager.getConnection(DATABASE_URL, 
                      "zhangm3210", "1767795");
              connection.setAutoCommit(false);
              //crate the statement
              statement = connection.createStatement();//q.questionID, q.title, a.answer, a.userID, a.datetime, a.status
              resultSet = statement.executeQuery("select * from question, answer" + " where answer.questionID = question.questionID" + " and question.userID = '" + userid + "' and answer.status = 'Unread'");
            
              ArrayList<QuestionandAnswer> answers = new ArrayList<QuestionandAnswer>();
      			
      			while(resultSet.next()) {
      	        	

      				QuestionandAnswer record = new QuestionandAnswer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12));
      				answers.add(record);

      			}
      			
      			return answers;
              
              //connection.commit();
              //connection.setAutoCommit(true);
              
          } 
          catch (SQLException e)
          {
              e.printStackTrace();
              return null;
          }
          finally
          {
               //close the database
               try
               {
                   resultSet.close();
                   statement.close();
                   connection.close();
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
          }

           
       }
       
       
       
       public void readAnswer(String questionID, String userid)
  	 {
  	     
  		try
          {
              //connect to the database
              connection = DriverManager.getConnection(DATABASE_URL, 
                      "zhangm3210", "1767795");
              connection.setAutoCommit(false);
              //crate the statement
              statement = connection.createStatement();
              
              //do a query
              resultSet = statement.executeQuery("Select * from answer "
                      + "where questionID = '" + questionID + "' and userID = '" + userid + "' and status = 'Unread'");
              
              if(resultSet.next())
              {
                  int r = statement.executeUpdate("Update answer set status = 'Read' " + "where questionID = '" + questionID + "' and userID = '" + userid + "'");
                  System.out.println("Marked Answer readed successfully!");
              }
              else
              {
            	  System.out.println("Mark fail!");
              }
              connection.commit();
              connection.setAutoCommit(true);
              
          }
          catch (SQLException e)
          {
              e.printStackTrace();
          }
          finally
          {
               //close the database
               try
               {
                   resultSet.close();
                   statement.close();
                   connection.close();
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
          }
  	     
  	 }
       
       
       
       public void readAnswer(ArrayList<String> listid)
    	 {
    	     
    		try
            {
                //connect to the database
                connection = DriverManager.getConnection(DATABASE_URL, 
                        "zhangm3210", "1767795");
                connection.setAutoCommit(false);
                //crate the statement
                statement = connection.createStatement();
                
                //do a query
                
                for(int i = 0; i < listid.size(); i++) {
                	
                	String questionID = listid.get(i);
                	resultSet = statement.executeQuery("Select * from answer "
                            + "where questionID = '" + questionID + "' and status = 'Unread'");
                    
                    if(resultSet.next())
                    {
                        int r = statement.executeUpdate("Update answer set status = 'Read' " + "where questionID = '" + questionID + "'");
                        
                    }
                    else
                    {
                    	break;
                    }
                }
                System.out.println("Marked Answer readed successfully!");
                System.out.println();
              
                connection.commit();
                connection.setAutoCommit(true);
                
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                 //close the database
                 try
                 {
                     resultSet.close();
                     statement.close();
                     connection.close();
                 }
                 catch(Exception e)
                 {
                     e.printStackTrace();
                 }
            }
    	     
    	 }
       
       
}
	 

 


