package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderSection {
    private WebDriver driver;

    //Locators :
    private final By KgsLogo  = By.xpath("//a[@href=\"/\" and .//img[@alt=\"KGS Store\"]]");
    private final By searchBox = By.xpath("//input[@aria-label='Search' and @type='text']");
    private final By shop = By.xpath("//a[@href=\"/shop\"]");
    private final By myWishlist = By.xpath("//a[@href=\"/my-wishlist\"]");
    private final By myCart = By.xpath("//a[@href=\"/cart\"]");


    public HeaderSection(WebDriver driver){
        this.driver=driver;
    }
    public void clickKgsLogo(){
        driver.findElement(KgsLogo).click();
    }
    public void clickSearchBox(){
        driver.findElement(searchBox).sendKeys("Hello world");
    }
    public void clickShopIcon(){
        driver.findElement(shop).click();
    }
    public void clickMyWishlist(){
        driver.findElement(myWishlist).click();
    }
    public void clickMyCart(){
        driver.findElement(myCart).click();
    }
}

