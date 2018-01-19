/**
 * 
 */
package in.jersey.prime.exception;

/**
 * @author Prasad Boini
 *
 */
public class PossitiveNumberException extends AppRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5463651339891202477L;

	public PossitiveNumberException(final String errorMessage, final int errorCode) {
		super(errorMessage, errorCode);
	}
}
