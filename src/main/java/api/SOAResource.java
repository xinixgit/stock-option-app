package api;

import api.model.GetStrategyResponse;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import dataflow.GetStrategyRequestDataFlow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/strategies/get")
@Produces(MediaType.APPLICATION_JSON)
public class SOAResource {

  private GetStrategyRequestDataFlow getStrategyRequestDataFlow;

  @Inject
  public SOAResource(GetStrategyRequestDataFlow getStrategyRequestDataFlow) {
    this.getStrategyRequestDataFlow = getStrategyRequestDataFlow;
  }

  @GET
  @Timed
  public GetStrategyResponse getStrategies(
      @QueryParam("marketExpectation") Optional<String> marketExpectationString) {
    return getStrategyRequestDataFlow.execute(marketExpectationString);
  }
}
