package online.templab.flippedclass.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.regulation.RegulationCompositionDTO;

import java.util.Date;


/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class CourseDTO {

    private String id;

    private String courseName;

    private String introduction;

    private Integer prePercentage;

    private Integer reportPercentage;

    private Integer quesPercentage;

    private Date teamStartDate;

    private Date teamEndDate;

    private String teacherId;

    private String teamMainCourseId;

    private String seminarMainCourseId;

    private RegulationCompositionDTO regulationComposition;

}
