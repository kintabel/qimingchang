package com.study.ssm.service;

import com.study.ssm.bean.Student;
import java.util.List;

public interface StudentService {
    /**
     * 根据ID查询学生信息
     * @param id 学生ID
     * @return 学生对象
     */
    Student getStudentById(String id);

    /**
     * 查询所有学生信息
     * @return 学生列表
     */
    List<Student> getAllStudents();

    /**
     * 添加学生信息
     * @param student 学生对象
     * @return 是否添加成功
     */
    boolean addStudent(Student student);

    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 是否更新成功
     */
    boolean updateStudent(Student student);

    /**
     * 根据ID删除学生信息
     * @param id 学生ID
     * @return 是否删除成功
     */
    boolean deleteStudentById(String id);

}