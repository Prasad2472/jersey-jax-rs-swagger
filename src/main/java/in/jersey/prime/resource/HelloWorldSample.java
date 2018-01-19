package in.jersey.prime.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import in.jersey.prime.model.Bean;

@Path("/hello")
public class HelloWorldSample {

	@GET
	@Path("/echo/{input}")
	@Produces("text/plain")
	public String ping(@PathParam("input") String input) {
		return input;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/jsonBean")
	public Response modifyJson(Bean input) {
		input.setVal2(input.getVal1());
		return Response.ok().entity(input).build();
	}

	@GET
	@Path("/welcome")
	@Produces("text/plain")
	public String sayHello() {
		return "Welcome ...!";
	}
}
