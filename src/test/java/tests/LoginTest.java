package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardLoginPage;
import pages.home.BannerSection;
import pages.home.HeaderSection;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void testUserLogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HeaderSection headerSection = new HeaderSection(driver);


        BannerSection bannerSection = new BannerSection(driver);
        int oldIndex = bannerSection.getActiveBannerIndex();
        bannerSection.waitForBannerChanges(oldIndex);
        int newIndex = bannerSection.getActiveBannerIndex();
        System.out.println(oldIndex + " :: " + newIndex);

    }


}
