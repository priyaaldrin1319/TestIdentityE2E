package Pages;

import Utils.PersistentObject;
import Utils.ReadFile;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.PersistentObject.driver;

public class CarRegDetail {
    ReadFile readFile = new ReadFile();
    public WebElement carregTxt;
    public WebElement checknowBtn;
    public WebElement carMakeEle;
    public WebElement carModelEle;
    public WebElement carHomePage;

    public WebElement carYearofmanufactureEle;
    public List<WebElement>carAlert,carAlert2;


    public CarRegDetail() {
        PersistentObject.setDriver(driver);
    }

    public Map<String, Map<String, String>> carreg() throws IOException {
        Map<String, Map<String, String>> actualcarDataMap = new HashMap<>();

        Map<String, String> actualDetails = new HashMap<>();

        List<String> carreg = readFile.readcarregFile();
        List<String> invalidRegDet=new ArrayList<>();
        System.out.println(carreg);
        WebDriverWait wait = new WebDriverWait(driver, 60);

        for(String carListItems:carreg) {
            try {
                carregTxt = driver.findElement(By.xpath("//div[@class='inputgroup kenteken-input-holder']//input[@type='text']"));
                checknowBtn = driver.findElement(By.xpath("//form/div[2]/button[@type='submit']"));
                wait.until(ExpectedConditions.visibilityOf(carregTxt));
                carregTxt.clear();
                carregTxt.sendKeys(carListItems);
                //carregTxt.sendKeys(carreg.get(0));
                checknowBtn.click();
                carAlert = driver.findElements(By.xpath("//div[contains(text(),'not recognised')]"));
                carAlert2 = driver.findElements(By.xpath("//body[@class='antialiased']//div[contains(@class,'text-gray-500')]"));
                if (!carAlert.isEmpty() || !carAlert2.isEmpty()) {
                    System.out.println("Invalid Reg: " + carListItems);
                    invalidRegDet.add(carListItems);
                    continue;
                }

                carMakeEle = driver.findElement(By.xpath("//table[@class='table table-responsive']//tbody/tr[1]/td[2]"));
                carModelEle = driver.findElement(By.xpath("//table[@class='table table-responsive']//tbody/tr[2]/td[2]"));
                carYearofmanufactureEle = driver.findElement(By.xpath("//table[@class='table table-responsive']//tbody/tr[4]/td[2]"));
                carHomePage = driver.findElement(By.xpath("//div[text()='HOME']"));
                actualDetails.put("Make", carMakeEle.getText());
                actualDetails.put("Model", carModelEle.getText());
                actualDetails.put("Year", carYearofmanufactureEle.getText());
                actualcarDataMap.put(carreg.get(0), actualDetails);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, -500);");
                carHomePage.click();
                String carMake = carMakeEle.getText();
                String carModel = carModelEle.getText();
                String carYear = carYearofmanufactureEle.getText();
                System.out.println(carMake + " " + carModel + " " + carYear);
            } catch (StaleElementReferenceException se){
                System.out.println(se);
            }
        }
        return actualcarDataMap;
    }
}























   /* public void getcarreg() throws IOException {
        Map<String, Map<String, String>> carMap = readFile.readcarregOutputFile();

        // sysout for verifying
        for (Map.Entry<String, Map<String, String>> entry : carMap.entrySet()) {
            String reg = entry.getKey();
            Map<String, String> details = entry.getValue();
            System.out.println("Reg: " + reg + " -> " + details);
        }

        Map<String, String> expectedDetails = carMap.get("AD58 VNF");
        System.out.println(expectedDetails);

    }
*/


