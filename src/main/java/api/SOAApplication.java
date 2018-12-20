package api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import module.SOAModule;

public class SOAApplication extends Application<SOAConfiguration> {

  @Override
  public void run(SOAConfiguration configuration, Environment environment) throws Exception {
    Injector injector = Guice.createInjector(new SOAModule());
    environment.jersey().register(injector.getInstance(SOAResource.class));
  }

  @Override
  public String getName() {
    return "soa";
  }

  @Override
  public void initialize(Bootstrap<SOAConfiguration> bootstrap) {
    // nothing to do yet
  }

  public static void main(String[] args) throws Exception {
    new SOAApplication().run(args);
  }
}
