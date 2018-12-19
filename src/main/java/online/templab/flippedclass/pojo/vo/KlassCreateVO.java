package online.templab.flippedclass.pojo.vo;


import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.KlassDTO;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class KlassCreateVO {

    private String gradeNum;

    private String klassNum;

    private String klassTime;

    private String location;

    private String courseId;

    public KlassDTO getKlass() {
        return new KlassDTO()
                .setKlassName(gradeNum + "-" + klassNum)
                .setTime(klassTime)
                .setLocation(location)
                .setCourseId(courseId);
    }

}
