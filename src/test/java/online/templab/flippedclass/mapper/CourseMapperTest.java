package online.templab.flippedclass.mapper;

import online.templab.flippedclass.FlippedClassApplicationTest;
import online.templab.flippedclass.entity.Course;
import online.templab.flippedclass.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CourseMapperTest extends FlippedClassApplicationTest {

    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testSelectByStudentId()
    {
        long studentId=1;
        List<Course> courseList=new ArrayList<>();
        courseList=courseMapper.selectByStudentId(studentId);
        Assert.assertNotNull(courseList);
    }

    @Test
    public void testSelectByTeacherId()
    {
        long teacherId=1;
        List<Course> courseList=new ArrayList<>();
        courseList=courseMapper.selectByTeacherId(teacherId);
        Assert.assertNotNull(courseList);
    }

    @Test
    public void testSelectSeminarSubordinateCourseIdByCourseId()
    {
        long courseId=1;
        List<Long> idList=new ArrayList<>();
        idList=courseMapper.selectSeminarSubordinateCourseIdByCourseId(courseId);
        Assert.assertNotNull(idList);
    }

    @Test
    public void testSelectTeamSubordinateCourseIdByCourseId()
    {
        long courseId=1;
        List<Long> idList=new ArrayList<>();
        idList=courseMapper.selectTeamSubordinateCourseIdByCourseId(courseId);
        Assert.assertNotNull(idList);
    }
}
