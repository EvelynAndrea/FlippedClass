package online.templab.flippedclass.mapper;

import online.templab.flippedclass.entity.Course;
import online.templab.flippedclass.entity.ShareSeminarApplication;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wk
 */
@Component
public interface ShareSeminarApplicationMapper extends Mapper<ShareSeminarApplication> {

}