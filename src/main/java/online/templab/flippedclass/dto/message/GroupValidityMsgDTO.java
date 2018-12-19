package online.templab.flippedclass.dto.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class GroupValidityMsgDTO {

    private String id;

    private String content;

    private String teacherId;

    private String teamId;

}
