package online.templab.flippedclass.pojo.websocket;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.AttendanceDTO;
import online.templab.flippedclass.dto.QuestionDTO;
import online.templab.flippedclass.dto.TeacherDTO;
import online.templab.flippedclass.dto.TeamDTO;

import java.util.List;
import java.util.Map;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class SeminarController {

    String klassSeminarId;

    TeacherDTO teacher;

    List<AttendanceDTO> attendances;

    List<TeamDTO> teams;

    Map<QuestionDTO, TeamDTO> questionTeamMap;

}
