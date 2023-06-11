package com.yash.dev.dao;

import com.yash.dev.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yashwanthanands
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entityManager
    private EntityManager entityManager;

    // inject entityManager field through constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityMgr){
        this.entityManager=entityMgr;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ",Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAllOrderByLastName() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);

        // return query results order by lastName ascending
        return theQuery.getResultList();
    }
}
