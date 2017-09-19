package io.ninja.jrochette.health;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.codahale.metrics.health.HealthCheck.Result;

public class NinjaFinderHealthCheckTest {

	private NinjaFinderHealthCheck ninjaFinderHealthCheck;

	@Before
	public void setup() {
		ninjaFinderHealthCheck = new NinjaFinderHealthCheck();
	}

	@Test
	public void testCheckReturnsHealthy() throws Exception {
		assertEquals(Result.healthy().getMessage(), ninjaFinderHealthCheck.check().getMessage());
	}

}
