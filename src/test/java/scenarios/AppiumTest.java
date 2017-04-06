package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * Created by evgeniy.galkin on 03.04.2017.
 */
public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void myMapsMeTest() throws InterruptedException {
        new MainPage(driver).test001TestMyLocation();
        //Tap back button
        driver.navigate().back();
        new MainPage(driver).test002TestSearchFood();
        new MainPage(driver).test003TestSearchResults();
    }

}
