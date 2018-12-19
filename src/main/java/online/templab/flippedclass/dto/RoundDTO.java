package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.relation.KlassRoundDTO;

import java.util.List;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class RoundDTO {

    private String id;

    private String roundNum;

    private Integer preScoreType;

    private Integer reportScoreType;

    private Integer quesScoreType;

    private String courseId;

    private List<SeminarDTO> seminars;

    private List<KlassRoundDTO> klassRounds;

}
