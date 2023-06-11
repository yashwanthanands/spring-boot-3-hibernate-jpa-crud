package com.yash.dev.dao;

import com.yash.dev.entity.Student;
import java.util.List;

/**
 * @author yashwanthanands
 */
public interface StudentDAO {

    public void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllOrderByLastName();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    int updateStudentsByLastName(String theLastName);

    void delete(Integer id);

    int deleteAll();

    int deleteStudentsByLastName(String theLastName);

}
