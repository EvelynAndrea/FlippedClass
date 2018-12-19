package online.templab.flippedclass.dto.relation;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class KlassRoundDTO {

    private String klassId;

    private String roundId;

    private Integer enrollLimit;
}
