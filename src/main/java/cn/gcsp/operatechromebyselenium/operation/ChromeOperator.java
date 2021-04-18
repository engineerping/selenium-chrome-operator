package cn.gcsp.operatechromebyselenium.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class ChromeOperator {
    public static void operator() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
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
