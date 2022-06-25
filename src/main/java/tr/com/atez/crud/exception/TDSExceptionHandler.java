package tr.com.atez.crud.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class TDSExceptionHandler {

	@ExceptionHandler({ TDSException.class })
	public ResponseEntity<ExceptionResponse> onAtezException(TDSException exception, WebRequest request) {
		ExceptionResponse exceptionResponse = ExceptionResponse.builder().code(exception.getCode())
				.message(exception.getMessage()).detail(exception.getDetail()).build();

		logException(request, exceptionResponse, exception);
		return ResponseEntity.status(500).body(exceptionResponse);
	}

	@ExceptionHandler({ Exception.class })
	ResponseEntity<ExceptionResponse> onGenericException(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = ExceptionResponse.builder().code("9000")
				.message(ExceptionUtils.getRootCauseMessage(exception)).build();

		logException(request, exceptionResponse, exception);
		return ResponseEntity.status(500).body(exceptionResponse);
	}

	private void logException(WebRequest request, ExceptionResponse exceptionResponse, Exception e) {
		log.error("api exceptionResponse: {}", exceptionResponse, e);
		/* this attribute used by WebRequestLogInterceptor */
		// request.setAttribute(ApplicationConst.EXCEPTION_RESPONSE, exceptionResponse,
		// RequestAttributes.SCOPE_REQUEST);
	}

}
