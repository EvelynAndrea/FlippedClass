package online.templab.flippedclass.dto.regulation;

import java.util.LinkedList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.TeamDTO;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class RegulationCompositionDTO {

    private List<Regulation> regulations;

    public List<String> validate(TeamDTO team) {
        List<String> errorMessages = new LinkedList<>();
        regulations.forEach(regulation -> {
            if (!regulation.validate(team)) {
                errorMessages.add(regulation.getErrorMsg());
            }
        });
        return errorMessages;
    }

}
