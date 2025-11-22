package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By itemCart = By.xpath("//*[@data-testid='item-card']");
    private By emptyCartImage = By.xpath(".//*div/img[@alt='No Product in Cart']");
    private By emptyCartMessage = By.xpath(".//*div/h1[text()='Cart Empty']");
    private By title = By.xpath(".//*div[@data-testid='item-name']/h2");
    private By price = By.xpath(".//*div[@data-testid='item-price']/p");
    private By quantityDecreaseButton = By.xpath(".//*button[@data-testid='minus-quantity']");
    private By quantityIncreaseButton = By.xpath(".//*button[@data-testid='plus-quantity']");
    private By subTotalPrice = By.xpath(".//*div[@data-testid='total-price']/p");
    private By cartImage = By.xpath(".//*div[@data-testid='cart-image']/img");
    private By itemDeleteButton = By.xpath(".//*div[@data-testid='cross-image']");

    private By checkoutSummary = By.xpath("//*div[@data-testid='cart-pricing']");
    private By totalMrpValue = By.xpath(".//*p[@data-testid='total-mrp']/span[@data-testid='mrp-value']");
    private By discountOnMRPValue = By.xpath(".//*p[@data-testid='total-discount']/span[@data-testid='discount-value']");
    private By taxValue = By.xpath(".//*p[@data-testid='total-tax']/span[@data-testid='tax-value']");
    private By shippingChargesValue = By.xpath(".//*p[@data-testid='total-shipping-charges']/span[@data-testid='shipping-value']");
    private By totalAmountValue = By.xpath(".//*p[@data-testid='final-amount']/span[@data-testid='final-amount-value']");
    private By proceedToCheckoutButton = By.xpath(".//*div[@data-testid='cart-pricing']//button");
    private By backToStoreButton = By.xpath("//a[@href='/shop']/button[contains(text(),'Back to Store')]");
    private By clearCartButton = By.xpath("//button[contains(text(),'Clear Cart')]");


}
