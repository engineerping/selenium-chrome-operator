package cn.gcsp.operatechromebyselenium.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChromeOperator {

    private static ChromeDriver driver;

    public static void operator() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//        driver.get("https://www.baike.com/write/hot_task?level=1&page=1");
//        WebElement webElement = driver.findElement(By.className("tabsMenu"));
//        System.out.println(webElement);
////        webElement.clear();
////        webElement.sendKeys("男士洗面奶");
//        webElement.sendKeys(Keys.ENTER);
        startSelenium();
        connectChrome();
        connectChrome2();
//        driver.close();
    }

    public static void startSelenium() {
        String path = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        String dir = "F:\\chrome_config\\";
        List<String> cmd = new ArrayList<>();
        cmd.add(path);
        cmd.add("--user-data-dir="+ dir);
        cmd.add("--remote-debugging-port=9999");
        // 窗口启动最大化
        cmd.add("--start-maximized");
        ProcessBuilder process = new ProcessBuilder(cmd);
        try {
            process.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9999");
        driver = new ChromeDriver(options);
        System.out.println(driver.getTitle());
        driver.get("https://www.toutiao.com/?is_new_connect=0&is_new_user=0");
    }

    public static void connectChrome2() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9999");
        driver = new ChromeDriver(options);
        System.out.println(driver.getTitle());
        driver.get("https://www.baike.com/write/hot_task?level=1&page=1");

        while (true) {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.className("tabsMenu"));
            System.out.println(webElement);
            List<WebElement> spanList = webElement.findElements(new By.ByTagName("span"));
            for (WebElement span : spanList) {
                String text = span.getText();
                char number = text.charAt(3);
                System.out.println("数字是" + number);
                if ('0' != number) {
                    span.click();
                    Utiles.retry(20, 250, () -> {
                        lingQu();
                    });
                }
            }
        }
    }

    public static void lingQu() {
        List<WebElement> webElementList = driver.findElements(By.cssSelector("span.bk-color-link.bk-cursor"));
        webElementList.get(0).click();
        System.out.println(webElementList.get(0).getText());
    }


}
