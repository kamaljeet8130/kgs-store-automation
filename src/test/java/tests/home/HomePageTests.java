package tests.home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.home.BannerSection;
import pages.home.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HomePageTests extends BaseTest {

    @Test(description = "Verify that home page loaded successfully or not")
    public void verifyHomePageLoadedSuccessfully() {
        HomePage home = new HomePage(driver);
        String currentUrl = home.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("store.kgs.ink"), "Home page Url Mismatch, Actual Url " + currentUrl);
        Reporter.log("Store Url : " + currentUrl, true);
    }

    @Test(description = "Verify at least one banner is displayed on the homepage")
    public void verifyBannerCountIsPositive() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int bannerCount = banner.getBannerCount();
        Assert.assertTrue(bannerCount > 0, "No banner is Displayed on Home Page!" + bannerCount);
        Reporter.log("Banner Count : " + bannerCount, true);
    }

    @Test(description = "Verify all banner images are displayed on the homepage!")
    public void verifyAllBannerImagesAreDisplayed() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        SoftAssert softAssert = new SoftAssert();
        boolean isBannerImageDisplayed = banner.areAllBannerImageDisplayed();
        softAssert.assertTrue(isBannerImageDisplayed, "Some Banner Images are not displayed");
        Reporter.log("Banner Image Src ", true);
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
        softAssert.assertAll();
    }

    @Test(description = "verify navigation to banner through pagination Dot")
    public void verifyNavigationFromPaginationDot() throws InterruptedException {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int totalSlides = banner.getBannerCount();
        Assert.assertTrue(totalSlides > 1, "Not Enough Slide to verify Pagination Dot transition");
        int previousActiveBannerIndex = banner.getActiveBannerIndex();
        for(int i = 0;i<totalSlides;i++){
            banner.clickPaginationDotByIndex(i);
            Thread.sleep(2000);
            int currentActiveBannerIndex = banner.getActiveBannerIndex();
            Assert.assertNotEquals(
                    currentActiveBannerIndex,
                    previousActiveBannerIndex,
                    "Banner did not transition after clicking Pagination Dot!"
            );
            Reporter.log("✅  Slide transitioned successfully from " + previousActiveBannerIndex + " → " + currentActiveBannerIndex, true);
            previousActiveBannerIndex=currentActiveBannerIndex;
        }



    }

}
