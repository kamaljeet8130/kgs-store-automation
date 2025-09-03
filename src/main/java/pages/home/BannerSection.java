package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BannerSection {
    private  WebDriver driver ;

    private final By bannerSlides = By.xpath("(//div[contains(@class,'mySwiper')])[1]//div[contains(@class,'swiper-slide')]");
    private final By activeBanner = By.xpath("//div[contains(@class,'swiper-slide-active')]");
    private final By bannerImages = By.xpath("//div[contains(@class,'swiper-slide')]//img");
    private final By bannerLinks = By.xpath("//div[contains(@class,'swiper-slide')]//a");
    private final By paginationBullets = By.xpath("//div[contains(@class,'swiper-pagination')]//span");

    public BannerSection(WebDriver driver){
        this.driver = driver;
    }

    public int getBannerCount() {
        return driver.findElements(bannerSlides).size();
    }
    public boolean isActiveBannerDisplayed(){
        return  driver.findElement(activeBanner).isDisplayed();
    }
    public void clickBannerByIndex(int index){
        driver.findElements(bannerSlides).get(index).click();
    }
    public int getBulletCount(){
        return driver.findElements(paginationBullets).size();
    }
    public void clickBulletByIndex(int index){
        driver.findElements(paginationBullets).get(index).click();
    }
    public boolean areAllBannerImageDisplayed(){
        return driver.findElements(bannerImages).stream().allMatch(WebElement::isDisplayed);
    }
    public String getBannerImageSrcByIndex(int index){
        return driver.findElements(bannerImages).get(index).getAttribute("src");
    }
    public String getBannerLinkByIndex(int index){
        return driver.findElements(bannerLinks).get(index).getAttribute("href");
    }
    public void clickBannerLinkByIndex(int index){
        driver.findElements(bannerLinks).get(index).click();
    }
    public int getActiveBannerIndex(){
        for (int i =0;i<getBannerCount();i++){
            if(driver.findElements(bannerSlides).get(i).getAttribute("class").contains("swiper-slide-active"));
            return i;
        }
        return -1;
    }
    public void waitForBannerChanges(int oldIndex){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d->getActiveBannerIndex()!=oldIndex);
    }
    public boolean areAllBannerLinksPresent(){
        return driver.findElements(bannerLinks).stream().allMatch(e->e.getAttribute("href")!=null);
    }
}
