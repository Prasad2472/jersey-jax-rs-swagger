/**
 * 
 */
package in.jersey.prime.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Prasad Boini
 *
 */
@Path("/prime")
@Api(value = "prime")
public interface PrimeService {
	@GET
	@Path("/findAllPrimeNumbers")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation(value = "This Will return prime numbers from given input value.", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "If the input is not in the range throws PossitiveNumberException"),
			@ApiResponse(code = 400, message = "throws InvalidNumbersException") })
	Response findPrimeNumbers(@QueryParam("start") Integer start, @QueryParam("end") Integer end);

	@GET
	@Path("/getPrimeNumbers")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.TEXT_PLAIN)
	Response getPrimeNumbers(@QueryParam("pageNumber") Integer pageNumber,
			@QueryParam("noOfElementsPerpage") Integer noOfElementsPerpage);

}
