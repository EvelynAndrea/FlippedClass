package online.templab.flippedclass.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import online.templab.flippedclass.FlippedClassApplicationTest;
import online.templab.flippedclass.entity.Attendance;
import org.apache.ibatis.session.RowBounds;
import java.util.ArrayList;
import java.util.List;

public class SeminarMapperTest extends FlippedClassApplicationTest {

    @Autowired
    SeminarMapper seminarMapper;

    @Test
    public void testSelectIdByCourseId()
    {
        long courseId=1;

        List<Long> idList=new ArrayList<>();
        idList = seminarMapper.selectIdByCourseId(courseId);
        Assert.assertNotNull(idList);



    }
}
