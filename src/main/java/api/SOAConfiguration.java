package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class SOAConfiguration extends Configuration {
  @JsonProperty private String yahooOptionUrlTemplate;

  public String getYahooOptionUrlTemplate() {
    return yahooOptionUrlTemplate;
  }
}
