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

    @Test(description = "validate that home page loaded successfully or not")
    public void verifyHomePageLoadedSuccessfully(){
        HomePage home = new HomePage(driver);
        String currentUrl = home.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("store.kgs.ink"),"Home page Url Mismatch, Actual Url " + currentUrl);
        Reporter.log("Store Url : " + currentUrl,true);
    }
    @Test(description = "Verify at least one banner is displayed on the homepage")
    public void verifyBannerCountIsPositive(){
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int bannerCount = banner.getBannerCount();
        Assert.assertTrue(bannerCount>0,"No banner is Displayed on Home Page!" + bannerCount);
        Reporter.log("Banner Count : " + bannerCount,true );
    }
    @Test(description = "Verify all banner images are displayed on the homepage!")
    public void verifyAllBannerImagesAreDisplayed() {
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        SoftAssert softAssert = new SoftAssert();
        boolean isBannerImageDisplayed = banner.areAllBannerImageDisplayed();
        softAssert.assertTrue(isBannerImageDisplayed,"Some Banner Images are not displayed");
        Reporter.log("Banner Image Src " ,true);
        List<String> imagesSrc = new ArrayList<>();
        for (String imageSrc : banner.getAllBannerImageSrc()){
            Reporter.log(imageSrc,true);
        }
        softAssert.assertAll();
    }
    @Test(description = "Log all banner images URls displayed on the Home page")
    public void verifyAllBannerImagesUrlsAreLoggedCorrectly(){
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        List<String> bannerUrls = banner.getAllBannerRedirectUrls();
        Reporter.log("===Banner Images Url===" , true);
        for (String url : bannerUrls){
            Reporter.log(url,true);
        }
    }
}
