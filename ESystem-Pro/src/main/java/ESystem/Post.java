package ESystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")


public class Post {

	@Id //pk
	@Column(name="post")
	private String post;
	
	@Column(name = "courseID")
	private String courseID;
	
	@Column(name="datetime")
	private String datetime;

	
	public Post() {
		// TODO Auto-generated constructor stub
	}


	public Post(String courseID, String post, String datetime) {
		
		this.courseID = courseID;
		this.post = post;
		this.datetime = datetime;
	}


	public String getCourseID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	
}
