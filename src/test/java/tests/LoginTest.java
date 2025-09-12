package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardLoginPage;
import pages.components.ProductCard;
import pages.home.BannerSection;
import pages.home.HeaderSection;
import pages.home.ProductListingSection;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest{
    @Test
    public void testUserLogin() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(" //div[contains(@data-testid,'product-section')]//h1[normalize-space()='Trending Products']/ancestor::div[contains(@data-testid,'product-section')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

        ProductListingSection productListingSection = new ProductListingSection(driver);
       List<ProductCard> trendingProducts =
        productListingSection.getProductCards("Trending Products");
        System.out.println(trendingProducts.size());
        for (ProductCard card : trendingProducts){
            System.out.println(card.toString());
        }
    }
}