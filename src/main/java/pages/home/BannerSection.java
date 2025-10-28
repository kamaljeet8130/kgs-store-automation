package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BannerSection {
    private final WebDriver driver ;
    private final WebDriverWait wait;

    private final By bannerSlides = By.xpath("(//div[contains(@class,'mySwiper')])[1]//div[contains(@class,'swiper-slide')]");
    private final By activeBanner = By.xpath("//div[contains(@class,'swiper-slide-active')]");
    private final By bannerImages = By.xpath("//div[@data-testid='banner-slider']//img[@alt='banner-image']");
    private final By bannerImageLink = By.xpath("//div[@data-testid='banner-slider']//a[img[@alt='banner-image']]");
    private final By bannerLinks = By.xpath("//div[contains(@class,'swiper-slide')]//a");
    private final By paginationBullets = By.xpath("//div[contains(@class,'swiper-pagination')]//span");
    private final By rightBannerArrowSlider = By.xpath("(//div[@data-testid='banner-slider']//*[name()='svg'])[1]");
    private final By leftBannerArrowSlider = By.xpath("(//div[@data-testid='banner-slider']//*[name()='svg'])[2]");
    public BannerSection(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public int getBannerCount() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bannerSlides));
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
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bannerSlides));
        return driver.findElements(bannerImages).stream().allMatch(WebElement::isDisplayed);
    }
    public List<String> getAllBannerImageSrc(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bannerImages));
        List<String> imageSrc = new ArrayList<>();
        for(WebElement element:driver.findElements(bannerImages)){
            imageSrc.add(element.getAttribute("href"));
        }
        return imageSrc;
    }
    public List<String> getAllBannerRedirectUrls(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bannerImageLink));
        List<String> bannerImageLinks = new ArrayList<>();
        for(WebElement element: driver.findElements(bannerImageLink)){
            bannerImageLinks.add(element.getAttribute("href"));
        }
        return bannerImageLinks;
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
    public void clickRightBannerArrowSlider(){
        driver.findElement(rightBannerArrowSlider).click();
    }
    public void clickLeftBannerArrowSlider(){
        driver.findElement(leftBannerArrowSlider).click();
    }
    public int getActiveBannerIndex(){
        for (int i =0;i<getBannerCount();i++){
            if(driver.findElements(bannerSlides).get(i).getAttribute("class").contains("swiper-slide-active")){
                return i;
            }
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
