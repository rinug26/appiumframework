package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseMethods {

	public AppiumDriver driver;
	DesiredCapabilities cap;
	private String deviceId = System.getProperty("deviceId");
	private String platformVersion = System.getProperty("platformVersion");
	private String platformName = System.getProperty("platformNAme");

	@Before
	public void launchApp() throws Exception {
		if (getDeviceId().equalsIgnoreCase("emulator-5554")) {
			androidEmulatorSettings();
		}

		else if (getDeviceId().equalsIgnoreCase("RZ8M93VGN5K")) {
			androidDeviceSettings();
		}

		else if (getDeviceId().equalsIgnoreCase("<ios device id>")) {
			// Code for iOS
		}

		else {
			throw new Exception("Device not found");
		}
	}

	public void cloudDeviceSettings() throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("build", "Lambda test scanner android");
		cap.setCapability("name", "Lambda test scanner android test cases");
		cap.setCapability("deviceName", "");
		cap.setCapability("platformVersion", "");
		cap.setCapability("platformName", "");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("enableImageInjection", true);
		cap.setCapability("app", "");
		cap.setCapability("isRealMobile", true);
		cap.setCapability("console", true);
		cap.setCapability("network", false);
		cap.setCapability("visual", true);
		cap.setCapability("devicelog", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("w3c", true);
		String hub = "https://username:accesskey@mobile-hub.lambdatest.com/wd/hub";
		driver = new AndroidDriver(new URL(hub), cap);
	}

	public void androidEmulatorSettings() throws IOException {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("app", "/home/RinuGeorge/Downloads/cucumberframework-main/app/odbm-5.0.0-582.apk");
		cap.setCapability("deviceName", "MyPixel");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("udid", deviceId);
		// cap.setCapability("udid", readPropertiesFile().getProperty("emulatorId"));
		URL url = new URL("http://127.0.0.1:4723/"); // URL for appium 2.0
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void androidDeviceSettings() throws IOException {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "uiAutomator2");
		cap.setCapability("app", System.getProperty("user.dir") + "/app/odbm-5.0.0-582.apk");
		cap.setCapability("deviceName", "MyPixel");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("udid", deviceId);
		// cap.setCapability("udid", readPropertiesFile().getProperty("deviceId"));
		URL url = new URL("http://127.0.0.1:4723/"); // URL for appium 2.0
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void iOSSettings() throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone 14"); // As per requirement
		cap.setCapability("platformName", "iOS");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("platformVersion", "16.2"); // As per requirement
		cap.setCapability("udid", "");
		cap.setCapability("updatedWDABundleId", "");
		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void quitSession() {
		driver.quit();
	}

	public String getDeviceId() {
		return deviceId;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public String getPlatformName() {
		return platformName;
	}

	public Properties readPropertiesFile() throws IOException {
		Properties p = new Properties();
		InputStream stream = this.getClass().getResourceAsStream("TestData.properties");
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
		p.load(reader);
		return p;
	}
}
