package com.yash.dev.dao;

import com.yash.dev.entity.Student;

/**
 * @author yashwanthanands
 */
public interface StudentDAO {

    public void save(Student theStudent);

    Student findById(Integer id);
}
