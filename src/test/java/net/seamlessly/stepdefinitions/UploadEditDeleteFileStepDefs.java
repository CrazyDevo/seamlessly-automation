package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.FileUploadDeletePage;

import org.junit.Assert;

public class UploadEditDeleteFileStepDefs {

    @Given("the user navigate to {string}")
    public void the_user_navigate_to(String module) {
        new FileUploadDeletePage().navigateTo(module);
    }

    @When("the user upload {string}")
    public void the_user_upload(String fileName) {
        new FileUploadDeletePage().uploadFile(fileName);
    }

    @When("the user create new folder {string}")
    public void the_user_create_new_folder_TestFolder(String fileName) {
        new FileUploadDeletePage().createFolder(fileName);
    }


    @Then("the user should see folder on page {string}")
    public void the_user_should_see_TestFolder_on_page(String createdFolder) {
        String expectedFolder=createdFolder;
        String actualFolder=new FileUploadDeletePage().isUploadedOrCreated(createdFolder);

        Assert.assertEquals(expectedFolder, actualFolder);

    }

    @Then("the user should see {string} on page")
    public void the_user_should_see_on_page(String addedFile) {

            String expectedUploadedFile=addedFile;
            String actualUploadedFile=new FileUploadDeletePage().isUploadedOrCreated(addedFile);

            System.out.println("expectedUploadedFile = " + expectedUploadedFile);
            System.out.println("actualUploadedFile = " + actualUploadedFile);

            Assert.assertEquals(expectedUploadedFile, actualUploadedFile);
            new FileUploadDeletePage().deleteItem(addedFile);

    }

    @When("the user move the {string} to {string}")
    public void the_user_move_the_to(String item, String folder) {
        new FileUploadDeletePage().moveTo(item, folder);
    }

    @Then("the user should see moved {string} in {string}")
    public void the_user_should_see_moved_in(String item, String folder) {
        String actualResult=new FileUploadDeletePage().isInFolder(item, folder);
        String expectedResult=item;

        Assert.assertEquals(expectedResult, actualResult);
        new FileUploadDeletePage().moveToBack(item);
    }

    @Then("the user should see copied {string} in {string} and FileList")
    public void the_user_should_see_copied_in(String item, String folder) {
        if(new FileUploadDeletePage().isInMainFileList(item)) {

            String actualResult=new FileUploadDeletePage().isInFolder(item, folder);
            String expectedResult=item;

            Assert.assertEquals(expectedResult, actualResult);
            new FileUploadDeletePage().deleteItem(item);

        }
    }

    @When("the user copy the {string} to {string}")
    public void the_user_copy_the_to(String item, String folder) {
        new FileUploadDeletePage().copyTo(item, folder);
    }

    @When("the user delete any selected {string}")
    public void the_user_delete_any_selected(String item) {
        new FileUploadDeletePage().deleteItem(item);
    }

    @Then("the user should see {string} in deleted files")
    public void the_user_should_see_in_deleted_files(String item) {
        String expectedResult=item;
        String actualResult=new FileUploadDeletePage().isInDeletedFile(item);

        Assert.assertEquals(expectedResult, actualResult);
        new FileUploadDeletePage().restoreFile(item);

    }

    @Then("the user should see total number of files and folders")
    public void the_user_should_see_total_number_of_files_and_folders() {

        int expectedFileNumber=new FileUploadDeletePage().getDisplayedFileNumber();
        int actualFileNumber=new FileUploadDeletePage().countFile();

//        System.out.println("expectedFileNumber = " + expectedFileNumber);
//        System.out.println("actualFileNumber = " + actualFileNumber);

        Assert.assertEquals(expectedFileNumber, actualFileNumber);

        int expectedFolderNumber=new FileUploadDeletePage().getDisplayedFolderNumber();
        int actualFolderNumber=new FileUploadDeletePage().countFolder();

//        System.out.println("expectedFolderNumber = " + expectedFolderNumber);
//        System.out.println("actualFolderNumber = " + actualFolderNumber);

        Assert.assertEquals(expectedFolderNumber, actualFolderNumber);


    }






}
