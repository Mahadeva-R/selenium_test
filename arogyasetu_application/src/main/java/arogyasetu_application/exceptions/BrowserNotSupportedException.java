package arogyasetu_application.exceptions;

@SuppressWarnings("serial")
public class BrowserNotSupportedException extends Exception {

	String exception;
	
	public BrowserNotSupportedException(String exception)
	{
		this.exception = exception;
	}

	public String getExcexptionMsg() {
		return exception;
	}
}
