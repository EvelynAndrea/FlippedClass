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
        try {
            idList = seminarMapper.selectIdByCourseId(courseId);
        }catch (Exception e)
        {
            //TODO 异常执行块
            e.printStackTrace();
        }finally {
            if(idList!=null)
            {
                for(long l:idList)
                {
                    System.out.println(l);
                    Assert.assertNotNull(l);
                    logger.info(String.valueOf(l));
                }
            }
        }

    }
}
