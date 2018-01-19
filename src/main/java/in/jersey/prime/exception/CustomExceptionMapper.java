/**
 * 
 */
package in.jersey.prime.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import in.jersey.prime.model.ExceptionModel;

/**
 * @author Prasad Boini
 *
 */
public class CustomExceptionMapper implements ExceptionMapper<AppRuntimeException> {

	@Override
	public Response toResponse(final AppRuntimeException exception) {
		final ExceptionModel exceptionModel = new ExceptionModel(exception.getErrorMessage(), exception.getErrorCode());
		return Response.status(Status.BAD_REQUEST).entity(exceptionModel).build();
	}

}
