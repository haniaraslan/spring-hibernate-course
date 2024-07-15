package com.luv2code.curddemo.DAO;

import com.luv2code.curddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(int id);

}
