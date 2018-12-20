package api;

import api.model.GetStrategyResponse;
import api.model.MarketExpectation;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Optional;

@Path("/strategies/get")
@Produces(MediaType.APPLICATION_JSON)
public class SOAResource {

  private String templateName;

  @Inject
  public SOAResource(@Named("templateName") String templateName) {
    this.templateName = templateName;
  }

  @GET
  @Timed
  public GetStrategyResponse getStrategies(
      @QueryParam("marketExpectation") Optional<String> marketExpectationString) {
    MarketExpectation marketExpectation =
        Arrays.stream(MarketExpectation.values())
            .filter(
                expectation -> expectation.toString().equals(marketExpectationString.orElse("")))
            .findFirst()
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        String.format(
                            "Market expectation %s is not valid",
                            marketExpectationString.orElse(""))));

    return new GetStrategyResponse(templateName + " world");
  }
}
