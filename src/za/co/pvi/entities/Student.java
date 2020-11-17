package za.co.pvi.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String email;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	Connection connection = null;
	Statement statement = null;
	String user = "root";
	String password = "pvi@2019";
	
	public void addToDb(int id, String firstName, String lastName, String email) {
		
		System.out.println("Insert Started.....");

		String insert = "INSERT INTO STUDENT(ID,FIRST_NAME,EMAIL,LAST_NAME) VALUES(" + id + ",'" + firstName + "','"
				+ email + "','" + lastName +"')";

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
	
	public void updateStudent(String firstName, String lastName, String email, int id) {
		System.out.println("Update Started.....");

		String update = " UPDATE STUDENT SET FIRST_NAME ='" + firstName + "' , LAST_NAME='" + lastName + "' , EMAIL='"
				+ email + "' WHERE ID ="+id ;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pvi_app_db?useSSL=false&requireSSL=true", user, password);
			statement = connection.createStatement();

			statement.execute(update);

			System.out.println("Update Complete.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
