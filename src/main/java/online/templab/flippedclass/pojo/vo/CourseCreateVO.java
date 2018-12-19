package online.templab.flippedclass.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import online.templab.flippedclass.dto.CourseDTO;
import online.templab.flippedclass.dto.regulation.MaxMinRegulationDTO;

import java.util.Date;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class CourseCreateVO {
    private String courseName;
    private String intro;
    private Integer prePer;
    private Integer quePer;
    private Integer repPer;
    private Date teamStartDate;
    private Date teamEndDate;

    private Integer teamMax;
    private Integer teamMin;

    public CourseDTO getCourse() {
        return new CourseDTO()
                .setCourseName(courseName)
                .setIntroduction(intro)
                .setPrePercentage(prePer)
                .setQuesPercentage(quePer)
                .setReportPercentage(repPer)
                .setTeamStartDate(teamStartDate)
                .setTeamEndDate(teamEndDate);
    }

    public MaxMinRegulationDTO getMaxMinReg() {
        return new MaxMinRegulationDTO()
                .setMax(teamMax)
                .setMin(teamMin);
    }

}
