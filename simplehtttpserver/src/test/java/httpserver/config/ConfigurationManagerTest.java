package httpserver.config;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationManagerTest {

	@Test(expected=HttpConfigurationException.class)
	public void getCurrentConfigurationFileTest() {
			ConfigurationManager myConfigurationManager= new ConfigurationManager();
			myConfigurationManager.getCurrentConfiguration();
	}
	
	@Test(expected=HttpConfigurationException.class)
	public void loadConfigurationFileTest() {
			ConfigurationManager myConfigurationManager= new ConfigurationManager();
			myConfigurationManager.loadConfigurationFile("");
	}
	
//	@Test()
//	public void loagConfigurationFileTest2() {
//			ConfigurationManager myConfigurationManager= new ConfigurationManager();
//			myConfigurationManager.loadConfigurationFile("src/main/resources/http.json");
//			assertEquals("Not as expected",8080,myConfigurationManager.getCurrentConfiguration().getPort());
//	}
//
//	@Test()
//	public void loagConfigurationFileTest3() {
//		ConfigurationManager myConfigurationManager= new ConfigurationManager();
//		myConfigurationManager.loadConfigurationFile("src/main/resources/http.json");
//		assertEquals("Not as expected","/tmp",myConfigurationManager.getCurrentConfiguration().getWebroot());
//	}
//
//	@Test()
//	public void getInstance() {
//		ConfigurationManager myConfigurationManager = null;
//		ConfigurationManager newOne = myConfigurationManager.getInstance();
//		assertNotNull(newOne);
//	}
}
