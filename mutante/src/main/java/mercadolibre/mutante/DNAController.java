package mercadolibre.mutante;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import mercadolibre.mutante.checker.IMutantChecker;

public class DNAController {

	@Autowired
	@Qualifier("arrayMutantChecker")
	private IMutantChecker checker;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/mutant")
	public Response isMutant(Input input) {

		Response response = null;
		try {
			if (checker.isMutant(input.getData())) {
				response = Response.ok().build();
			} else {
				response = Response.status(Response.Status.FORBIDDEN).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

		return response;

	}

}
