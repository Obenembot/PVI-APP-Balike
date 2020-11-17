package za.co.pvi.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import za.co.pvi.entities.Student;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Student student = null;

		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		String user = "root";
		String password = "pvi@2019";

		try {
			System.out.println("started..1");
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pvi_app_db?useSSL=false&requireSSL=true", user, password);

			statement = connection.createStatement();

			System.out.println("OPTIONS");
			System.out.println(
					"1. SAVE / ADD STUDENT \n2. UPDATE STUDENT \n3. Delete Student? Provide ID \n4. Show All Student");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				student = new Student(2, "Tabi", "Oben", "oben@gmail.com");
				student.addToDb(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());

				break;

			case 2:
				student = new Student(10, "Peter", "Paul", "peter@gmail.com");

				 student.updateStudent(student.getFirstName(), student.getLastName(),
				 student.getEmail(), student.getId());

				break;
			case 3:
				int id = 1;
				statement.execute("delete from STUDENT where ID ="+id);
				System.out.println("Delete complete...");
				break;

			case 4:
				String querry = "Select * from STUDENT";
				resultSet = statement.executeQuery(querry);

				while (resultSet.next()) {
					System.out.print(resultSet.getString("ID") + " ");
					System.out.println(resultSet.getString("FIRST_NAME"));

				}
				break;
			default:
				System.err.println("Option Not FOund!!!");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
