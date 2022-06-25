package tr.com.atez.crud.exception;

public enum ExceptionDef {

	// @formatter:off
    DECLARATION_NOT_FOUND("DEC001","Declaration not found"),



    GUARANTEE_NOT_FOUND("G150", "Guarantee not found"),
    GUARANTEE_PERMISSION_NOT_FOUND("GP150", "Guarantee permission not found"),
    GUARANTEE_INVALID_PERMISSON("GP300", "Guarantee permissions is invalid"),
    GLOBAL_RULE_DUPLICATE_GTIP("R300", "Duplicate global rule for gtip: %s"),
    GLOBAL_RULE_DUPLICATE_COUNTRY("R301", "Duplicate global rule for country: %s"),

    GLOBAL_ID_EXISTS("G120","A new %s cannot already have an ID: %s"),
    GLOBAL_ID_NOT_EXISTS("G121","Entity not found with this Id: %s "),
    GLOBAL_INVALID_ID("G122","Param id : %s, dto id: %s not matched"),
    GLOBAL_ID_NOT_NULL("G123","Id can not be null: %s "),

    GUARANTEE_PERMISSION_GTIP_COUNTRY_CONFLICT("GP301", "Guarantee permission must be either gtip based or country based, gtip: %s, country: %s"),
    GUARANTEE_PERMISSION_IGNORE_CONFLICT("GP302", "Ignored guarantee permission must have id field"),
    GUARANTEE_COMPANY_NOT_FOUND("G100", "Guarantee company not found"),
    GUARANTEE_COMPANY_NOT_ASSIGNED("GC100", "Guarantee not assigned to company"),
    USER_COMPANY_NOT_FOUND("U100", "User company not found"),
    UNAUTHORIZED_USER_OPERATION("U101", "Unauthorized user operation"),
    DUPLICATE_GUARANTEE_FOR_COMPANY("G200", "Duplicate guaranteename for company"),
    COMPANY_BRANCH_NOT_FOUND("CB150", "Company branch  not found"),
    GTB_SERVICE_ERROR("GTB100", "Gtb service error, code: %s, message: %s");



    // @formatter:on
	private String code;

	private String message;

	ExceptionDef(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
