package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardLoginPage;
import pages.home.BannerSection;
import pages.home.HeaderSection;
import pages.home.ProductListingSection;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest{
    @Test
    public void testUserLogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ProductListingSection productListingSection = new ProductListingSection(driver);
        for (String elements : productListingSection.getProductName()) {
            System.out.println(elements);

        }

    }
}