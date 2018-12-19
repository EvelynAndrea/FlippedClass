package online.templab.flippedclass.pojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Cesare
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class TeacherNotFoundException {

}
