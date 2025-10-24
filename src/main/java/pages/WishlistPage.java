package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.ProductCard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WishlistPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public WishlistPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    private By wishlistTitle = By.xpath("//h2[contains(text(),'My Wishlist')]");
    private By wishlistProductCard = By.xpath("//div[@data-testid='product-card']");
    private By emptyWishlistImage = By.xpath("//div/img[contains(@alt,'wishlist')]");
    private By emptyWishlistMessage = By.xpath("//div/h2[contains(text(),'No Favorites')]");
    private By emptyWishlistText = By.xpath("//div/p[contains(., 'nothing on your list yet')]");

    public boolean isWishlistPageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistTitle)).isDisplayed();
    }
    public boolean isEmptyWishlistVisible(){
        return  driver.findElement(emptyWishlistImage).isDisplayed() && driver.findElement(emptyWishlistText).isDisplayed();
    }
    public List<ProductCard> getAllWishlistProductCard(){
        List<WebElement> productElements = driver.findElements(wishlistProductCard);
        List<ProductCard> cards = new ArrayList<>();
        for(WebElement element: productElements){
            cards.add(new ProductCard(element));
        }
        return cards;
    }
    public int getWishlistProductsCount(){
        return driver.findElements(wishlistProductCard).size();
    }
    public ProductCard getFirstProduct(){
        List<ProductCard> cards = getAllWishlistProductCard();
        return cards.isEmpty()?null:cards.getFirst();
    }



}
