package pages.home;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    BannerSection bannerSection;
    CategoriesSection categoriesSection;
    HeaderSection headerSection;
    FooterSection footerSection;
    ProductListingSection productListingSection ;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.bannerSection = new BannerSection(driver);
        this.categoriesSection = new CategoriesSection(driver);
        this.headerSection = new HeaderSection(driver);
        this.footerSection = new FooterSection(driver);
        this.productListingSection = new ProductListingSection(driver);
    }
    public BannerSection getBannerSection() {
        return bannerSection;
    }

    public CategoriesSection getCategoriesSection() {
        return categoriesSection;
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public FooterSection getFooterSection() {
        return footerSection;
    }

    public ProductListingSection getProductListingSection() {
        return productListingSection;
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getTitle(){
        return driver.getTitle();
    }
}
