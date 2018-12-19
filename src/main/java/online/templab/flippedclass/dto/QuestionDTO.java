package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class QuestionDTO {

    private String id;

    private Integer score;

    private String teamId;

    private String studentId;

    private String attendanceId;

    private String klassSeminarId;
}

