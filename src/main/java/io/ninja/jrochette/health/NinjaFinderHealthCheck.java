package io.ninja.jrochette.health;

import com.codahale.metrics.health.HealthCheck;

public class NinjaFinderHealthCheck  extends HealthCheck{

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
