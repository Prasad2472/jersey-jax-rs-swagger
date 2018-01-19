/**
 * 
 */
package in.jersey.prime.exception;

/**
 * @author Prasad Boini
 *
 */
public class InvalidNumbersException extends AppRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9088950378318460046L;

	public InvalidNumbersException(final String errorMessage, final int errorCode) {
		super(errorMessage, errorCode);
	}
}
