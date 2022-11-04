package net.seamlessly.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.NewGroupContactsPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;



public class NewGroupContactDefs {
    @When("the user click {string} module")
    public void theUserClickModule(String module) {
        new NewGroupContactsPage().navigateTo(module);
        BrowserUtils.waitFor(5);


    }

    @Then("the user on the contacts page")
    public void theUserOnTheContactsPage() {
        String contactPage = "http://qa.seamlessly.net/index.php/apps/contacts/All%20contacts/44292e58-29a3-41db-9b79-47c3466da989~contacts";
        String expectedUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl, contactPage);

    }

    @When("the user click plus button")
    public void theUserClickPlusButton() {
        new NewGroupContactsPage().plusButton.click();
        BrowserUtils.waitFor(4);
    }

    @Then("the user can see {string} text in the box")
    public void theUserCanSeeTextInTheBox(String text) {
        String actualText = new NewGroupContactsPage().newgroupText.getText();
        Assert.assertEquals(text, actualText);

    }

    @When("the user enter new group name in the box")
    public void theUserEnterNewGroupNameInTheBox() {
        new NewGroupContactsPage().newGroupTextBox.sendKeys("STAR" + Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @And("the user click All contacts button")
    public void theUserClickAllContactsButton() {
        new NewGroupContactsPage().allContactsButton.click();
    }

    @And("the user click contact")
    public void theUserClickContact() {
        new NewGroupContactsPage().contact.click();
    }




    @And("the user click groups dropdown menu")
    public void theUserClickGroupsDropdownMenu() {
        NewGroupContactsPage ngcp = new NewGroupContactsPage();
       ngcp.groupDropdown.click();
        BrowserUtils.waitFor(10);
    }

    @Then("the user can see {string}")
    public void theUserCanSee(String groupName) {

        NewGroupContactsPage ngcp = new NewGroupContactsPage();
        ngcp.starOption.click();
        BrowserUtils.waitFor(4);
        String actual=ngcp.groupDropdownList.get(0).getText();
        Assert.assertTrue(actual.contains(groupName));

    }
    @When("the user click Choose property type box")
    public void theUserClickChoosePropertyTypeBox() {
        new NewGroupContactsPage().propertyType.click();
        BrowserUtils.waitFor(5);
    }

    @And("the user select Birthday")
    public void theUserSelectBirthday() {
        BrowserUtils.waitFor(10);
        new NewGroupContactsPage().birthday.click();

    }

    @Then("the user can see Birthday box")
    public void theUserCanSeeBirthdayBox() {
        BrowserUtils.waitFor(10);
        Assert.assertTrue(new NewGroupContactsPage().birthdayBox.isDisplayed());


    }


    @Then("the user see left side group names and should be matching with Groups dropdown menu")
    public void theUserSeeLeftSideGroupNamesAndShouldBeMatchingWithGroupsDropdownMenu() {
        NewGroupContactsPage ngcp=new NewGroupContactsPage();
        String leftSide=ngcp.leftGroupTable.getText();
        String rightSide=ngcp.groupDropdownList.get(0).getText();
        Assert.assertEquals(leftSide,rightSide);

    }
}
