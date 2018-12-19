package online.templab.flippedclass.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.KlassDTO;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class KlassCreateDTO {
    private Integer gradeNum;
    private Integer klassNum;
    private String klassTime;
    private String location;
    private String courseId;

    public KlassDTO getKlass() {
        return new KlassDTO()
                .setGrade(gradeNum)
                .setSerial(klassNum)
                .setTime(klassTime)
                .setLocation(location)
                .setCourseId(courseId);
    }
}
