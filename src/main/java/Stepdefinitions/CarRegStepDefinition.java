package Stepdefinitions;

import Pages.CarRegDetail;
import Utils.ReadFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class CarRegStepDefinition {


    CarRegDetail crd=new CarRegDetail();
    ReadFile rf=new ReadFile();

    Map<String, Map<String, String>> actualDetails,expectedDetails;
    @Given("User launch carregno in {string}")
    public void user_launch_url_of(String string) throws IOException {
    actualDetails =crd.carreg();
        //   crd.getcarreg();
      //  Map<String, Map<String, String>> expectedDetails = rf.readcarregOutputFile();
     //   Map<String, String> expectedDetails = carMap.get(reg);

    }

    @Then("User get the car details")
    public void user_verify_the_car_details_matching() throws IOException {
         expectedDetails = rf.readcarregOutputFile();
    }

    @And("User verify car details matching")
    public void user_verify_car_details_matching() {

        for (String regNo : actualDetails.keySet()){
            System.out.println(actualDetails.get(regNo).get("Make") + " : " + actualDetails.get(regNo).get("Model")+" : " +actualDetails.get(regNo).get("Year"));
            System.out.println(expectedDetails.get(regNo).get("Make") + " : " +  expectedDetails.get(regNo).get("Model") + " : " +expectedDetails.get(regNo).get("Year"));
        Assert.assertEquals(actualDetails.get(regNo).get("Make"),expectedDetails.get(regNo).get("Make"));
        Assert.assertEquals(actualDetails.get(regNo).get("Model"), expectedDetails.get(regNo).get("Model"));
        Assert.assertEquals(actualDetails.get(regNo).get("Year"), expectedDetails.get(regNo).get("Year"));
    }}

}
