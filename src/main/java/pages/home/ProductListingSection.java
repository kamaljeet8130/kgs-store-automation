package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductListingSection {
    private WebDriver driver;

    public ProductListingSection(WebDriver driver) {
        this.driver = driver;
    }

    private final By productName = By.xpath("//div[contains(@data-testid,'product-section')]//h1");

    public List<String> getProductName() {
        List<String> nameList = new ArrayList<>();
        for (WebElement element : driver.findElements(productName)) {
            nameList.add(element.getText());
        }
        return nameList;
    }
}
