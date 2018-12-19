package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class StudentDTO {

    private String id;

    private String studentName;

    private String studentNum;

    private String password;

    private String email;

    private Boolean activated;

}
