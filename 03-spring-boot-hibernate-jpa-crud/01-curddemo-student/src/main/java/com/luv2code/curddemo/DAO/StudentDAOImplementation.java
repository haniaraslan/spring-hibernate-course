package com.luv2code.curddemo.DAO;

import com.luv2code.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName DESC", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:data", Student.class);
        query.setParameter("data", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id){
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return rowsDeleted;
    }
}
