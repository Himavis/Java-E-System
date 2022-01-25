package ESystem;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="enrollment")

public class Enrollment {

	@Id
	@Column(name="autoID")
	private int autID;
	
	@Column(name = "id")
	private String id;

	@Column(name="courseID")
	private String courseID;
	
	@Column(name="instructor")
	private String instructor;

	
	



	public Enrollment() {
		
	}


	public Enrollment(String id, String courseID, String instructor) {
		
		this.id = id;
		this.courseID = courseID;
		this.instructor = instructor;
	}

	public int getAutID() {
		return autID;
	}


	public void setAutID(int autID) {
		this.autID = autID;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCourseID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	
}
