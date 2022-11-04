package net.seamlessly.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.CalendarPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

public class CalendarStepDefs {

    @Given("the user navigate to {string} module")
    public void the_user_navigate_to_module(String module) {

        new BasePage().navigateTo(module);
    }

    @Given("the user click three dot icon")
    public void the_user_click_three_dot_icon() {

        new CalendarPage().threeDotIcon.click();
    }

    @When("the user click day icon")
    public void the_user_click_day_icon() {

        new CalendarPage().dayButton.click();
    }

    @Then("the user can see daily calendar view")
    public void the_user_can_see_daily_calendar_view() {

       String actualresult= new CalendarPage().datePickerButton.getText();
       String expectedresult="Sep 1, 2021";

       Assert.assertEquals(actualresult,expectedresult);
    }

    @When("the user click week icon")
    public void the_user_click_week_icon() {

        new CalendarPage().weekButton.click();
    }

    @Then("the user can see weekly calendar view")
    public void the_user_can_see_weekly_calendar_view() {

        String actualresult= new CalendarPage().datePickerButton.getText();
        String expectedresult="Week 36 of 2021";

        Assert.assertEquals(actualresult,expectedresult);
    }

    @When("the user click monthly icon")
    public void the_user_click_monthly_icon() {

        new CalendarPage().monthButton.click();
    }

    @Then("the user can see monthly calendar view")
    public void the_user_can_see_monthly_calendar_view() {

        String actualresult= new CalendarPage().datePickerButton.getText();
        String expectedresult="September 2021";

        Assert.assertEquals(actualresult,expectedresult);
    }

    @Given("the user click new event")
    public void the_user_click_new_event() {

        new CalendarPage().newEventButton.click();
        BrowserUtils.waitFor(3);
    }

    @When("the user can give a name for new event")
    public void the_user_can_give_a_name_for_new_event() {

        new CalendarPage().eventName.sendKeys("Agile Meeting");
    }

    @When("the user can choose today's date as event start date")
    public void the_user_can_choose_today_s_date_as_event_start_date() {

        CalendarPage calendarPage=new CalendarPage();
        calendarPage.startDateBox.click();
        BrowserUtils.waitFor(2);
        calendarPage.startDatePick.click();
        BrowserUtils.waitFor(2);
        calendarPage.startHour.click();
        BrowserUtils.waitFor(2);
        calendarPage.startMinute.click();
        BrowserUtils.waitFor(2);
        calendarPage.AMorPm.click();
        BrowserUtils.waitFor(2);
        calendarPage.emptyPlace.click();
    }

    @When("the user can choose today's date as event finish date")
    public void the_user_can_choose_today_s_date_as_event_finish_date() {

        CalendarPage calendarPage=new CalendarPage();
       calendarPage.endDateBox.click();
       BrowserUtils.waitFor(2);
        calendarPage.endDatePick.click();
        BrowserUtils.waitFor(2);
        calendarPage.endHour.click();
        BrowserUtils.waitFor(2);
        calendarPage.endMinute.click();
        BrowserUtils.waitFor(2);
        calendarPage.PmorAm.click();
    }

    @Then("the user can click save event button")
    public void the_user_can_click_save_event_button() {

       // new CalendarPage().allDay.click();
        new CalendarPage().saveButton.click();
    }

    @Then("the user can see new event related day on the monthly calendar view")
    public void the_user_can_see_new_event_related_day_on_the_monthly_calendar_view() {

        String actualresult=new CalendarPage().verifyEvent.getText();
        String expectedresult="Agile Meeting";
        Assert.assertEquals(actualresult,expectedresult);

    }

    @When("the user can click event on monthly calendar")
    public void the_user_can_click_event_on_monthly_calendar() {

        new CalendarPage().findEventButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user can click more button")
    public void the_user_can_click_more_button() {

        new CalendarPage().moreButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user can click three button next to event's name")
    public void the_user_can_click_three_button_next_to_event_s_name() {

        new CalendarPage().actionButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user can click delete button")
    public void the_user_can_click_delete_button() {

        new CalendarPage().deleteButton.click();

    }

}
