package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardLoginPage {
    private WebDriver driver;

    private By phoneInputField = By.xpath("//input[@id='login_form_phone']");
    private By passwordInputField = By.xpath("//input[@id=\"login_form_password\" and @type=\"password\"]");
    private By loginButton = By.xpath("//button[@type=\"submit\"]");

    public DashboardLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPhoneInputField(String phoneInput){
        driver.findElement(phoneInputField).sendKeys(phoneInput);
    }
    public void setPasswordInputField(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

}
