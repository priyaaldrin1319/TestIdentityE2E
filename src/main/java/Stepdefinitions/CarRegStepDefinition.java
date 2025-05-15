import Pages.CarRegDetail;
import io.cucumber.java.en.Given;

public class CarRegStepDefinition {


    CarRegDetail crd=new CarRegDetail();

    @Given("User launch url of {string}")
    public void user_launch_url_of(String string) {

        crd.carreg();

    }
}
