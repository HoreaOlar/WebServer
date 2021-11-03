package httpserver.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testPort() {
		Configuration conf = new Configuration();
		conf.setPort(443);
		assertEquals(443, conf.getPort());
	}

	@Test
	public void testWebroot(){
		Configuration conf = new Configuration();
		conf.setWebroot("/tmp");
		assertEquals("/tmp",conf.getWebroot());
	}

}
