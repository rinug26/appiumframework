package stepDefinitions;

import io.cucumber.java.en.Then;
import screens.HomeScreen;
import utilities.BaseMethods;

public class HomeScreenImplementations {

	private HomeScreen hs;

	public HomeScreenImplementations(BaseMethods bm) {
		this.hs = new HomeScreen(bm);
	}

	@Then("^I navigate to homescreen$")
	public void iNavigateToHomescreen() {
		hs.verifyHomeScreenLogo();
	}

}
