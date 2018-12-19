package online.templab.flippedclass.mapper;

import online.templab.flippedclass.entity.Course;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wk
 */
@Component
public interface CourseMapper extends Mapper<Course> {

    /**
     * 根据 studentId 查找该 student 的所有 course
     *
     * @param studentId
     * @return
     */
    List<Course> selectByStudentId(Long studentId);

    /**
     *
     * @param teacherId
     * @return
     */
    List<Course> selectByTeacherId(Long teacherId);

    /**
     * 共享讨论课情况下判断课程是否为其他课程主课程
     * @param courseId
     * @return
     */
    List<Long> selectSeminarSubordinateCourseIdByCourseId(Long courseId);

    /**
     * 共享分组情况下是否为其他课程主课程
     * @param courseId
     * @return
     */
    List<Long> selectTeamSubordinateCourseIdByCourseId(Long courseId);
}