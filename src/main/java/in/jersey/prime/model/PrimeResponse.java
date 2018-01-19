/**
 * 
 */
package in.jersey.prime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prasad Boini
 *
 */
public class PrimeResponse {

	private String msg;
	private List<Integer> primeNumbers;

	public String getMsg() {
		return msg == null ? "" : msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public List<Integer> getPrimeNumbers() {
		return primeNumbers == null ? new ArrayList<Integer>() : primeNumbers;
	}

	public void setPrimeNumbers(final List<Integer> primeNumbers) {
		this.primeNumbers = primeNumbers;
	}

}
