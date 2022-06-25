package tr.com.atez.crud.constants;

public abstract class AppConstants {
	public static final String API = "/api";
	public static final String VERSION = "/v1";

	public abstract class Domain{
		public static final String TDS = "/tds";

		public abstract class Controller{
			public static final String COUNTRY_CONTROLLER = API + VERSION + TDS + "/countries";

		}
	}
}
