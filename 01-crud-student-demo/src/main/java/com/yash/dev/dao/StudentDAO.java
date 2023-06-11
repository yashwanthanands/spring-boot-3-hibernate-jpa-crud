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

}
