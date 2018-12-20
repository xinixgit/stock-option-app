package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import dataflow.GetStrategyRequestDataFlow;

public class DataFlowModule extends AbstractModule {
  @Override
  protected void configure() {}

  @Provides
  public GetStrategyRequestDataFlow getGetStrategyRequestDataFlow() {
    return new GetStrategyRequestDataFlow();
  }
}
