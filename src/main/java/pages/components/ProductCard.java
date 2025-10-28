package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Executable;
import java.util.List;

public class ProductCard {
   private final WebElement rootElement;
   private final WebDriver driver;
   public ProductCard(WebDriver driver,WebElement rootElement){
       this.rootElement =rootElement;
       this.driver = driver;
   }
   private final By productName =By.xpath(".//div[contains(@data-testid,'book-title')]");
   private final By productImage = By.xpath(".//div[contains(@data-testid,'product-image')]/img");
   private final By productRating = By.xpath(".//div[contains(@data-testid,'book-rating')]");
   private final By oldPrice = By.xpath(".//p[contains(@data-testid,'actual-price')]");
   private final By currentPrice = By.xpath(".//p[contains(@data-testid,'discounted-price')]");
   private final By savedPrice = By.xpath(".//p[contains(@data-testid,'save-price')]");
   private final By wishlistIcon = By.xpath(".//div[contains(@data-testid,'wishlist-icon')]");
   private final By addToCartIcon = By.xpath(".//div[contains(@data-testid,'add-to-cart')]");
   private final By viewDetailButton = By.xpath(".//div[contains(@data-testid,'view-detail-button')]");
   private final By productLink = By.xpath(".//div[@data-testid='product-card']/ancestor::a");
   private void hoverOnCard(){
       Actions actions = new Actions(driver);
       actions.moveToElement(rootElement).perform();
   }
   public String getName(){
       return rootElement.findElement(productName).getText().trim();
   }
   public String getImageUrl(){
       return rootElement.findElement(productImage).getAttribute("src");
   }
   public String getOldPrice(){
       try {
           return rootElement.findElement(oldPrice).getText().trim();
       }catch (Exception e){
           return "";
       }
   }
   public String getCurrentPrice(){
       try{
           return rootElement.findElement(currentPrice).getText().trim();
       }catch (Exception e){
           return "";
       }
   }
   public String getSavedPrice(){
       try {
           return rootElement.findElement(savedPrice).getText().trim();
       }catch (Exception e){
           return "";
       }
   }
   public int getProductRating(){
       try {
           WebElement ratingDiv = rootElement.findElement(productRating);
           List<WebElement> svgs = ratingDiv.findElements(By.xpath(".//*[name()='svg']"));
           return svgs.size();
       }catch (Exception e){
           return -1;
       }
   }
   public void clickAddToCartIcon(){
       hoverOnCard();
       rootElement.findElement(addToCartIcon).click();
   }
   public void clickWishlistIcon(){
       hoverOnCard();
       rootElement.findElement(wishlistIcon).click();
   }
   public void clickViewDetailsButton(){
       hoverOnCard();
       rootElement.findElement(viewDetailButton).click();
   }
    public String getProductLink(){
       return driver.findElement(productLink).getAttribute("href");
    }
   @Override
    public String toString(){
       return "productCard{" +
               "name=" + getName() + "\"" +
               ", price= " + getCurrentPrice() + "\"" +
               ", old price= " + getOldPrice()+ "\"" +
               ", discount=" + getSavedPrice()+ "\"" +
               ", Product URL=" + getProductLink()+ "\""+
               "}";
   }

}
