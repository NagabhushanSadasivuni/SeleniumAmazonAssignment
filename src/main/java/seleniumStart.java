
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class seleniumStart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nagsa/Downloads/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
        driver.findElement(By.cssSelector(".nav-a[href='/deals?ref_=nav_cs_gb']")).click();


        driver.findElement(By.xpath("//div[contains(@class,'Grid-module__grid_1-xkdMK87Hfx0wjqVxAGcI')]/div[1]")).click();
        //driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/span[@class='rush-component s-latency-cf-section']/div[@class='s-main-slot s-result-list s-search-results sg-row']/div[1]")).click();
        driver.findElement(By.xpath("//div[@id='octopus-dlp-asin-stream']/ul/li[2]")).click();

        Set<String> window =driver.getWindowHandles();
if (window.size()>1) {
    Iterator<String> it = window.iterator();
    while (it.hasNext()) {
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        break;
    }
}

        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(5000);
       driver.findElement(By.id("attach-close_sideSheet-link")).click();



        String num = driver.findElement(By.id("nav-cart-count")).getText();
        System.out.println(num);
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
        driver.findElement(By.id("nav-search-submit-button")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,5200)");
        Thread.sleep(5000);

        Actions Ac = new Actions(driver);
        Ac.moveToElement(driver.findElement(By.className("nav-line-1-container"))).build().perform();
        driver.findElement(By.className("nav-action-inner")).click();
        driver.findElement(By.id("ap_email")).sendKeys("nagrazzs8@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("lavanya7");
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(5000);

       // System.out.println(driver.findElement(By.xpath("//div[@data-component-id='40']")).getText());
       // driver.findElement(By.id("nav-hamburger-menu")).click();
      //  driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='8']")).click();
        //Thread.sleep(5000);


        //LOGIN REQIURED STEPS



       // driver.findElement(By.xpath("//div[@id='GLUXAddressBlock']/ul/li[1]")).click();
        driver.findElement(By.className("nav-line-2")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("GLUXZipUpdate-announce")).click();
        WebElement order =driver.findElement(By.id("orderFilter"));
        Select select = new Select(order);
        select.selectByValue("2021");

    }

}
