package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterSection {
    WebDriver driver;

    //locators:
    private By footerSection = By.xpath("//div[@data-testid='footer']");
    private By logoImage = By.xpath(".//div/a/img[@alt='logo']");
    private By privacyPolicyLink = By.xpath(".//div/a[text()='Privacy Policy']");
    private By termsAndConditionLink = By.xpath(".//div/a[text()='Terms & Conditions']");
    private By returnAndExchangeLink = By.xpath(".//div/a[text()='Return & Exchange']");
    private By shippingPolicyLink = By.xpath(".//div/a[text()='Shipping Policy']");
    private By shopByCategoryLink = By.xpath(".//div/a[text()='Shop By Category']");
    private By khanGlobalStudiesAppAndroidApp = By.xpath(".//div/a[text()=' Khan Global Studies - Android APP']");
    private By khanGlobalStudiesIOS = By.xpath(".//div/a[text()='  Khan Global Studies - IOS APP']");
    private By userDashboard = By.xpath(".//div/a[text()='User Dashboard']");
    private By dailyCurrentAffairs = By.xpath(".//div/a[text()='Daily Current Affairs']");
    private By location = By.xpath(".//div/p[@class='cursor-pointer']");
    private By email = By.xpath(".//div/a[@type='email']");
    private By phoneNumber = By.xpath(".//div/button");
    //


    public FooterSection(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement getFooterSection(){
        return driver.findElement(footerSection);
    }
    private String getLinkHref(By linkLocator){
        return getFooterSection().findElement(linkLocator).getAttribute("href");
    }

    public void clickOnLogo(){
        getFooterSection().findElement(logoImage).click();
    }
    public void clickPrivacyPolicy(){
        getFooterSection().findElement(privacyPolicyLink).click();
    }
    public void clickTermAndConditionLink(){
        getFooterSection().findElement(termsAndConditionLink).click();
    }
    public void clickReturnAndExchangeLink(){
        getFooterSection().findElement(returnAndExchangeLink).click();
    }
    public void clickShippingPolicyLink(){
        getFooterSection().findElement(shippingPolicyLink).click();
    }
    public void clickShopByCategoryLink(){
        getFooterSection().findElement(shopByCategoryLink).click();
    }
    public void clickKhanGlobalStudiesAppAndroidApp(){
        getFooterSection().findElement(khanGlobalStudiesAppAndroidApp).click();
    }
    public void clickKhanGlobalStudiesIOS(){
        getFooterSection().findElement(khanGlobalStudiesIOS).click();
    }
    public void goToUserDashboard(){
        getFooterSection().findElement(userDashboard).click();
    }
    public void goToCurrentAffairs(){
        getFooterSection().findElement(dailyCurrentAffairs).click();
    }
    public String getCompanyLocation(){
        return getFooterSection().findElement(location).getText();
    }
    public String getEmail(){
        return getFooterSection().findElement(email).getText();
    }
    public String getPhoneNumber(){
        return getFooterSection().findElement(phoneNumber).getText();
    }
    public String getPrivacyPolicyHref() {
        return getLinkHref(privacyPolicyLink);
    }
    public String getTermsAndConditionsHref() {
        return getLinkHref(termsAndConditionLink);
    }
    public String getReturnAndExchangeHref() {
        return getLinkHref(returnAndExchangeLink);
    }
    public String getShippingPolicyHref() {
        return getLinkHref(shippingPolicyLink);
    }
    public String getShopByCategoryHref() {
        return getLinkHref(shopByCategoryLink);
    }
    public String getAndroidAppHref() {
        return getLinkHref(khanGlobalStudiesAppAndroidApp);
    }
    public String getIOSAppHref() {
        return getLinkHref(khanGlobalStudiesIOS);
    }
    public String getUserDashboardHref() {
        return getLinkHref(userDashboard);
    }
    public String getDailyCurrentAffairsHref() {
        return getLinkHref(dailyCurrentAffairs);
    }
}
