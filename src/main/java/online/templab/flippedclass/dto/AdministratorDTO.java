package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class AdministratorDTO {

    private String id;

    private String adminName;

    private String password;

}
