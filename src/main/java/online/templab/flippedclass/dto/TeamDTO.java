package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class TeamDTO {

    private String id;

    private String serial;

    private String teamName;

    private Integer status;

    private String courseId;

    private String klassId;

    private String leaderId;

    private StudentDTO leader;

    private List<StudentDTO> students;

}
