package online.templab.flippedclass.dto;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class TeacherDTO {

    private String id;

    private String teacherName;

    private String teacherNum;

    private String password;

    private String email;

    private Boolean activated;

    private List<CourseDTO> courses;

}
