import org.openqa.selenium.WebDriver;

public class PersistentObject {

    public static WebDriver driver;


    public  WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        PersistentObject.driver = driver;
    }

}
