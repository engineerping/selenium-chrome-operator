package cn.gcsp.operatechromebyselenium.operation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class ChromeOperator {
    public static void operator() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.taobao.com/");
//        System.out.println(driver.getTitle(););
        WebElement webElement = driver.findElement(By.id("q"));
        webElement.clear();
        webElement.sendKeys("男士洗面奶");
        webElement.sendKeys(Keys.ENTER);
//        driver.close();

    }
}
