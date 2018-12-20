package online.templab.flippedclass.mapper;

import online.templab.flippedclass.FlippedClassApplicationTest;
import online.templab.flippedclass.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherMapperTest extends FlippedClassApplicationTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void testUpdateByAccountSelective() {
        int line = teacherMapper.updateByAccountSelective(
                new Teacher()
                        .setAccount("test72")
                        .setEmail("testemail@163.com")
                        .setActive(true)
        );
        Assert.assertEquals(1, line);
    }

    @Test
    public void testSelectByAccount(){
        Teacher test=new Teacher();
        test=teacherMapper.selectByAccount("");//TODO
        int flag=0;
        if(test.getTeacherName().equals(""))flag=1;//TODO
        Assert.assertEquals("Select Teacher By Account Failed\n",1, flag);
    }

}
