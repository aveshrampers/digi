package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MovieListingPage;

public class MovieListingSteps {
    MovieListingPage movieListingPage = new MovieListingPage();

    @When("^I click the \"([^\"]*)\" header$")
    public void Click_On_Header(String header) {
        movieListingPage.Click_Title_Header(header);
    }

    @Then("^the last movie in the list should be \"([^\"]*)\"$")
    public void Verify_Last_Movie(String title) {
        movieListingPage.Verify_Last_Movie_Title(title);
    }
}
