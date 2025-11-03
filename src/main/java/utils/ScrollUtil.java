package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {
    private JavascriptExecutor js;

    public ScrollUtil(WebDriver driver){
        this.js = (JavascriptExecutor) driver;
    }
    public void scrollDownByPixel(int pixel){
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }
    public void scrollUpByPixel(int pixel){
        js.executeScript("window.scrollBy(0, -" + pixel + ")");
    }
    public void scrollToBottom(){
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void scrollToUp(){
        js.executeScript("window.scrollTo(0,0)");
    }
    public void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    public void scrollHorizontalByPixel(int pixel){
        js.executeScript("window.scrollBy("+pixel+", 0)");
    }
}
