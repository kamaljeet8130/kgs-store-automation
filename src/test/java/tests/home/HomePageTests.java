package tests.home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    }
    @Test(description = "Verify all banners and images are displayed on the homepage")
    public void verifyBannerIsDisplayed(){
        HomePage home = new HomePage(driver);
        BannerSection banner = home.getBannerSection();
        int bannerCount = banner.getBannerCount();
        Assert.assertTrue(bannerCount>0,"No Banner is displayed on Home Page!" + bannerCount);
        System.out.println(bannerCount);

//        boolean isBannerImageVisible = banner.areAllBannerImageDisplayed();
//        Assert.assertTrue(isBannerImageVisible,"Some Banner Image are not Visible!");
        for (String s : banner.getAllBannerRedirectUrls()){
            System.out.println(s);
        }




    }




}
