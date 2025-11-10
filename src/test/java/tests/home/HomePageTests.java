package tests.home;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.home.BannerSection;
import pages.home.CategoriesSection;
import pages.home.HomePage;
import utils.ScrollUtil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePageTests extends BaseTest {

    @Test(description = "Verify that home page loaded successfully or not")
    public void verifyHomePageLoadedSuccessfully() {
        HomePage home = new HomePage(driver);
        String currentUrl = home.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("store.kgs.ink"), "Home page Url Mismatch, Actual Url " + currentUrl);
        Reporter.log("✅ Store Url Loaded Successfully", true);
        Reporter.log("Store Url : " + currentUrl, true);
    }

    @Test(description = "Verify at least one banner is displayed on the homepage")
    public void verifyBannerCountIsPositive() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int bannerCount = banner.getBannerCount();
        Assert.assertTrue(bannerCount > 0, "No banner is Displayed on Home Page!" + bannerCount);
        Reporter.log("✅ Slider Banner Displayed Successfully", true);
        Reporter.log("Slider Banner Count : " + bannerCount, true);
    }

    @Test(description = "Verify all banner images are displayed on the homepage!")
    public void verifyAllBannerImagesAreDisplayed() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        SoftAssert softAssert = new SoftAssert();
        boolean isBannerImageDisplayed = banner.areAllBannerImageDisplayed();
        softAssert.assertTrue(isBannerImageDisplayed, "Some Banner Images are not displayed");
        Reporter.log("✅ Banner Images are displayed Successfully", true);
        Reporter.log("===Banner Image Src=== ", true);
        List<String> imagesSrc = new ArrayList<>();
        for (String imageSrc : banner.getAllBannerImageSrc()) {
            Reporter.log(imageSrc, true);
        }
        softAssert.assertAll();
    }

    @Test(description = "Log all banner images URls displayed on the Home page")
    public void verifyAllBannerImagesUrlsAreLoggedCorrectly() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        List<String> bannerUrls = banner.getAllBannerRedirectUrls();
        Reporter.log("✅ Banner Images Url are loaded Successfully", true);
        Reporter.log("===Banner Images Url===", true);
        for (String url : bannerUrls) {
            Reporter.log(url, true);
        }
    }

    @Test(description = "Verify that the first banner is displayed by default")
    public void verifyFirstBannerIsDisplayedByDefault() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int activeBannerIndex = banner.getActiveBannerIndex();
        Assert.assertEquals(activeBannerIndex, 0, "Expected the first banner (index 0) to be active by default, but found active banner at index" + activeBannerIndex);
        Reporter.log("✅ Initial Banner is active Successfully", true);
        Reporter.log("Active Banner index : " + activeBannerIndex, true);
    }

    @Test(description = "Verify that the slider automatically transitions after X seconds")
    public void verifyBannerSlidesAutomatically() throws InterruptedException {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int totalSlides = banner.getBannerCount();
        Assert.assertTrue(totalSlides > 1, "Not enough slides to verify auto-transition");
        int previousActiveBannerIndex = banner.getActiveBannerIndex();
        for (int i = 0; i < totalSlides; i++) {
            Thread.sleep(4000);
            int currentActiveBannerIndex = banner.getActiveBannerIndex();
            Assert.assertNotEquals(
                    currentActiveBannerIndex,
                    previousActiveBannerIndex,
                    "Banner did not auto-transition after expected duration!");
            Reporter.log("✅ Slide transitioned successfully from " + previousActiveBannerIndex + " → " + currentActiveBannerIndex, true);
            previousActiveBannerIndex = currentActiveBannerIndex;
        }
        Reporter.log("🎉 All slides transitioned automatically as expected!", true);
    }

    @Test(description = "Verify that next/previous arrow buttons work correctly")
    public void verifyNextPreviousArrowButtonWorking() throws InterruptedException {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int totalSlides = banner.getBannerCount();
        Assert.assertTrue(totalSlides > 1, "Not Enough Slide to verify next/previous arrow button transition");
        int previousActiveBannerIndex = banner.getActiveBannerIndex();
        for (int i = 0; i < totalSlides; i++) {
            banner.clickRightBannerArrowSlider();
            Thread.sleep(2000);
            int currentActiveBannerIndex = banner.getActiveBannerIndex();
            Assert.assertNotEquals(
                    currentActiveBannerIndex,
                    previousActiveBannerIndex,
                    "Banner did not auto-transition after clicking right Arrow Button!");
            Reporter.log("✅ Slide transitioned successfully from " + previousActiveBannerIndex + " → " + currentActiveBannerIndex, true);
            previousActiveBannerIndex = currentActiveBannerIndex;
        }
        for (int i = 0; i < totalSlides; i++) {
            banner.clickLeftBannerArrowSlider();
            Thread.sleep(2000);
            int currentActiveBannerIndex = banner.getActiveBannerIndex();
            Assert.assertNotEquals(
                    currentActiveBannerIndex,
                    previousActiveBannerIndex,
                    "Banner did not transition after clicking left Arrow Button!"
            );

            Reporter.log("✅  Slide transitioned successfully from " + previousActiveBannerIndex + " → " + currentActiveBannerIndex, true);
            previousActiveBannerIndex = currentActiveBannerIndex;
        }
        Reporter.log("🎉 Both Next and Previous arrow buttons work correctly!", true);
    }

    @Test(description = "verify the pagination dots are visible")
    public void verifyPaginationDotAreVisible() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        SoftAssert softAssert = new SoftAssert();
        int totalSlides = banner.getBannerCount();
        softAssert.assertTrue(totalSlides > 1, "Not enough slides to verify Pagination Dots");
        int paginationCount = banner.getPaginationDotsCount();
        softAssert.assertTrue(banner.arePaginationDotsVisible(), "Pagination bullets are not visible on banner slider!");
        softAssert.assertTrue(paginationCount > 1, "Pagination dot count should be greater than 1!");
        softAssert.assertEquals(paginationCount, totalSlides, "Pagination dot count does not match total slide count!");
        Reporter.log("Pagination Dot Count :: " + paginationCount, true);
        Reporter.log("✅  All Pagination Dot are Displayed as expected!", true);
        softAssert.assertAll();
    }

    @Test(description = "verify navigation to banner through pagination Dot")
    public void verifyNavigationFromPaginationDot() throws InterruptedException {
       HomePage home = new HomePage(driver);
       BannerSection banner = home.getBannerSection();

        int totalSlides = banner.getBannerCount();
        Assert.assertTrue(totalSlides>1 , "Not enough slides to verify pagination dot transition!");

        int previousActiveBannerIndex = banner.getActiveBannerIndex();
        Reporter.log("Initial Active Banner :: " + previousActiveBannerIndex, true);

        for (int i = 0;i<totalSlides;i++){
            int randomIndex;
            do{
                randomIndex = (int)(Math.random()*totalSlides);
            }while (randomIndex==previousActiveBannerIndex);

            banner.clickPaginationDotByIndex(randomIndex);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            int finalRandomIndex = randomIndex;
            wait.until(d->banner.getActiveBannerIndex()== finalRandomIndex);

            int currentActiveBannerIndex = banner.getActiveBannerIndex();
            Reporter.log("Transitioned to Banner :: " + currentActiveBannerIndex,true);

            Assert.assertEquals(
                    currentActiveBannerIndex,
                    randomIndex,
                    "Clicked Pagination dot did not activate the correct banner");
            previousActiveBannerIndex = currentActiveBannerIndex;
        }
        Reporter.log("✅  All Pagination Dot are navigating as expected!", true);


    }

    @Test(description = "Verify clicking each banner redirects to its expected URL")
    public void verifyBannerRedirects() throws InterruptedException {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int totalSlides = banner.getBannerCount();
        Reporter.log("Total Banners Found: " + totalSlides,true);
        List<String> expectedUrl = banner.getAllBannerRedirectUrls();
        List<String> actualUrl = new ArrayList<>();
        Reporter.log("=== Expected Banner URLs ===", true);
        expectedUrl.forEach(url->Reporter.log(url,true));

        Reporter.log("=== actual Banner URLs ===", true);

        for (int i = 0; i < totalSlides; i++) {
            for (int j = 0; j < i; j++) {
                banner.clickRightBannerArrowSlider();
                Thread.sleep(1000);
            }
            banner.clickActiveBanner();
            Thread.sleep(2000);

             actualUrl.add(home.getCurrentUrl());
            driver.navigate().back();
            Thread.sleep(3000);

            // reinitialize banner section since DOM reloads
            home = new HomePage(driver);
            banner = home.getBannerSection();
        }
        actualUrl.forEach(url->Reporter.log(url,true));
        Assert.assertEquals(actualUrl,expectedUrl,"Some banner redirects do not match expected Urls  ");
        Reporter.log("✅  All Url are Navigating as expected!", true);
    }

    @Test(description = "verify Browse By Category section is visible")
    public void verifyBrowseByCategorySectionIsVisible(){
        HomePage home = new HomePage(driver);
        CategoriesSection category = home.getCategoriesSection();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(category.isBrowseByCategorySectionVisible(),
                "Browse By Category main section is not visible");
        softAssert.assertTrue(category.isBrowseByCategoryHeadingVisible(),
                "section heading is not visible");
        softAssert.assertTrue(category.areCategoryItemVisible(),
                "category items are not visible or not loaded properly");
        softAssert.assertEquals(category.getBrowseByCategoryHeadingText().trim(),
                "Browse By Categories",
                "section heading text mismatch");
        softAssert.assertAll();
        Reporter.log("✅ All checks passed — 'Browse By Category' section is fully visible with correct heading and items.",
                true);

    }
}
