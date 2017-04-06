package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by evgeniy.galkin on 03.04.2017.
 */
public class MainPage extends Utils {

    private By mapSurfaceView = By.id("com.mapswithme.maps.pro:id/map_surfaceview");
    private By menu_frame_btn_search = By.id("com.mapswithme.maps.pro:id/search");
    private By menu_frame_btn_p2p = By.id("com.mapswithme.maps.pro:id/p2p");
    private By menu_frame_btn_bookmarks = By.id("com.mapswithme.maps.pro:id/bookmarks");
    private By menu_frame_btn_menu = By.id("com.mapswithme.maps.pro:id/menu");

    private By navigation_buttons_btn_my_position = By.id("com.mapswithme.maps.pro:id/my_position");

    private By place_preview = By.id("com.mapswithme.maps.pro:id/pp__preview");
    private By my_coordinates = By.id("com.mapswithme.maps.pro:id/tv__place_latlon");

    private By view_on_map = By.id("com.mapswithme.maps.pro:id/show_on_map");





    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage test001TestMyLocation() throws InterruptedException {
        //Check my_position button is displayed
        waitForVisibilityOf(navigation_buttons_btn_my_position);
        assertThat(driver.findElement(navigation_buttons_btn_my_position).isDisplayed(), is(true));

        //Click my_position button
        driver.findElement(navigation_buttons_btn_my_position).click();

        //Tap on the arrow in the center of the screen
        tapOnCenterOfMap();

        //Check that my location was found and save my gps and tap back
        assertThat(driver.findElement(place_preview).isDisplayed(), is(true));
        driver.findElement(place_preview).click();
        String myGPS = driver.findElement(my_coordinates).getText();
        System.out.println("My coordinates is : " + myGPS);

        return new MainPage(driver);
    }

    public MainPage test002TestSearchFood() throws InterruptedException {

        //Tap search button
        assertThat(driver.findElement(menu_frame_btn_search).isDisplayed(), is(true));
        driver.findElement(menu_frame_btn_search).click();
        //Tap Categories button
        driver.findElement(By.name("Categories")).click();
        //Tap Categories Food
        driver.findElement(By.name("Food")).click();

        return new MainPage(driver);
    }

    public MainPage test003TestSearchResults() throws InterruptedException {

        //Check my_position button is displayed
        waitForVisibilityOf(view_on_map);
        assertThat(driver.findElement(view_on_map).isDisplayed(), is(true));

        /*assertThat(driver.findElement(menu_frame_btn_p2p).isDisplayed(), is(true));
        assertThat(driver.findElement(menu_frame_btn_bookmarks).isDisplayed(), is(true));
        assertThat(driver.findElement(menu_frame_btn_menu).isDisplayed(), is(true));
        assertThat(driver.findElement(menu_frame_btn_search).isDisplayed(), is(true));*/

        Thread.sleep(3000);
        return new MainPage(driver);
    }
}
