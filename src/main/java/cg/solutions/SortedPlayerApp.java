package cg.solutions;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SortedPlayerApp extends Application<SortedPlayerConfiguration> {
	
    public static void main(String[] args) throws Exception {
        new SortedPlayerApp().run(args);
    }
    
    @Override
    public void initialize(Bootstrap<SortedPlayerConfiguration> bootstrap) {
    	// TODO Auto-generated method stub
    	
    }

	@Override
	public void run(SortedPlayerConfiguration configuration, Environment environment) throws Exception {
	    final SortedPlayerResource resource = new SortedPlayerResource(configuration.getDefaultName());
	        environment.jersey().register(resource);	
	}

}
