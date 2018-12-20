package online.templab.flippedclass.mapper;

import online.templab.flippedclass.FlippedClassApplicationTest;
import online.templab.flippedclass.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentMapperTest extends FlippedClassApplicationTest{

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testUpdateByAccountSelective() {
        int line = studentMapper.updateByAccountSelective(
                new Student()
                        .setAccount("")//TODO
                        .setEmail("")
                        .setActive(true)
        );
        Assert.assertEquals(1, line);
    }

}
