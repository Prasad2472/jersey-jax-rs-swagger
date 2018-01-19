package in.jersey.prime.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Api(value = "/myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
//	@ApiOperation(value = "Its a Get It", response = String.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	public String getIt() {
		return "Got it!";
	}
}
