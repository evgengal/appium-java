package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * Created by evgeniy.galkin on 03.04.2017.
 */
public class Utils {

    protected WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void tapOnCenterOfMap() {
        Dimension dimensions = driver.manage().window().getSize();
        int screenWidth = dimensions.getWidth() / 2;
        int screenHeight = dimensions.getHeight() / 2;
        System.out.println("Coordinates of arrow in the center of the screen : " + screenWidth + " and " + screenHeight);
        singleTap(screenWidth, screenHeight);
    }


    private void singleTap(double x, double y) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", x);
        tapObject.put("y", y);
        js.executeScript("mobile: tap", tapObject);
    }

}
