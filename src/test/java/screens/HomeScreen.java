package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utilities.BaseMethods;

public class HomeScreen {

	private BaseMethods bm;
	private final Logger LOG = LogManager
			.getLogger(LoginScreen.class); /* LOG is written in caps as it is a final value */

	public HomeScreen(BaseMethods bm) {
		this.bm = bm;
		PageFactory.initElements(new AppiumFieldDecorator(bm.driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"QB Alumni\"]")
	@iOSXCUITFindBy(xpath = "")
	WebElement homeScreenLogo;

	public void verifyHomeScreenLogo() {
		homeScreenLogo.isDisplayed();
	}

}
