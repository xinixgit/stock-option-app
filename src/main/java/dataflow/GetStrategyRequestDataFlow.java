package dataflow;

import api.model.GetStrategyResponse;
import api.model.MarketExpectation;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Optional;

@Builder
public class GetStrategyRequestDataFlow {

  public GetStrategyResponse execute(Optional<String> marketExpectation) {
    GetStrategyRequestContext context = GetStrategyRequestContext.from(marketExpectation);
    return GetStrategyResponse.builder().templateName("hello").build();
  }

  @Data
  @Builder
  private static class GetStrategyRequestContext {
    private MarketExpectation marketExpectation;

    static GetStrategyRequestContext from(Optional<String> marketExpectation) {
      return GetStrategyRequestContext.builder()
          .marketExpectation(getMarketExpectation(marketExpectation))
          .build();
    }

    static MarketExpectation getMarketExpectation(Optional<String> marketExpectation) {
      String marketExpectationStr = marketExpectation.orElse("");
      return Arrays.stream(MarketExpectation.values())
          .filter(expectation -> expectation.toString().equals(marketExpectationStr))
          .findFirst()
          .orElseThrow(
              () ->
                  new IllegalArgumentException(
                      String.format("Market expectation %s is not valid", marketExpectationStr)));
    }
  }
}
