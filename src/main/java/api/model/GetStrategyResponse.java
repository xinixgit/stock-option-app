package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStrategyResponse {
  @JsonProperty public String templateName;

  public GetStrategyResponse(String templateName) {
    this.templateName = templateName;
  }
}
