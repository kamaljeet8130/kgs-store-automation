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
        ProductListingSection productListingSection = new ProductListingSection(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<String> titles = productListingSection.getAllSectionTitles();

        if(!titles.isEmpty()){
            List<ProductCard> cards = productListingSection.getProductCards(titles.get(0));
            for (ProductCard card: cards){
                System.out.println(card.getName());
            }
        }
    }
}