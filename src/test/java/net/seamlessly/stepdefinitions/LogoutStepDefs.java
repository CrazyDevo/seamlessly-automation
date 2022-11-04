package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.*;
import net.seamlessly.pages.HomePage;
import net.seamlessly.utilities.Driver;

public class LogoutStepDefs {

    @Given("the user clicks the avatar icon")
    public void the_user_clicks_the_avatar_icon() {
        new HomePage().avatarIcon.click();
    }

    @Given("the user clicks the logout label")
    public void the_user_clicks_the_logout_label() {
        new HomePage().logOutLink.click();
    }

    @When("the user clicks step back button")
    public void the_user_clicks_step_back_button() {
        Driver.get().navigate().back();
    }



}
