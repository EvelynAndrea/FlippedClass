package online.templab.flippedclass.dto.relation;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class KlassStudentDTO {

    private String courseId;

    private String klassId;

    private String teamId;

    private String studentId;
}
