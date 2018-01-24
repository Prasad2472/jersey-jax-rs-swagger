/**
 * 
 */
package in.jersey.prime.resource.security;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

/**
 * @author Prasad Boini
 *
 */
@Component
@Path("/accessDenied")
public class AccesDeniedResource {
	@Produces(MediaType.TEXT_PLAIN)
	public Response accessDenied() {
		System.out.println("Access Denied..");
		return Response.status(Status.UNAUTHORIZED).entity("You cannot Access the resource").build();
	}

}
