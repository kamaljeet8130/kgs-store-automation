package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesSection {
    private WebDriver driver;

    //locators:
    private By categoriesSliding = By.xpath("(//div[contains(@class,'mySwiper')])[1]//div[contains(@class,'swiper-slide')]");
    private By activeCategory = By.xpath("(//div[contains(@class,'mySwiper')])[1]//div[contains(@class,'swiper-slide-active')]");
    private By leftArrow= By.xpath("(//h1[text()='Browse By Categories']/following-sibling::div//*[name()='svg'])[1]");
    private By rightArrow= By.xpath("(//h1[text()='Browse By Categories']/following-sibling::div//*[name()='svg'])[2]");
    private By viewAll = By.xpath("//h1[text()='Browse By Categories']/ancestor::div[contains(@class,'relative')]//a[@href='categories']");



}
