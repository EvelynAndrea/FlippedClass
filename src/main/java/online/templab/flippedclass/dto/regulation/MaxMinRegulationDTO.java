package online.templab.flippedclass.dto.regulation;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.TeamDTO;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class MaxMinRegulationDTO implements Regulation {

    private String id;

    private Integer min;

    private Integer max;

    private String courseId;

    @Override
    public boolean validate(TeamDTO team) {
        return true;
    }

    @Override
    public String getErrorMsg() {
        return "组队人数应在 " + min + "-" + max + " 之间";
    }

}
