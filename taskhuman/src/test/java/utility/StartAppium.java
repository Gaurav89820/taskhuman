package utility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartAppium {
	public void startAtpp() {
		Map<String, String> env = new HashMap<String, String>(System.getenv());
		env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
		AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress("0.0.0.0").usingPort(4723)
				.withEnvironment(env).usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/bin/lib/node_modules/appium/build/libmain.js"));

		Object service = AppiumDriverLocalService.buildService(builder);
		((AppiumDriverLocalService) service).start();

	}
}