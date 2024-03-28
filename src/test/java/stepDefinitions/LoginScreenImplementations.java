package stepDefinitions;

import java.net.MalformedURLException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.LoginScreen;
import utilities.BaseMethods;

public class LoginScreenImplementations {

	private LoginScreen ls;

	public LoginScreenImplementations(BaseMethods bm) {
		this.ls = new LoginScreen(bm);
	}

	@Given("^I launch the application$")
	public void iLaunchTheApplication() throws MalformedURLException, InterruptedException {
//		ls.displayLogo();
		ls.clickMore();
		ls.tapAccount();
	}

	@When("^I enter username \"([^\"]*)\"$")
	public void iEnterFieldA(String value1) throws MalformedURLException, InterruptedException {
		ls.enterEmail(value1);
	}

	@And("^I enter password \"([^\"]*)\"$")
	public void iEnterFieldB(String value2) throws MalformedURLException, InterruptedException {
		ls.enterPassword(value2);
	}

	@And("^I click on login button$")
	public void iSeeTotalValue() throws Exception {
		ls.clickLoginButton();
	}
	@Then("^I navigate to homescreen$")
	public void validateHomescreen() throws Exception{
		ls.displayHome();
	}


}
