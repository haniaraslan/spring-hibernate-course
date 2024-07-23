package com.luv2code.curddemo;
import java.util.List;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.luv2code.curddemo.DAO.StudentDAO;
import com.luv2code.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	//inject the DAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
		//	createStudent(studentDAO);
			CreateMultipleStudents(studentDAO);
		//	ReadStudent(studentDAO);
		//	GetAllStudents(studentDAO);
		//	GetAllStudentsByLastName(studentDAO);
		//	UpdateStudent(studentDAO);
		//	DeleteStudent(studentDAO);
		//	DeleteAllStudents(studentDAO);
		};
	}

	private void DeleteAllStudents(StudentDAO studentDAO) {
		int deletedRows = studentDAO.deleteAll();

		System.out.println("number of rows deleted : " + deletedRows);
	}

	private void DeleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		studentDAO.delete(studentId);
	}

	private void UpdateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findStudentById(studentId);
		student.setLastName("alashkar");
		studentDAO.update(student);
	}

	private void GetAllStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Raslan");
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void GetAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void ReadStudent(StudentDAO studentDAO) {
		System.out.println("Read Student by Id started...");

		Student student = studentDAO.findStudentById(2);

		System.out.println("found student: " + student);
	}

	private void CreateMultipleStudents(StudentDAO studentDAO){
		// create multiple students
		System.out.println("create multiple students started...");

		for (int i = 0; i < 3 ; i++) {
			Student newStudent = new Student("paul", "doe", "paul_doe@gmail.com");
			studentDAO.save(newStudent);
			System.out.println("saved student with id: " + newStudent.getId());
		}
	}
	//make use of the DAO
	private void createStudent(StudentDAO studentDAO){
		System.out.println("create student started...");
		Student newStudent = new Student("paul", "doe", "paul_doe@gmail.com");

		System.out.println("saving student...");
		studentDAO.save(newStudent);

		System.out.println("saved student with id: " + newStudent.getId());
	}

}
