package com.yash.dev.dao;

import com.yash.dev.entity.Student;
import jakarta.persistence.EntityManager;
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
}
