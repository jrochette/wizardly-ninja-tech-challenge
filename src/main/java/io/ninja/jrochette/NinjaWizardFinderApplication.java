package io.ninja.jrochette;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.ninja.jrochette.health.NinjaFinderHealthCheck;
import io.ninja.jrochette.resources.NinjaFinderResource;

public class NinjaWizardFinderApplication extends Application<NinjaWizardFinderConfiguration> {
	public static void main(final String[] args) throws Exception {
		new NinjaWizardFinderApplication().run(args);
	}

	@Override
	public String getName() {
		return "NinjaWizardFinder";
	}

	@Override
	public void initialize(final Bootstrap<NinjaWizardFinderConfiguration> bootstrap) {
		// Nothing to bootstrap
	}

	@Override
	public void run(final NinjaWizardFinderConfiguration configuration, final Environment environment) {
		final NinjaFinderResource ninjaFinderResource = new NinjaFinderResource();
		final NinjaFinderHealthCheck ninjaFinderHealthCheck = new NinjaFinderHealthCheck();
		
		environment.healthChecks().register("ninja", ninjaFinderHealthCheck);
		environment.jersey().register(ninjaFinderResource);
	}
}