import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SkelbiuAutoTest {
    WebDriver _globalDriver;
    WebDriverWait wait;

    @BeforeClass
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.manage().window().maximize();
        wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
    }
    @Test
    public void Test1(){

        for (int p = 1; p < 5 ; p++) { //5 puslapiu skaicius
            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=kepure+su+snapeliu");
            if (p==1) {
                _globalDriver.findElement(By.id("onetrust-accept-btn-handler")).click(); //Sutinkame su slapukais

            }

            for (int i = 1; i <= 29; i++) { //29 produktu skaicius
                try {
                    _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]/div[" + i + "]/a")).click(); //Pirmos prekes Xpath
                }
                catch (Exception e) {
                    continue;
                }
                String ID =  _globalDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[4]/div[1]")).getText();
                System.out.println(ID);
                _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=kepure+su+snapeliu");
            }
        }





    }
}
