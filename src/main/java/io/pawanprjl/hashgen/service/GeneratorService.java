package io.pawanprjl.hashgen.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 2:15 PM
 * @email pawanparajuli8@gmail.com
 **/

@Service
@Slf4j
public class GeneratorService {

//    private final WebDriver driver;
    private final ChromeDriver driver;

    public GeneratorService() throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        log.info("reached chrome options");
         driver = new ChromeDriver(chromeOptions);
//        driver = new RemoteWebDriver(new URL("http://172.18.0.2:4444"), chromeOptions);
        log.info("got remote web driver handle");
        driver.get("https://www.instagram.com");
        log.info("got instagram page");
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[contains(text(), \"Accept All\")]")).click();
//        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("retr0hunter");
        driver.findElement(By.name("password")).sendKeys("retr0@hunter");
        log.info("logged in to instagram");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        log.info("done loggin in to instagram");
    }

    public String getHashtags(String hashtag) {
        driver.get("https://www.instagram.com/web/search/topsearch/?context=blended&query=%23" + hashtag);
        return driver.findElement(By.tagName("body")).getText();
    }
}
