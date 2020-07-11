/**
 * FileName: StudentDao
 * Author:   嘉平十七
 * Date:     2020/7/10 15:53
 * Description: 操作student表的接口
 * notes：
 */
package com.dao.student;

import com.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询所有，一行数据对应一个对象
    public List<Student> selectStudents();
    public int insertSudent(Student student);
    public int deleteStudent(int id);
    public int updateStudent(@Param("stu") Student student,@Param("whereid") int whereid);
}
