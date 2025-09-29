package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.ProductCard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductListingSection {
    private WebDriver driver;

    public ProductListingSection(WebDriver driver) {
        this.driver = driver;
    }

    private By allSections = By.xpath("//div[contains(@data-testid,'product-section')]");
    private By sectionTitles = By.xpath(".//h1");
    private By productCards = By.xpath(".//div[@data-testid='product-card']");
    private By viewAllLink = By.xpath(".//div/a[text()='View All']");

    public List<String> getAllSectionTitles() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> sections = driver.findElements(allSections);
        List<String> titles = new ArrayList<>();
        for (WebElement section : sections) {
            try {
                WebElement header = wait.until(
                        ExpectedConditions.presenceOfNestedElementLocatedBy(section,sectionTitles)
                );
                titles.add(header.getText().trim());
            } catch (Exception e) {
                titles.add("UNKNOWN");
            }
        }
        return titles;
    }

    private WebElement getSectionByTitle(String sectionTitle) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String path = "//h1[normalize-space()='" + sectionTitle + "']/ancestor::div[contains(@data-testid,'product-section')]";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
//        return driver.findElement(By.xpath(path));
    }
    private  WebElement getLeftArrow(String sectionTitle){
        String path = "(//h1[normalize-space()='" + sectionTitle + "']/ancestor::div[contains(@data-testid,'product-section')]//*[name()='svg' and contains(@class,'svgArrowColor')])[1]";
        return driver.findElement(By.xpath(path));
    }
    private  WebElement getRightArrow(String sectionTitle){
        String path = "(//h1[normalize-space()='" + sectionTitle + "']/ancestor::div[contains(@data-testid,'product-section')]//*[name()='svg' and contains(@class,'svgArrowColor')])[2]";
        return driver.findElement(By.xpath(path));
    }

    public List<ProductCard> getProductCards(String sectionTitle) {
        WebElement section = getSectionByTitle(sectionTitle);
        List<WebElement> cardElements = section.findElements(productCards);
        List<ProductCard> cards = new ArrayList<>();
        for (WebElement element : cardElements) {
            cards.add(new ProductCard(element));
        }
        return cards;
    }

    public void clickOnViewAll(String sectionTitle){
        WebElement section = getSectionByTitle(sectionTitle);
        section.findElement(viewAllLink).click();
    }
    public int getProductCount(String sectionTitle){
        return getProductCards(sectionTitle).size();
    }
    public ProductCard getFirstProductCard(String sectionTitle){
        List<ProductCard> cards = getProductCards(sectionTitle);
        return cards.isEmpty()?null:cards.getFirst();
    }

    public void clickOnLeftArrow(String sectionTitle){
        getLeftArrow(sectionTitle).click();
    }

    public void clickOnRightArrow(String sectionTitle){
        getRightArrow(sectionTitle).click();
    }
}
