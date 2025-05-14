package com.study.ssm.dao;

import com.study.ssm.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {
    @Select("select * from student where id = #{id}")
    Student selectById(String id);

    @Select("select * from student")
    List<Student> selectAll();

    @Insert("insert into student (id,name,age,address)values (#{id},#{name},#{age},#{address})")
    int insert(Student student);

    @Update("update student set name=#{name},age=#{age},address=#{address} where id = #{id}")
    int update(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteById(String id);


}
