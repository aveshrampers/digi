package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MovieDescriptionPage;

public class MovieDescriptionSteps {
    MovieDescriptionPage movieDescriptionPage = new MovieDescriptionPage();

@Given("^I am on the movie listing page$")
public void Navigate() {
    movieDescriptionPage.Verify_Homepage();
}

@When("^I navigate to the movie details page for \"([^\"]*)\"$")
public void iNavigateToTheMovieDetailsPageFor(String selectedTitle) {
    movieDescriptionPage.Navigate_To_Title_Description(selectedTitle);
}

@Then("^I should see \"([^\"]*)\" listed$")
public void iShouldSeeListed(String specieName) {
    movieDescriptionPage.Assert_Species(specieName);
}

@Then("^I should not see the planet \"([^\"]*)\" listed$")
public void iShouldNotSeeThePlanetListed(String planetName) {
    movieDescriptionPage.Assert_Planet(planetName);
}

}
