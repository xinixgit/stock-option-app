package module;

import api.SOAResource;
import com.google.inject.AbstractModule;

public class SOAModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new DataFlowModule());
    bind(SOAResource.class);
  }
}
