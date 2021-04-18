package cn.gcsp.operatechromebyselenium;

import cn.gcsp.operatechromebyselenium.operation.ChromeOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OperateChromeByPuppeteerApplication implements CommandLineRunner {

//    @Autowired
//    private ChromeOperator chromeOperator;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OperateChromeByPuppeteerApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);

    }

    @Override
    public void run(String[] args) {
        try {
            ChromeOperator.operator();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
