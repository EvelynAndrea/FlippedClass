package online.templab.flippedclass.pojo.websocket;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wk
 */

@Data
@Accessors(chain = true)
public class ResponseMessage {
    private String user;
    private String message;

    public ResponseMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }

}
