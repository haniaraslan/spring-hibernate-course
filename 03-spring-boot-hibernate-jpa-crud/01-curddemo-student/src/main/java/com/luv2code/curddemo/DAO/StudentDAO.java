package com.luv2code.curddemo.DAO;
import java.util.List;
import com.luv2code.curddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}
