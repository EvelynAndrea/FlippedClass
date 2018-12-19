package online.templab.flippedclass.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class StudentFilter {

    private boolean newFilter = false;

    private int page = 0;

    private int count = 0;

    private String name = null;

    private String studentNum = null;

}
