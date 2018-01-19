/**
 * 
 */
package in.jersey.prime.exception;

/**
 * @author Prasad Boini
 *
 */

public class AppRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8486512699349306515L;
	private String errorMessage;
	private int errorCode;

	public AppRuntimeException(final String errorMessage, final int errorCode) {
		super();
		this.setErrorMessage(errorMessage);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
