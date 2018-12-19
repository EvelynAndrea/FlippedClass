package online.templab.flippedclass.dto.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class SeminarShareMsgDTO {

    private String id;

    private String teacherId;

    private String principalCourseId;

    private String subordinateCourseId;

}
