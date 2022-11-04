package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;




public class ContactsStepDefs {




    @Given("the user clicks on {string} module")
    public void the_user_clicks_on_module(String module) {

        // Navigate to "Contacts" module
        new ContactsPage().navigateTo(module);
        BrowserUtils.waitFor(3);

    }

    @When("the user clicks on New Contact button")
    public void the_user_clicks_on_New_Contact_button() {

        // Click on "New Contact" button
        new ContactsPage().newContactBtn.click();
        BrowserUtils.waitFor(2);


    }

    @Then("the user can put {string} and {string}")
    public void the_user_can_put_and(String firstName, String lastName) {

        // put first name
        new ContactsPage().addFirstName.sendKeys(firstName);
        BrowserUtils.waitFor(3);
        // put last name
        new ContactsPage().addLastName.sendKeys(lastName);
        BrowserUtils.waitFor(3);

        System.out.println(firstName + " " + lastName + " added");

    }

    @When("the user clicks on All contacts button")
    public void the_user_clicks_on_All_contacts_button() {

        // click on "All contacts button"
        new ContactsPage().allContactsBtn.click();

    }

    @Then("the user should see the {string} in the All contacts list")
    public void the_user_should_see_the_initials_in_the_All_contacts_list(String expectedInitials) {

        BrowserUtils.waitFor(2);

        // list of all contacts in the middle menu.
        System.out.println(ContactsPage.listOfAllContacts());

        // print expected initials
        System.out.println("expectedInitials = " + expectedInitials);

        // Verify that new contact appears in the list with matching initials
        Assert.assertTrue(ContactsPage.listOfAllContacts().contains(expectedInitials));


    }

    @Then("the user should see all the contacts as a list inside the middle column")
    public void the_user_should_see_all_the_contacts_as_a_list_inside_the_middle_column() {

        BrowserUtils.waitFor(3);

        // List of All contacts inside the middle column
        System.out.println("listOfAllContacts() = " + ContactsPage.listOfAllContacts());


    }

    @Then("the user should see total number of contacts")
    public void the_user_should_see_total_number_of_contacts() {

        // get actual number (size) of "All contacts" from the list of middle menu
        int actualContactNum = ContactsPage.listOfAllContacts().size();
        System.out.println("actualContactNum = " + actualContactNum);

        // get expected number of "All contacts" from the menu and convert to int.
        int expectedContactNum = Integer.parseInt(new ContactsPage().contactTotalNum.getText());
        System.out.println("expectedContactNum = " + expectedContactNum);

        // Verify number of all contacts
        Assert.assertEquals(expectedContactNum, actualContactNum);

    }

    @When("the user clicks on an existing contact")
    public void the_user_clicks_on_an_existing_contact() {

        BrowserUtils.waitFor(2);
        // click on an existing contact
        new ContactsPage().contactAvatar.click();

    }

    @When("the user clicks on the avatar icon on the right side")
    public void the_user_clicks_on_the_avatar_icon_on_the_right_side() {

        BrowserUtils.waitFor(1);
        // Click on the avatar icon on the right sid of the page
        new ContactsPage().avatarMenuOptions.click();

    }

    @Then("the user clicks on Choose from files option")
    public void the_user_clicks_on_Choose_from_files_option() {

        BrowserUtils.waitFor(1);
        // click on "Choose from files"
        new ContactsPage().chooseFromFiles.click();


    }

    @Then("the user should be able to change the profile picture")
    public void the_user_should_be_able_to_change_the_profile_picture() {

        BrowserUtils.waitFor(1);
        // click on picture
        new ContactsPage().pictureFile.click();

        // click on Choose
        new ContactsPage().chooseButton.click();
        BrowserUtils.waitFor(1);

        // Verify the picture changed
        Assert.assertTrue(new ContactsPage().contactAvatar.isEnabled());
    }


    @When("the user selects any {string} on the middle column")
    public void the_user_selects_any_on_the_middle_column(String contact) {

        // Find the index number of the contact that will be deleted
        int indexOfChosenContact = ContactsPage.listOfAllContacts().indexOf(contact);
        System.out.println("indexOfChosenContact = " + indexOfChosenContact);

        // Find the web element of the chosen contact from the list of web elements according to index number and get the text
        String chosenContact = ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).getText();
        System.out.println("chosenContact = " + chosenContact);

        // Click on the chosen contact
        ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).click();

        BrowserUtils.waitFor(2);
    }

    @When("the user clicks on Delete option from the three dotted menu")
    public void the_user_clicks_on_Delete_option_from_the_three_dotted_menu() {

        // Click on three dotted menu
        new ContactsPage().threeDotMenu.click();

        // Click on "Delete" option from the menu;
        new ContactsPage().deleteOption.click();

        BrowserUtils.waitFor(2);


    }

    @Then("the user should be able to delete the {string}")
    public void the_user_should_be_able_to_delete_the_contact(String contact) {

        // Print the contact that will be deleted
        System.out.println("Deleted contact = " + contact);

        // Verify that the contact is not in the list anymore
        Assert.assertFalse(ContactsPage.listOfAllContacts().contains(contact));

        // Print the new list after deleting
        System.out.println("ContactsPage.listOfAllContacts() = " + ContactsPage.listOfAllContacts());


    }

}