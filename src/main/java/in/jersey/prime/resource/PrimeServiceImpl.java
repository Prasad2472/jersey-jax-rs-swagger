/**
 * 
 */
package in.jersey.prime.resource;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import in.jersey.prime.exception.InvalidNumbersException;
import in.jersey.prime.exception.PossitiveNumberException;
import in.jersey.prime.model.PrimeResponse;

/**
 * @author Prasad Boini
 *
 */
public class PrimeServiceImpl implements PrimeService {
	private PrimeUtil primeNumberHelper = new PrimeUtil();

	@Override
	public Response findPrimeNumbers(final Integer start, final Integer end) {
		final PrimeResponse model = new PrimeResponse();
		if (start < 0 || end < 0) {
			throw new PossitiveNumberException("Please Provide Positive Numbers..!",
					Status.BAD_REQUEST.getStatusCode());
		}
		if (end < start) {
			throw new InvalidNumbersException("start:" + start + " end:" + end + " numbers are invalid..!",
					Status.BAD_REQUEST.getStatusCode());
		}

		final List<Integer> listOfPrimeNumbers = primeNumberHelper.getPrimeNumbers(start, end);
		model.setPrimeNumbers(listOfPrimeNumbers);
		model.setMsg(generateSuccessMessage(start, end, listOfPrimeNumbers.size(), ""));
		return Response.status(Status.OK).entity(model).build();
	}

	private String generateFailureMessage(final Integer start, final Integer end, final String page) {

		final StringBuilder builder = new StringBuilder();
		builder.append("The ");

		if ("page".equalsIgnoreCase(page)) {
			builder.append("page number");
			builder.append(start);
			builder.append(" or ");
			builder.append(" no of prime numbers on the page ");
			builder.append(end);

		} else {
			builder.append(" start ");
			builder.append(start);
			builder.append(" or ");
			builder.append(" end ");
			builder.append(end);
		}
		builder.append(" are invalid..!");
		return builder.toString();
	}

	private String generateSuccessMessage(final Integer start, final Integer end, final Integer size,
			final String page) {
		final StringBuilder builder = new StringBuilder();
		builder.append("The number of Prime numbers ");
		if ("page".equalsIgnoreCase(page)) {
			builder.append(" in the Page ");
			builder.append(start);
		} else {
			builder.append(" between ");
			builder.append(start);
			builder.append(" and ");
			builder.append(end);
		}
		builder.append(" are: ");
		builder.append(size);
		return builder.toString();
	}

	@Override
	public Response getPrimeNumbers(final Integer pageNumber, final Integer noOfElementsPerpage) {
		final PrimeResponse model = new PrimeResponse();
		if (pageNumber < 1 || noOfElementsPerpage < 1) {
			model.setMsg(generateFailureMessage(pageNumber, noOfElementsPerpage, "Page"));
			return Response.status(Status.BAD_REQUEST).entity(model).build();
		}
		final List<Integer> listOfPrimeNumbers = primeNumberHelper.getPrimeNumbersWithinPage(pageNumber,
				noOfElementsPerpage);
		model.setPrimeNumbers(listOfPrimeNumbers);
		model.setMsg(generateSuccessMessage(pageNumber, noOfElementsPerpage, listOfPrimeNumbers.size(), "Page"));
		return Response.status(Status.OK).entity(model).build();
	}
}
