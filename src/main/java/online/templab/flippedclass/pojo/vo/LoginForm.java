package online.templab.flippedclass.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author wk
 */
@Data
@Accessors(chain = true)
public class LoginForm {

    @NotNull
    private String username;

    @NotNull
    private String password;

}
