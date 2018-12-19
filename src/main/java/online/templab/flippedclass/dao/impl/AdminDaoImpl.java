package online.templab.flippedclass.dao.impl;

import lombok.Data;
import online.templab.flippedclass.dao.AdminDao;
import online.templab.flippedclass.dto.StudentFilter;
import online.templab.flippedclass.dto.TeacherFilterDTO;
import online.templab.flippedclass.entity.Admin;
import online.templab.flippedclass.entity.Course;
import online.templab.flippedclass.entity.Student;
import online.templab.flippedclass.entity.Teacher;
import online.templab.flippedclass.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andrea
 */
@Component
@Data
public class AdminDaoImpl implements AdminDao {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    KlassMapper klassMapper;

    @Autowired
    SeminarMapper seminarMapper;

    @Autowired
    ShareSeminarApplicationMapper shareSeminarApplicationMapper;

    @Autowired
    ShareTeamApplicationMapper shareTeamApplicationMapper;


    @Override
    public List<Teacher> getTeachersByFilter(TeacherFilterDTO filter) {
        List<Teacher> teachers=teacherMapper.selectAll();
        List<Teacher> result=new ArrayList<>();
        if(teachers!=null&&teachers.size()>0)
        {
            int allCount=teachers.size();
            //getpage 为页面大小
            int pageCount=(allCount+filter.getPage()-1)/filter.getPage();

        }
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher getTeacherByTN(String account) {
        return null;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insertSelective(teacher);
    }

    @Override
    public void deleteTeacherByTN(String teacherNum) {
        Teacher teacherTemp=teacherMapper.selectByPrimaryKey(teacherNum);
        Long teacherId=teacherTemp.getId();
        // 级联删除共享讨论课（若存在）

        // 级联删除共享分组（若存在）


        // 级联删除课程 课程讨论课
        List<Course> courseList=courseMapper.selectByTeacherId(teacherId);
        if(courseList!=null)
        {
            Long courseId;
            for(int i=0;i<courseList.size();i++)
            {
                courseId=courseList.get(i).getId();
                List<Long> shareSeminarMainCourseList=courseMapper.isSeminarMainCourse(courseId);
                List<Long> shareTeamMainCourseList=courseMapper.isTeamMainCourse(courseId);
                if(shareSeminarMainCourseList!=null)
                {
                    for(Long l:shareSeminarMainCourseList)
                    {
                        seminarMapper.delete(seminarMapper.selectByCourseId(l));
                    }
                }
                if(shareTeamMainCourseList!=null)
                {

                }

                courseMapper.deleteByPrimaryKey(courseId);

            }
        }
        teacherMapper.deleteByPrimaryKey(teacherNum);
    }

    @Override
    public List<Student> getStudentsByFilter(StudentFilter filter) {
        return studentMapper.selectAll();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insertSelective(student);

    }

    @Override
    public void deleteStudentBySN(String studentNum) {
        studentMapper.deleteByPrimaryKey(studentNum);

    }
}
