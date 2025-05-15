import Utils.PersistentObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
     public WebDriver driver;
    private Scenario scenario;

    @Before
     public void setup(Scenario scenario){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.get("https://car-checking.com//");
        PersistentObject.setDriver(driver);
    }

    @After
    public void after(){

       driver.quit();
    }
}
