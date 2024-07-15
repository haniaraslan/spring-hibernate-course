package com.luv2code.curddemo.DAO;

import com.luv2code.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImplementation implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager with constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement the save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findStudentById(int id){
        return entityManager.find(Student.class, id);
    }
}
