package online.templab.flippedclass.dao;


import online.templab.flippedclass.entity.Student;
import online.templab.flippedclass.entity.Teacher;
import online.templab.flippedclass.dto.TeacherFilterDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author andrea
 */
@Component
public interface AdminDao {
    /**
     * 管理员得到所有老师信息
     * @param filter
     * @return
     */
    List<Teacher> getTeachersByFilter(TeacherFilterDTO filter);

    /**
     * 通过账号获得老师信息
     * @param account
     * @return
     */

    Teacher getTeacherByTN(String account);

    /**
     * 通过id获得老师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherById(String teacherId);


    /**
     * 新增教师用户
     * @param teacher
     */
    void addTeacher(Teacher teacher);

    /**
     * 删除教师用户
     * @param teacherNum
     */

    void deleteTeacherByTN(String teacherNum);

    /**
     * 管理员得到所有学生信息
     * @param filter
     * @return
     */
    List<Student> getStudentsByFilter(StudentFilter filter);

    /**
     * 新增学生用户
     * @param student
     */
    void addStudent(Student student);


    /**
     * 删除学生用户
     * @param studentNum
     */

    void deleteStudentBySN(String studentNum);

}
