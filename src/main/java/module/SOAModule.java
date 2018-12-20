package module;

import api.SOAResource;
import com.google.inject.AbstractModule;

public class SOAModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(SOAResource.class);
  }
}
