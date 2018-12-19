package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class KlassDTO {

    private String id;

    private int grade;

    private int serial;

    private String time;

    private String location;

    private String courseId;

}
