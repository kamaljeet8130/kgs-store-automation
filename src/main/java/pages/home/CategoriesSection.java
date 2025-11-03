package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScrollUtil;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CategoriesSection {
    private WebDriver driver;
    private WebDriverWait wait;

    public CategoriesSection(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //locators:
    private By categorySlideItems = By.xpath("(//div[contains(@class,'mySwiper')])[2]//div[contains(@class,'swiper-slide')]");
    private By activeCategory = By.xpath("(//div[contains(@class,'mySwiper')])[2]//div[contains(@class,'swiper-slide-active')]");
    private By leftArrow= By.xpath("(//h1[text()='Browse By Categories']/following-sibling::div//*[name()='svg'])[1]");
    private By rightArrow= By.xpath("(//h1[text()='Browse By Categories']/following-sibling::div//*[name()='svg'])[2]");
    private By viewAll = By.xpath("//h1[text()='Browse By Categories']/ancestor::div[contains(@class,'relative')]//a[@href='categories']");
    private By categoryName = By.xpath("//div[@data-testid='categories-slider']//div[@data-testid='category-card']//p");
    private By categoryCard = By.xpath("//div[@data-testid='category-card']");
    private By categoriesSlider = By.xpath("//div[@data-testid='categories-slider']");

    public void scrollToCategorySection(){
        ScrollUtil scrollUtil = new ScrollUtil(driver);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(categoriesSlider));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSlider));
        scrollUtil.scrollToElement(driver.findElement(categoriesSlider));
    }
    public int getCategoriesCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSlider));
              return driver.findElements(categorySlideItems).size();
    }
    public String getActiveCategoryName(){
        return driver.findElement(activeCategory).getText();
    }
    public void clickRightArrow(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSlider));
        wait.until(ExpectedConditions.elementToBeClickable(rightArrow));
        driver.findElement(rightArrow).click();
    }
    public void clickLeftArrow(){
        driver.findElement(leftArrow).click();
    }
    public void clickViewAll(){
        driver.findElement(viewAll).click();
    }
    public Set<String> getAllCategoriesName(){
        List<WebElement> elements = driver.findElements(categoryName);
        Set<String> name = new LinkedHashSet<>();
        for(WebElement element : elements){
            name.add(element.getText());
        }
        return name;
    }
    public String getCategoryNameByIndex(int index){
        List<WebElement> elements = driver.findElements(categoryName);
        return elements.get(index).getText();
    }
    public void clickCategoryByName(String name){
     List<WebElement> elements = driver.findElements(categoryName);
     for (WebElement element:elements){
         if(element.getText().equalsIgnoreCase(name)){
             element.click();
             return;
         }
     }
     throw new RuntimeException("Category not found : " + name);
    }
    public void clickCategoryByIndex(int index){
        List<WebElement> elements = driver.findElements(categoryName);
        elements.get(index).click();
        if(index <0 || index>=elements.size()){
            throw new IllegalArgumentException("Invalid Category Index : " + index);
        }
    }
    public boolean isCategoryVisible(String name){
        return getAllCategoriesName().contains(name);
    }
    public boolean hasExpectedCategoryCount(int expectedCount){
        return getCategoriesCount()==expectedCount;
    }
    public void clickCategoryCard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryCard)).click();
    }
}
