package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class AttendanceDTO {

    private String id;

    private Integer sn;

    private String preFile;

    private Boolean presenting;

    private String reportFile;

    private String teamId;

    private String klassSeminarId;

    private TeamDTO team;

}
