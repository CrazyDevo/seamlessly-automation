package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DeletedFilesPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

public class DeletedFilesStepDefs {

    String firstFileName = new DeletedFilesPage().firstLineName.getText();

    @Given("the user deletes the file which is in the first line")
    public void the_user_deletes_the_file_which_is_in_the_first_line() {
        BrowserUtils.waitFor(3);
        new DeletedFilesPage().firstLine3Dots.click();
        BrowserUtils.waitFor(2);
        new DeletedFilesPage().deleteFileLink.click();

    }
    @When("the user clicks Deleted files link")
    public void the_user_clicks_Deleted_files_link() {
        new DeletedFilesPage().deletedFilesTab.click();
    }
    @Then("the user should be able to see the the most recent deleted file in the first line")
    public void the_user_should_be_able_to_see_the_the_most_recent_deleted_file_in_the_first_line() {
        BrowserUtils.waitFor(3);
        new DeletedFilesPage().deletedLink.click();
        new DeletedFilesPage().deletedLink.click();
        BrowserUtils.waitFor(2);
        String deletedFirstLineFile = new DeletedFilesPage().deletedFirstLineName.getText();

        Assert.assertEquals(firstFileName,deletedFirstLineFile);

        new DeletedFilesPage().deletedFirstLineRestore.click();

    }
    @Then("the user should be able to order the all deleted files")
    public void the_user_should_be_able_to_order_the_all_deleted_files() {
        BrowserUtils.waitFor(3);
        new DeletedFilesPage().deletedLink.click();
        new DeletedFilesPage().deletedLink.click();
        BrowserUtils.waitFor(2);
        String deletedFirstLineFile = new DeletedFilesPage().deletedFirstLineName.getText();

        System.out.println("firstFileName = " + firstFileName);
        System.out.println("deletedFirstLineFile = " + deletedFirstLineFile);
        Assert.assertEquals(firstFileName,deletedFirstLineFile);

        new DeletedFilesPage().deletedLink.click();

        BrowserUtils.waitFor(2);
        int numberOfDeletedFiles = new DeletedFilesPage().allDeletedFiles.size();
        System.out.println("numberOfDeletedFiles = " + numberOfDeletedFiles);

        Assert.assertEquals(firstFileName,new DeletedFilesPage().getLastDeletedFileName());

        System.out.println("firstFileName = " + firstFileName);
        System.out.println("LastDeletedFileName = " + new DeletedFilesPage().getLastDeletedFileName());
        BrowserUtils.waitFor(1);
        new DeletedFilesPage().deletedLink.click();
        BrowserUtils.waitFor(2);
        new DeletedFilesPage().deletedFirstLineRestore.click();

    }
    @Then("the user should be able to order alphabetically all the deleted files")
    public void the_user_should_be_able_to_order_alphabetically_all_the_deleted_files() {
        BrowserUtils.waitFor(3);
        new DeletedFilesPage().nameLink.click();

        String deletedFirstLineFileName = new DeletedFilesPage().deletedFirstLineName.getText();

        BrowserUtils.waitFor(1);
        new DeletedFilesPage().nameLink.click();

        String deletedLastLineFileName = new DeletedFilesPage().getLastDeletedFileName();

        System.out.println("deletedFirstLineFileName = " + deletedFirstLineFileName);
        System.out.println("deletedLastLineFileName = " + deletedLastLineFileName);

        Assert.assertEquals(deletedFirstLineFileName,deletedLastLineFileName);
    }

    @Then("the user should be able to delete any deleted file permanently")
    public void the_user_should_be_able_to_delete_any_deleted_file_permanently() {
        BrowserUtils.waitFor(3);
        String firstName = new DeletedFilesPage().deletedFirstLineName.getText();
        System.out.println("firstName = " + firstName);

        new DeletedFilesPage().first3DotsDeletedFile.click();
        BrowserUtils.waitFor(1);
        new DeletedFilesPage().deletePermanently.click();
        BrowserUtils.waitFor(3);

        String secondName = new DeletedFilesPage().deletedFirstLineName.getText();
        System.out.println("secondName = " + secondName);

        Assert.assertNotEquals(firstName,secondName);

    }

    @Then("he user should be able to restore the file")
    public void he_user_should_be_able_to_restore_the_file() {
        BrowserUtils.waitFor(3);
        String firstName = new DeletedFilesPage().deletedFirstLineName.getText();
        System.out.println("firstName = " + firstName);

        new DeletedFilesPage().deletedFirstLineRestore.click();
        BrowserUtils.waitFor(3);
        new DeletedFilesPage().allFiles.click();
        BrowserUtils.waitFor(3);

        System.out.println(new DeletedFilesPage().getAllFileName().toString());

        for (String name:new DeletedFilesPage().getAllFileName()) {
            if (name.equals(firstName)){
                Assert.assertEquals(firstName,name);
            }
        }


    }
}
