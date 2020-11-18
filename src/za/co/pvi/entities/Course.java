package za.co.pvi.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Course {

	private int id;
	private String courseName;
	private String duration;

	public Course() {
	}

	public Course(int id, String courseName, String duration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", duration=" + duration + "]";
	}

	Connection connection = null;
	Statement statement = null;
	String user = "root";
	String password = "pvi@2019";

	public void insertCourse(int id, String courseName, String duration) {
		System.out.println("Insert Started.....");
		
		String insert = "INSERT INTO COURSE (ID,COURSE_NAME,DURATION) VALUES(" + id + ",'" + courseName + "','"
				+ duration + "' )";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pvi_app_db?useSSL=false&requireSSL=true", user, password);

			statement = connection.createStatement();

			statement.execute(insert);

			System.out.println("Insert Complete.....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
