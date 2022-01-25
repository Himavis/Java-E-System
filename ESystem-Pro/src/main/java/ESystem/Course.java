package ESystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")

public class Course {
	
	@Id //pk
	@Column(name = "courseID")//if attribute has the same name with column name, we don't need column notation
	private String courseID;

	@Column(name="major")
	private String major;
	
	@Column(name="instructor")
	private String instructor;
	
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="enrolled")
	private int enrolled;
	
	@Column(name="status")
	private String status;
	
	
	public Course() {
		;
	}


	public Course(String courseID, String major, String instructor, int capacity, int enrolled, String status) {
		
		this.courseID = courseID;
		this.major = major;
		this.instructor = instructor;
		this.capacity = capacity;
		this.enrolled = enrolled;
		this.status = status;
	}


	public String getCourseID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int getEnrolled() {
		return enrolled;
	}


	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
