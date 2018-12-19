package online.templab.flippedclass.dao.impl;

import com.github.pagehelper.Page;
import online.templab.flippedclass.dao.TeacherDao;
import online.templab.flippedclass.entity.Course;
import online.templab.flippedclass.entity.Seminar;
import online.templab.flippedclass.entity.Teacher;
import online.templab.flippedclass.mapper.*;
import online.templab.flippedclass.pojo.dto.TeacherFilter;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wk
 */
@Component
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private KlassMapper klassMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Teacher> selectAll(TeacherFilter filter) {
        return null;
    }

    @Override
    public int updateByAccountSelective(Teacher record) {
        return teacherMapper.updateByAccountSelective(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public int deleteByAccount(String account) {
        Long teacherId=teacherMapper.selectByAccount(account).getId();
        List<Course> courseList=courseMapper.selectByTeacherId(teacherId);

        if(courseList!=null)
        {
            Long courseId;
            for(int i=0;i<courseList.size();i++)
            {
                courseId=courseList.get(i).getId();

                // 级联删除共享小组共享讨论课
                List<Long> shareSeminarSubordinateCourseList=courseMapper.selectSeminarSubordinateCourseIdByCourseId(courseId);
                List<Long> shareTeamSubordinateCourseList=courseMapper.selectTeamSubordinateCourseIdByCourseId(courseId);

                if(shareSeminarSubordinateCourseList!=null)
                {
                    for(Long l:shareSeminarSubordinateCourseList)
                    {
                        seminarMapper.deleteByPrimaryKey(l);
                    }
                }

                if(shareTeamSubordinateCourseList!=null)
                {
                    for(Long l:shareTeamSubordinateCourseList)
                    {
                        teamMapper.deleteByPrimaryKey(l);
                    }
                }


                // 级联删除班级与讨论课
                List<Long> seminarIdList=seminarMapper.selectIdByCourseId(courseId);
                List<Long> klassIdList=klassMapper.selecIdtByCourseId(courseId);

                if(seminarIdList!=null)
                {
                    for(Long l:seminarIdList)
                    {
                        seminarMapper.deleteByPrimaryKey(l);
                    }
                }


                if (klassIdList!=null)
                {
                    for(Long l:klassIdList)
                    {
                        klassMapper.deleteByPrimaryKey(l);
                    }
                }

                courseMapper.deleteByPrimaryKey(courseId);


            }
        }
        return teacherMapper.delete(new Teacher().setAccount(account));
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Object key) {
        return teacherMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Teacher> select(Teacher record) {
        return teacherMapper.select(record);
    }

    @Override
    public Page<Teacher> selectByRowBounds(Teacher record, RowBounds rowBounds) {
        return (Page<Teacher>) teacherMapper.selectByRowBounds(record, rowBounds);
    }
}
