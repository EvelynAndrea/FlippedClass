package online.templab.flippedclass.dao;

import com.github.pagehelper.Page;
import online.templab.flippedclass.entity.Student;
import online.templab.flippedclass.mapper.StudentMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fj
 * @author zyx
 */
@Component
public interface StudentDao {

    /**
     * 插入一个 Student
     *
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 删除某个 account 对应的学生
     *
     * @param account
     * @return
     */
    int deleteByAccount(String account);

    /**
     * 根据 primary key 更新学生（非空属性才更新）
     *
     * @param student
     * @return
     */
    int updateByPrimaryKeySelective(Student student);



    /**
     * 根据 primary key 查询学生
     *
     * @param key
     * @return
     */
    Student selectByPrimaryKey(Object key);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param record
     * @return
     */

    List<Student> select(Student record);

    /**
     * 根据 account 更新学生（非空属性才更新）
     *
     * @param student
     * @return
     */

    int updateByAccountSelective(Student student);

    /**
     * 获得一个分页: 传入 rowBounds(pageNum,limit) ,返回一个 List<Student>
     *
     * @param rowBounds
     * @return
     */
    Page<Student> getPage(RowBounds rowBounds);

}
