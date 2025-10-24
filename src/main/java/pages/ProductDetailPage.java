package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductDetailPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private By productTitle = By.xpath("//h2[@data-testid=\"product-heading\"]");
    private By wishlistIcon = By.xpath("//div[@data-testid=\"wishlist-icon\"]");
    private By productShortDescription = By.xpath("//p[@data-testid=\"product-short-desc\"]");
    private By kgsPatent = By.xpath("//p[@data-testid=\"kgs\"]");
    private By finalPrice = By.xpath("//div[@data-testid=\"product-detail\"]//div[@data-testid=\"discounted-price\"]/p[1]");
    private By actualPrice = By.xpath("//div[@data-testid=\"product-detail\"]//p[@data-testid=\"actual-price\"]");
    private By quantitySection = By.xpath("//div[@data-testid='product-quantity']");
    private By increaseButton = By.xpath("//div[@data-testid='product-quantity']//span[@aria-label='Increase Value']");
    private By decreaseButton = By.xpath("//div[@data-testid='product-quantity']//span[@aria-label='Decrease Value']");
    private By quantityInput = By.xpath("//div[@data-testid='product-quantity']//input[@class='ant-input-number-input']");
    private By inStockBadge  = By.xpath("//div[@data-testid=\"product-detail\"]//div[@data-testid='in-stock']");
    private By outOfStockBadge = By.xpath("//div[@data-testid=\"product-detail\"]//div[@data-testid='out-of-stock']");
    private By cartButtonsSection = By.xpath("//div[@data-testid='cart-buttons']");
    private By buyNowButton = By.xpath("//div[@data-testid='cart-buttons']//button[contains(., 'Buy Now')]");
    private By addToCartButton = By.xpath("//div[@data-testid='cart-buttons']//button[contains(., 'Add to Cart')]");
    private By outOfStockButton = By.xpath("//button[contains(., 'Out of Stock')]");
    private By socialMediaIcons = By.xpath("//div[@data-testid='social-media-icons']//button");



    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public String getProductTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }
    public String getProductShortDescriptions(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productShortDescription)).getText();
    }
    public String getActualPrice(){
        return driver.findElement(actualPrice).getText();
    }
    public String getFinalPrice(){
        return driver.findElement(finalPrice).getText();
    }
    public String getQuantityValue(){
        return driver.findElement(quantityInput).getAttribute("value");
    }
    public void clickIncreaseQuantity(){
        WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(increaseButton));
        actions.moveToElement(plus).click().perform();
    }
    public void clickDecreaseQuantity(){
        WebElement minus = driver.findElement(decreaseButton);
        if(minus.isEnabled()){
            actions.moveToElement(minus).click().perform();
        }
    }
    public void setQuantityInput(int quantity){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        input.clear();
        input.sendKeys(String.valueOf(quantity));
    }
    public boolean isInStock(){
        return !driver.findElements(inStockBadge).isEmpty();
    }
    public boolean isOutOfStock(){
        return !driver.findElements(outOfStockBadge).isEmpty();
    }
    public boolean isAddToCartVisible(){
        return !driver.findElements(addToCartButton).isEmpty() && driver.findElement(addToCartButton).isDisplayed();
    }
    public boolean isBuyNowVisible(){
        return !driver.findElements(buyNowButton).isEmpty() && driver.findElement(buyNowButton).isDisplayed();
    }
    public boolean isOutOfStockButtonVisible(){
        return !driver.findElements(outOfStockButton).isEmpty();
    }
    public List<WebElement> getSocialMediaIcons(){
       return driver.findElements(socialMediaIcons);
    }
    public boolean areSocialMediaIconsVisible(){
        List<WebElement> icons = driver.findElements(socialMediaIcons);
        return !icons.isEmpty() && icons.stream().allMatch(WebElement::isDisplayed);
    }
    public int getSocialMediaIconCount(){
        return driver.findElements(socialMediaIcons).size();
    }

}
