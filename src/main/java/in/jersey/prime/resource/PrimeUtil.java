/**
 * 
 */
package in.jersey.prime.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prasad Boini
 *
 */
public class PrimeUtil {

	private final List<Integer> primeNumbersList = new ArrayList<>();

	/**
	 * This method will return the List of prime numbers within start and end.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Integer> getPrimeNumbers(final Integer start, final Integer end) {
		primeNumbersList.clear();
		final int strt = start % 2 == 0 ? start + 1 : start;
		final int ends = end % 2 == 0 ? end - 1 : end;
		if (start <= 2) {
			primeNumbersList.add(2);
		}
		// System.out.println("start=" + start + ", strt=" + strt + ",end=" + end +
		// ",ends=" + ends);
		// Check For only Odd numbers
		for (int i = strt; i <= ends; i = i + 2) {
			// System.out.println("i-->" + i);
			if (isPrimeNumber(i)) {
				primeNumbersList.add(i);
			}
		}
		// System.out.println("primeNumbersList Size=" + primeNumbersList.size());
		return primeNumbersList;
	}

	/**
	 * This method return true if the given number is prime, otherwise return false.
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPrimeNumber(final Integer number) {
		if (number == 2 || number == 3) {
			return true;
		}
		// If the Even number
		if (number % 2 == 0 || number == 1) {
			return false;
		}
		boolean isPrime = true;
		for (int i = 3; i < number; i = i + 2) {
			// System.out.println("isPrimeNumber--i =" + i);
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	/**
	 * This method will return the Prime numbers within the specified page.
	 * 
	 * @param pageNumber
	 * @param noOfElementsPerpage
	 * @return
	 */
	public List<Integer> getPrimeNumbersWithinPage(final Integer pageNumber, final Integer noOfElementsPerpage) {
		List<Integer> page = null;
		int noOfSplits = primeNumbersList.size() / noOfElementsPerpage;
		if (primeNumbersList.size() % noOfElementsPerpage != 0) {
			noOfSplits++;
		}
		if (pageNumber <= noOfSplits) {
			final int endIndex = (pageNumber - 1) * noOfElementsPerpage + noOfElementsPerpage < primeNumbersList.size()
					? (pageNumber - 1) * noOfElementsPerpage + noOfElementsPerpage
					: primeNumbersList.size();

			page = primeNumbersList.subList((pageNumber - 1) * noOfElementsPerpage, endIndex);
		}
		if (page == null) {
			page = new ArrayList<>();
		}
		return page;
	}

	public static void main(final String[] args) {
		final PrimeUtil helper = new PrimeUtil();

		System.out.println(helper.getPrimeNumbers(2, 100));
		System.out.println("---------------");

		List<Integer> page = helper.getPrimeNumbersWithinPage(1, 6);

		System.out.println("page--->" + page);

		page = helper.getPrimeNumbersWithinPage(2, 6);

		System.out.println("page--->" + page);
		page = helper.getPrimeNumbersWithinPage(3, 6);

		System.out.println("page--->" + page);
		page = helper.getPrimeNumbersWithinPage(4, 6);

		System.out.println("page--->" + page);
		page = helper.getPrimeNumbersWithinPage(5, 2);
		System.out.println("page--->" + page);
	}
}
