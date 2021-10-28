package com.fzn.dao;

import com.fzn.domain.Student;

/**
 * 学生Dao
 */
public interface StudentDao {

    //查询一个学生
    Student selectStudentById(Integer id);
}
