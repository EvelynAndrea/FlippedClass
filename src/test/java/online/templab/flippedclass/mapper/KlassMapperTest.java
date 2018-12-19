package online.templab.flippedclass.mapper;

import online.templab.flippedclass.FlippedClassApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class KlassMapperTest extends FlippedClassApplicationTest {

    @Autowired
    KlassMapper klassMapper;

    @Test
    public void testSelectIdByCourseId()
    {
        long courseId=1;

        List<Long> idList=new ArrayList<>();

        try
        {
            idList=klassMapper.selecIdtByCourseId(courseId);
        }catch(Exception e){
            //TODO 异常执行操作
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
