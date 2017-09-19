package io.ninja.jrochette.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import io.ninja.jrochette.core.NinjaFinderService;
import io.ninja.jrochette.resources.models.RequestModel;
import io.ninja.jrochette.resources.models.ResponseModel;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class NinjaFinderResource {
	private final NinjaFinderService ninjaFinderService;

	public NinjaFinderResource() {
		ninjaFinderService = new NinjaFinderService();
	}

	@GET
	@Timed
	public ResponseModel<String> sayHello(@QueryParam("name") Optional<String> name) {
		return new ResponseModel<String>().withValue("Hello there! Welcome to the wizardly ninja finder!");
	}

	@POST
	@Timed
	@Path("uniqueValues")
	public ResponseModel<Boolean> isContainingUniqueValuesOnly(int[] integers) {
		return new ResponseModel<Boolean>().withValue(ninjaFinderService.isContainingOnlyUniqueValues(integers));
	}

	@POST
	@Timed
	@Path("permutations")
	public ResponseModel<List<String>> getPermutations(RequestModel<String> request) {
		return new ResponseModel<List<String>>().withValue(ninjaFinderService.getPermutations(request.getInput()));
	}

	@POST
	@Timed
	@Path("reverse")
	public ResponseModel<String> reverseInput(RequestModel<String> request) {
		return new ResponseModel<String>().withValue(ninjaFinderService.reverse(request.getInput()));
	}

	@GET
	@Timed
	@Path("primePalindrome")
	public ResponseModel<Integer> getPrimePalindrome(
			@QueryParam("lowerBound") int lowerBound, @QueryParam("upperBound") int upperBound) {
		return new ResponseModel<Integer>()
				.withValue(ninjaFinderService.findBiggestPrimePalindromeInRange(lowerBound, upperBound));
	}
}
