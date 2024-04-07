package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.ReusableMethods;

public class MovieListSteps {
    String pathValue = "results.episode_id";

    @Given("^the url$")
    public void getUrl() {
        ReusableMethods.baseRequest("/");
    }

    @Then("^assert response count is (.*)$")
    public void assertMovieCount(int count) {
        ReusableMethods.countAssert("count", count);
    }

    @Then("^assert the (.*)rd movie is directed by (.*)$")
    public void assertDirector(Integer sequel, String director) {
        ReusableMethods.castAssertion(sequel, director, "director", pathValue);
    }

    @Then("^assert the (.*)th movie is not producers (.*)$")
    public void assertProducer(Integer sequel, String producer) {
        ReusableMethods.castAssertion(sequel, producer, "producer", pathValue);
    }
}