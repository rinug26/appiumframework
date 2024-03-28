package screens;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utilities.BaseMethods;

public class LoginScreen {

	private BaseMethods bm;
	private final Logger LOG = LogManager
			.getLogger(LoginScreen.class); /* LOG is written in caps as it is a final value */

	public LoginScreen(BaseMethods bm) {
		this.bm = bm;
		PageFactory.initElements(new AppiumFieldDecorator(bm.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"HOME\"]")
	WebElement home;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
//	@iOSXCUITFindBy(xpath = "")
	WebElement userName;

@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText")
//	@iOSXCUITFindBy(xpath = "")
	WebElement password;

	@AndroidFindBy(accessibility = "Sign In")
//	@iOSXCUITFindBy(xpath = "")
	WebElement loginButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"MORE\"]/com.horcrux.svg.SvgView")
	WebElement more;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ACCOUNT']")
	WebElement account;


	public void clickMore()
	{
		more.click();
	}
	
	public void tapAccount()
	{
		account.click();
	}

	public void enterEmail(String uname) throws InterruptedException {
		userName.click();
		userName.sendKeys(uname);
		bm.driver.navigate().back();
		LOG.info("Username is entered");
	}

	public void enterPassword(String pswd) throws InterruptedException {
		password.click();
		password.sendKeys(pswd);
		bm.driver.navigate().back();
		LOG.info("Password is entered");
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void displayHome() throws MalformedURLException, InterruptedException {
		home.isDisplayed();
	}

}
