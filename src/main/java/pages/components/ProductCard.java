package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Executable;
import java.util.List;

public class ProductCard {
   private WebElement rootElement;
   private WebDriver driver;
   private By rootLocator;

   public ProductCard(WebElement rootElement){
       this.rootElement =rootElement;
   }
   public ProductCard(WebDriver driver,By rootLocator){
       this.driver=driver;
       this.rootLocator = rootLocator;
   }
   private By productName =By.xpath(".//div[contains(@data-testid,'book-title')]");
   private By productImage = By.xpath(".//div[contains(@data-testid,'product-image')]/img");
   private By productRating = By.xpath(".//div[contains(@data-testid,'book-rating')]");
   private By oldPrice = By.xpath(".//p[cotains(@data-testid,'actualPrice')]");
   private By currentPrice = By.xpath(".//p[contains(@data-testid,'discounted-price')]");
   private By savedPrice = By.xpath(".//p[contains(@data-testid,'save-price')]");
   private By wishlistIcon = By.xpath(".//div[contains(@data-testid,'wishlist-icon')]");
   private By addToCartIcon = By.xpath(".//div[contains(@data-testid,'add-to-cart')]");
   private By viewDetailButton = By.xpath(".//div[contains(@data-testid,'view-detail-button')]");

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
       rootElement.findElement(addToCartIcon).click();
   }
   public void clickWishlistIcon(){
       rootElement.findElement(wishlistIcon).click();
   }
   public void clickViewDetailsButton(){
       rootElement.findElement(viewDetailButton).click();
   }
   @Override
    public String toString(){
       return "productCard{" +
               "name=" + getName() + "\"" +
               ", price= " + getCurrentPrice() + "\"" +
               ", old price= " + getOldPrice()+ "\"" +
               ", discout=" + getSavedPrice()+ "\"" +
               "}";
   }


}
