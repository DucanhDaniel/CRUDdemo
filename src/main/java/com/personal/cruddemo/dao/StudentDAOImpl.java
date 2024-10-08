package com.personal.cruddemo.dao;

import com.personal.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define field for entity manager
    private final EntityManager entityManager;
    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    // Implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // Return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=: theData", Student.class);

        // Set query parameters
        theQuery.setParameter("theData", lastName);

        // Return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int deleteByLastName(String lastName) {
        // Delete student base on condition
        Query query = entityManager.createQuery("DELETE FROM Student WHERE lastName =: theData");
        query.setParameter("theData", lastName);
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAllStudent() {
        // Delete student base on condition
        Query query = entityManager.createQuery("DELETE FROM Student");
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }


}
