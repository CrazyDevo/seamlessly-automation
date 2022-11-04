package net.seamlessly.stepdefinitions;

import io.cucumber.java.en.*;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.Driver;
import net.seamlessly.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class LoginWithExcelStepDefs {

    /**
     * @DataProvider
     *         public Object[][] data(){
     *             String projectPath=System.getProperty("user.dir");
     *             String filePath=projectPath+"/src/test/resources/Spartan.xlsx";
     *             System.out.println(filePath);
     *             ExcelUtil excelUtil=new ExcelUtil(filePath,"spartans");
     *             String[][] dataArray = excelUtil.getDataArrayWithoutFirstRow();
     *
     *
     *             System.out.println("Array "+Arrays.deepToString(dataArray));
     *             return dataArray;
     *
     *         }
     * @param path
     */



    @When("the user enters the home page by using valid credentials {string}")
    public void the_user_enters_the_home_page_by_using_valid_credentials(String path) {
        String projectPath=System.getProperty("user.dir");
             String filePath=projectPath+"/"+path;
        System.out.println("filePath = " + filePath);
      ExcelUtil  excelUtil=new ExcelUtil(filePath,"Sheet 1");
        List<Map<String, String>> dataList = excelUtil.getDataList();
        System.out.println("dataList = " + dataList);

        for (Map<String, String> stringStringMap : dataList) {
            new LoginPage().login(stringStringMap.get("Username"),stringStringMap.get("Password"));
            new LoginStepDefs().the_user_should_see_the_url("http://qa.seamlessly.net/index.php/apps/files/");
            Driver.closeDriver();
           new LoginStepDefs().the_user_on_the_login_page();

        }



    }




}
