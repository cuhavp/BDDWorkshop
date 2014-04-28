package pages;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.BaseSteps;

/**
 * Created with IntelliJ IDEA.
 * User: Sukeshk
 * Date: 02/04/14
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "searchTerm")
    private WebElement searchBox;

    @FindBy(id = "searchMagnify")
    private WebElement searchButton;

    @FindBy(linkText = "sign in")
    private WebElement signinLink;

    @FindBy(id = "email-address")
    private WebElement emailOverlayTextBox;

    @FindBy(id = "logonOverlayPassword")
    private WebElement passwordOverlayTextBox;

    @FindBy(id = "ButtonPopupLogin")
    private WebElement signInButton;

    @FindBy(id = "mini-cart-icon")
    private WebElement cartIcon;


    public void searchFor(String itemName) {
        searchBox.clear();
        searchBox.sendKeys(itemName);
        searchButton.click();
    }

    public void loginToWebsiteWith(String userName, String password) {
        signinLink.click();
        emailOverlayTextBox.sendKeys(userName);
        passwordOverlayTextBox.sendKeys(password);
        signInButton.click();
    }

    public void goToShoppingCart() {
        cartIcon.click();
    }

    public int getOrderQuantity() {
        return Integer.parseInt(driver.findElement(By.cssSelector("a[id='mini-cart-icon'] span.count")).getText());
    }


}
