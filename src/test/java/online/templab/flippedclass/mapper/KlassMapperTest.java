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
        idList=klassMapper.selecIdtByCourseId(courseId);
        Assert.assertNotNull(idList);

    }
}
