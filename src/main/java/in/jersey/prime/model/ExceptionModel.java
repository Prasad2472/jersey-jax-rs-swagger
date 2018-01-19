/**
 * 
 */
package in.jersey.prime.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Prasad Boini
 *
 */
@XmlRootElement
public class ExceptionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136796542887465456L;
	private String errorMessage;
	private int errorCode;

	public ExceptionModel() {

	}

	public ExceptionModel(String errorMessage, int errorCode) {
		super();
		this.setErrorMessage(errorMessage);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
