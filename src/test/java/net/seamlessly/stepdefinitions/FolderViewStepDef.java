package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.seamlessly.pages.FolderViewPage;
import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class FolderViewStepDef {

    List<String> actualelement;


    @And("the user clicks on name")
    public void theUserClicksOnName() {
        FolderViewPage fp = new FolderViewPage();
        actualelement = BrowserUtils.getElementsText(new FolderViewPage().listoffiles);
        System.out.println("before click"+actualelement);
        fp.name.click();
    }


    @Then("the view of folders should change by name")
    public void theViewOfFoldersShouldChangeByName() {
        List<String> expected = BrowserUtils.getElementsText(new FolderViewPage().listoffiles);
        Collections.sort(actualelement);

        System.out.println("accepted after click"+expected);
        Assert.assertEquals(expected,actualelement);

    }

    @And("the user clicks on size")
    public void theUserClicksOnSize() {

        FolderViewPage fp = new FolderViewPage();
        actualelement = BrowserUtils.getElementsText(new FolderViewPage().listofsize);
        System.out.println("before click"+actualelement);
        fp.size.click();

    }

    @Then("the order of the folders should change by size")
    public void theOrderOfTheFoldersShouldChangeBySize() {

        List<String> ex = BrowserUtils.getElementsText(new FolderViewPage().listofsize);
        Collections.sort(actualelement);

        System.out.println("after click"+ex);
        Assert.assertEquals(ex,actualelement);

    }

    @And("the user clicks on modified")
    public void theUserClicksOnModified() {

        FolderViewPage fp = new FolderViewPage();
        actualelement = BrowserUtils.getElementsText(new FolderViewPage().listofmodels);
        System.out.println("before click"+actualelement);
        fp.modified.click();

    }

    @Then("the order of the folders should change by date")
    public void theOrderOfTheFoldersShouldChangeByDate() {


        List<String> exp = BrowserUtils.getElementsText(new FolderViewPage().listofmodels);
        Collections.sort(actualelement);

        System.out.println("after click"+exp);
        Assert.assertEquals(exp,actualelement);

    }

    @And("the user clicks on toggle view")
    public void theUserClicksOnToggleView() {

        BrowserUtils.waitFor(1);

        FolderViewPage FP = new FolderViewPage();
        BrowserUtils.waitForVisibility(FP.toggleview1,15);
        String actual = FP.toggleview1.getAttribute("class");


       if(actual.contains("view-grid")){
           Assert.assertTrue(actual.contains("view-grid"));
           System.out.println("actual = " + actual);
       }else {
           Assert.assertFalse(actual.contains("view-grid"));
           System.out.println("actual = " + actual);
       }






//        String expected = "list-container  has-controls";
//       String actual1 = new FolderViewPage().toggleview1.getAttribute("class");
//        System.out.println(actual1);
//        System.out.println(expected);

       FP.toggle.click();

    }

    @Then("the order of the folders should change by view")
    public void theOrderOfTheFoldersShouldChangeByView() {
        FolderViewPage FP = new FolderViewPage();
        String expected = FP.toggleview1.getAttribute("class");

        if(expected.contains("view-grid")){
            Assert.assertTrue(expected.contains("view-grid"));
            System.out.println("expected = " + expected);
        }else{

            Assert.assertFalse(expected.contains("view-grid"));
            System.out.println("expected = " + expected);
        }


    }

}
