package ESystem;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import ESystem.User;
import ESystem.Course;
import ESystem.Enrollment;
import ESystem.Post;


public class Hibernate {

	protected SessionFactory sessionFactory;

	
protected void setup() {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	
				try {
					sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();	
				}
				
				catch(Exception e) {
					
					e.printStackTrace();
					StandardServiceRegistryBuilder.destroy(registry);
					
				}
	
	}
	protected void exit() {
		
		sessionFactory.close();
	}
	
	protected User login(String id, String password) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
			User user = session.get(User.class,id);
			
			if(user != null) {
				
				if(user.getPassword().equals(password))
		        {
					session.getTransaction().commit();
	        		session.close();
		            return user;
		        }
				
				else {
					session.getTransaction().commit();
	        		session.close();
					return null;
				}
			}
			else {
				session.getTransaction().commit();
        		session.close();
				return user;
			}
        }
        

	protected ArrayList<Course> facultyCourse(String id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "From Course C where C.instructor = :instructor";
		Query query = session.createQuery(hql);
		query.setParameter("instructor", id);
		List results = query.list();//list of object of courses
		
		ArrayList<Course> courses = (ArrayList<Course>)results;
		
		session.getTransaction().commit();
		session.close();
		return courses;
	}
	
	
	protected void newPost(String courseID, String post, String datetime) {
		
		Post newPost = new Post(courseID,post,datetime);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(newPost);
		
		session.getTransaction().commit();
		session.close();	
	
}
	
	protected ArrayList<Post> viewPost(String courseID) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "From Post P where P.courseID = :courseID";
		Query query = session.createQuery(hql);
		query.setParameter("courseID", courseID);
		List results = query.list();//list of object of courses
		
		ArrayList<Post> posts = (ArrayList<Post>)results;
		
		session.getTransaction().commit();
		session.close();
		
		return posts;
	}
	
	protected ArrayList<Course> searchCourse(String major) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "From Course C where C.major = :major and C.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("major", major);
		query.setParameter("status", "open");
		List results = query.list();//list of object of courses
		
		ArrayList<Course> courses = (ArrayList<Course>)results;
		
		session.getTransaction().commit();
		session.close();
		return courses;
	}
	
	protected void registerCourse(String id, String courseID, String instructor) {
		
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Enrollment newEnrollment = new Enrollment(id, courseID, instructor);
		//newEnrollment.setAutID(0);
		Course currentCourse = new Course();
		
		String hql = "From Enrollment E where E.id = :id and E.courseID = :courseID";

		
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("courseID", courseID);
		List results = query.list();
		
		if(results.isEmpty()) {

				currentCourse = session.load(Course.class,courseID);
				int currentEnrolled = currentCourse.getEnrolled();
				int currentCapacity = currentCourse.getCapacity();
				int add1 =  currentEnrolled+1;
				//could extract update and save outside if
				//delete 1 if still works
				
				currentCourse.setEnrolled(add1);
				session.update(currentCourse);
				
				if(add1 == currentCapacity) {
					
					currentCourse.setStatus("close");
			
				}
				session.save(newEnrollment);
				System.out.println("The course is added to your schedule!");
			
		}
		else {
			
			System.out.println("Your have already registered this class!");
		}
				
		session.getTransaction().commit();
		session.close();
		
	}
	
	protected ArrayList<Enrollment> studentEnrollment(String id) {


		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "From Enrollment E where E.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List results = query.list();//list of object of courses
		
		ArrayList<Enrollment> enrollment = new ArrayList<Enrollment>();
		enrollment = (ArrayList<Enrollment>)results;
		
		
		session.getTransaction().commit();
		session.close();
		return enrollment;
	}
	
	protected ArrayList<Enrollment> facultyEnrollment(String instructor) {


		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "From Enrollment E where E.instructor = :instructor";
		Query query = session.createQuery(hql);
		query.setParameter("instructor", instructor);
		List results = query.list();//list of object of courses
		
		ArrayList<Enrollment> enrollment = new ArrayList<Enrollment>();
		enrollment = (ArrayList<Enrollment>)results;	
		
		session.getTransaction().commit();
		session.close();
		return enrollment;
	}
	
}

