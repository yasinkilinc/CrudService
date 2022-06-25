package tr.com.atez.crud.exception;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ExceptionResponse {

	String code;

	String message;

	Object detail;

}
