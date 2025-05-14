package com.study.ssm.service.impl;

import com.study.ssm.bean.Student;
import com.study.ssm.dao.StudentDao;
import com.study.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudentById(String id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.selectAll();
    }


    @Override
    public boolean addStudent(Student student) {
        return studentDao.insert(student) > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.update(student) > 0;
    }

    @Override
    public boolean deleteStudentById(String id) {
        return studentDao.deleteById(id) > 0;
    }
}