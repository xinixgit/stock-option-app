package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetStrategyResponse {

  @JsonProperty public String templateName;
}
