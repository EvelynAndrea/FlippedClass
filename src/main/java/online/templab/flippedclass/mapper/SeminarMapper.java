package online.templab.flippedclass.mapper;

import online.templab.flippedclass.entity.Seminar;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @author wk
 */
@Component
public interface SeminarMapper extends Mapper<Seminar> {

    /**
     * 通过课程id获得讨论课id
     * @param courseId
     * @return
     */
    List<Long> selectIdByCourseId(Long courseId);
}