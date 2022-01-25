package ESystem;
import javax.persistence.*;

@Entity
@Table(name="uhcluser")

public class User {

	@Id //pk
	@Column(name = "id")//if attribute has the same name with column name, we don't need column notation
	private String id;

	@Column(name="password")
	private String password;
	
	@Column(name="major")
	private String major;
	
	
	@Column(name="type")
	private String type;
	
	
	public User() {
		
	}

	public User(String id, String password, String major, String type) {
		
		this.id = id;
		this.password = password;
		this.major = major;
		this.type = type;
	}
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
