package tr.com.atez.crud.exception;

import lombok.Getter;

@Getter
public class TDSException extends RuntimeException {

	private String code;

	private Object detail;

	public TDSException(String code, String message) {
		super(message);
		this.code = code;
	}

	public TDSException(ExceptionDef ed) {
		super(ed.getMessage());
		this.code = ed.getCode();
	}

	public TDSException(ExceptionDef ed, Object... args) {
		super(String.format(ed.getMessage(), args));
		this.code = ed.getCode();
	}

	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "TDSException{" + "code=" + code + ", message='" + getMessage() + '\'' + '}';
	}

}
