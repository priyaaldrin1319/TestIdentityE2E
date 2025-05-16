package Stepdefinitions;

import Pages.CarRegDetail;
import Utils.ReadFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.DataTable;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.util.Map;

public class CarRegStepDefinition {


    CarRegDetail crd = new CarRegDetail();
    ReadFile rf = new ReadFile();

    Map<String, Map<String, String>> actualDetails, expectedDetails;
    Map<String, String> inputfileName;

    @Given("User launch carreg and read the input file {string}")
    public void user_launch_url_of(String fileName) throws IOException {
        actualDetails = crd.carreg(fileName);
    }

    @Then("User get the car details from the output file {string}")
    public void user_verify_the_car_details_matching(String outputFileName) throws IOException {
        expectedDetails = rf.readcarregOutputFile(outputFileName);
    }

    @And("User verify car details matching")
    public void user_verify_car_details_matching() {

        for (String regNo : actualDetails.keySet()) {
            System.out.println("From Input file: " + actualDetails.get(regNo).get("Make") + " : " + actualDetails.get(regNo).get("Model") + " : " + actualDetails.get(regNo).get("Year"));
            System.out.println("From Output file: " + expectedDetails.get(regNo).get("Make") + " : " + expectedDetails.get(regNo).get("Model") + " : " + expectedDetails.get(regNo).get("Year"));
            SoftAssert softassert = new SoftAssert();
            softassert.assertEquals(actualDetails.get(regNo).get("Make"), expectedDetails.get(regNo).get("Make"));
            softassert.assertEquals(actualDetails.get(regNo).get("Model"), expectedDetails.get(regNo).get("Model"));
            softassert.assertEquals(actualDetails.get(regNo).get("Year"), expectedDetails.get(regNo).get("Year"));
            softassert.assertAll();
        }
    }

}
