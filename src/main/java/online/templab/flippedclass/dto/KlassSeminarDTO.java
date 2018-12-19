package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class KlassSeminarDTO {

    private String id;

    private Integer state;

    private Date reportDeadline;

    private String klassId;

    private String seminarId;

    private List<AttendanceDTO> attendances;

    private SeminarDTO seminar;

}
