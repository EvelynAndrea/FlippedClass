package online.templab.flippedclass.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.RoundDTO;
import online.templab.flippedclass.dto.relation.KlassRoundDTO;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class RoundSettingDTO {
    private String roundId;
    private Integer preScoreType;
    private Integer quesScoreType;
    private Integer reportScoreType;
    private String[] klassId;
    private Integer[] enrollLimit;

    public RoundDTO getRound() {
        return new RoundDTO()
                .setId(roundId)
                .setPreScoreType(preScoreType)
                .setQuesScoreType(quesScoreType)
                .setReportScoreType(reportScoreType);
    }

    public List<KlassRoundDTO> getKlassRounds() {
        if (klassId.length != enrollLimit.length) {
            return null;
        }
        List<KlassRoundDTO> klassRounds = new LinkedList<>();
        for (int i = 0; i < klassId.length; i++) {
            KlassRoundDTO klassRound = new KlassRoundDTO()
                    .setEnrollLimit(enrollLimit[i])
                    .setKlassId(klassId[i])
                    .setRoundId(roundId);
            klassRounds.add(klassRound);
        }
        return klassRounds;
    }

}
