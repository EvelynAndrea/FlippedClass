package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class SeminarDTO {

    private String id;

    private String theme;

    private String content;

    private String serial;

    private Integer maxTeam;

    private Boolean visible;

    private String enrollStartDate;

    private String enrollEndDate;

    private String roundId;

    private String courseId;

}
