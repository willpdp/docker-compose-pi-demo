package style_service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StyleServiceApplication extends Application<StyleServiceConfiguration> {
    public static void main(String[] args) throws Exception {
	new StyleServiceApplication().run(args);
    }

    @Override
    public String getName() {
	return "style-service";
    }
    
    @Override
    public void initialize(Bootstrap<StyleServiceConfiguration> bootstrap) {
	// nothing to do yet
    }
    
    @Override
    public void run(StyleServiceConfiguration configuration,
		    Environment environment) {
	environment.jersey().register(new MainResource());
    }

}
