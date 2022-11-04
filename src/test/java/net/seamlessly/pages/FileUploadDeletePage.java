package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FileUploadDeletePage extends BasePage {
   public FileUploadDeletePage(){
       PageFactory.initElements(Driver.get(), this);
   }

   @FindBy(css = ".button.new")
    protected WebElement addIcon;

   @FindBy(css = "#file_upload_start")
    protected WebElement uploadFile;

    @FindBy(xpath = "//tr[@data-type='file' or @data-type='dir']")
    protected List<WebElement> filesList;

   @FindBy(css = "#uploadprogressbar")
   protected WebElement progressbar;

   @FindBy(xpath = "(//span[@class='displayname'])[2]")
   protected WebElement newFolder;

   @FindBy(xpath = "//input[@value='New folder']")
   protected WebElement folderNameInput;

   @FindBy(xpath = "//li/a/form/input[@type='submit']")
   protected WebElement folderSubmit;

   @FindBy(xpath = "//a[@class='menuitem action action-movecopy permanent']")
   protected WebElement moveOrCopy;

   @FindBy(xpath = "//div[@class='filelist-container']//tr[@data-type='dir']")
   protected List<WebElement> chooseFolder;

   @FindBy(xpath = "//button[@class='primary']")
   protected WebElement moveButton;

   @FindBy(xpath = "//div[@class='oc-dialog-buttonrow twobuttons aside']/button[contains(text(),'Copy')]")
   protected WebElement copyButton;

   @FindBy(xpath = "//li[@data-id='trashbin']")
   protected WebElement deletedFiles;

   @FindBy(xpath = "//li[@class=' action-delete-container']")
   protected WebElement deleteFile;

   @FindBy(xpath = "//tr[@data-type='file']")
   protected List<WebElement> file;

    @FindBy(xpath = "//tr[@data-type='dir']")
    protected List<WebElement> folderList;

    @FindBy(css = ".dirinfo")
    protected WebElement folderDisAmount;

    @FindBy(css = ".fileinfo")
    protected WebElement fileDisAmount;

    @FindBy(xpath = "//div[@class='crumb']")
    protected WebElement homeFolderIcon;

    @FindBy(xpath = "//td[@class='filename']//span[@class='nametext extra-data']")
    protected List<WebElement> deletedFilesList;



   public void uploadFile(String fileName){
       addIcon.click();
       uploadFile.sendKeys((System.getProperty("user.dir") + "\\src\\test\\resources\\uploadedFiles\\"+fileName));
       waitUntilProgressbarDisappear();
       BrowserUtils.waitFor(3);
   }


    public void waitUntilProgressbarDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 1000);
            wait.until(ExpectedConditions.invisibilityOf(progressbar));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createFolder(String folderName) {
        addIcon.click();
        newFolder.click();
        folderNameInput.sendKeys(folderName);
        folderSubmit.click();
        BrowserUtils.waitFor(3);
    }


    public String isUploadedOrCreated(String uploadedOrCreated) {

           for (WebElement file: filesList) {
               if (uploadedOrCreated.equals(file.getAttribute("data-file"))) {

                   return file.getAttribute("data-file");
               }
           }
           return  null;
    }

    public void moveTo(String item, String folder) {
       int i=0;
       for (WebElement file:filesList) {
            i++;
            if (item.equals(file.getAttribute("data-file"))) {
               Driver.get().findElement(By.xpath("(//a[@class='action action-menu permanent'])"+"["+i+"]")).click();
               BrowserUtils.waitFor(2);
               moveOrCopy.click();
                for (WebElement fld:chooseFolder) {
                    if (folder.equals(fld.getAttribute("data-entryname"))) {
                        BrowserUtils.waitFor(1);
                        fld.click();
                        moveButton.click();
                    }
                }
            }
        }
    }

    public void openItem(String itemName) {
       navigateTo("files");
        for (WebElement file:filesList) {
            if(itemName.equals(file.getAttribute("data-file"))) {
                file.click();
            }
        }
    }

    public void scrollDown() {
        JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
        for (int i=0; i<10; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            BrowserUtils.waitFor(1);
        }

    }

    public void copyTo(String item, String folder) {
        int i=0;
        for (WebElement file:filesList) {
            i++;
            if (item.equals(file.getAttribute("data-file"))) {
                Driver.get().findElement(By.xpath("(//a[@class='action action-menu permanent'])"+"["+i+"]")).click();
                BrowserUtils.waitFor(2);
                moveOrCopy.click();
                for (WebElement fld:chooseFolder) {
                    if (folder.equals(fld.getAttribute("data-entryname"))) {
                        BrowserUtils.waitFor(1);
                        fld.click();
                        copyButton.click();
                    }
                }
            }
        }
    }

    public String isInDeletedFile(String item) {

       deletedFiles.click();
        for (WebElement file: deletedFilesList) {

            scrollDown();
            if(item.equals(file.getAttribute("data-original-title"))){
                return file.getAttribute("data-original-title");
            }
        }

       return null;
    }

    public void deleteItem(String item) {
        int i = 0;
        for (WebElement file : filesList) {
            i++;
            if (item.equals(file.getAttribute("data-file"))) {
                Driver.get().findElement(By.xpath("(//tr[@data-type='file' or @data-type='dir']//a[@data-action='menu'])["+i+"]")).click();
                BrowserUtils.waitFor(2);
                deleteFile.click();
            }
        }

    }

    public void restoreFile(String item) {
        int i=0;
        deletedFiles.click();
        for (WebElement file: deletedFilesList) {
            ++i;
            if(item.equals(file.getAttribute("data-original-title"))){
                Driver.get().findElement(By.xpath("(//a[@class='action action-restore permanent'][@data-action='Restore'])["+i+"]/span")).click();
            }

        }

    }

    public int countFile() {
       //navigateTo("files");
       BrowserUtils.waitFor(2);
       int fileAmount=0;
        for (WebElement fl:file) {
            ++fileAmount;
        }
        System.out.println("fileAmount = " + fileAmount);
        return fileAmount;

    }

    public int countFolder() {
        //navigateTo("files");
        BrowserUtils.waitFor(2);
        int folderAmount=0;
        for (WebElement fl:folderList) {
            ++folderAmount;
        }
        System.out.println("folderAmount = " + folderAmount);
        return folderAmount;

    }

    public int getDisplayedFileNumber() {
       //navigateTo("files");
        scrollDown();
        int fileNum=0;
       String[] str=fileDisAmount.getText().split(" ");
       try {
           fileNum=Integer.parseInt(str[0]);
           System.out.println("fileNum = " + fileNum);
       }catch (NumberFormatException ex){
           ex.printStackTrace();
       }
        return fileNum;
    }

    public int getDisplayedFolderNumber() {
        //navigateTo("files");
        scrollDown();
        int folderNum=0;
       String [] str=folderDisAmount.getText().split(" ");
        try {
            folderNum= Integer.parseInt(str[0]);
            System.out.println("folderNum = " + folderNum);
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return folderNum;
    }

    public void moveToBack( String item) {
        int i=0;
        for (WebElement file:filesList) {
            i++;
            if (item.equals(file.getAttribute("data-file"))) {
                Driver.get().findElement(By.xpath("(//a[@class='action action-menu permanent'])"+"["+i+"]")).click();
                BrowserUtils.waitFor(2);
                moveOrCopy.click();
                BrowserUtils.waitFor(1);
                homeFolderIcon.click();
                moveButton.click();

            }
        }

    }
    public String isInFolder(String item, String folder) {
        openItem(folder);
        scrollDown();
        for (WebElement file: filesList) {
            if (item.equals(file.getAttribute("data-file"))){
                return file.getAttribute("data-file");
            }
        }
       return null;
    }

    public boolean isInMainFileList(String item) {
        for (WebElement file:filesList) {
            if (item.equals(file.getAttribute("data-file"))){
                return  true;
            }
        }
        return  false;
    }



}
