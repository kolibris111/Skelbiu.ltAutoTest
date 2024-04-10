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

        int count = 0;

        for (int p = 1; p < 6 ; p++) { //6 puslapiu skaicius
            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=kepure+su+snapeliu");

            if (p == 1) {
                _globalDriver.findElement(By.id("onetrust-accept-btn-handler")).click(); //Sutinkame su slapukais

            }
            for (int i = 1; i <= 29; i++) { //29 produktu skaicius
                // /html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[3]/div[1]/a
                // /html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/a
                try {
                    _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[" + (p+1) + "]/div[" + i + "]/a")).click(); //Pirmos prekes Xpath
                    count++;
                }
                catch (Exception e) {
                    continue;
                }
                String ID =  _globalDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[4]/div[1]")).getText();
                System.out.println(ID);
                _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=kepure+su+snapeliu");
            }
            System.out.println("Tikru skelbimu yra " + count);

            // Reikia bandyti su ccs selector (copy selector)
        }
    }
    @Test
    public void Test2(){

        int count1 = 0;

        for (int p = 1; p < 3 ; p++) { // puslapiu skaicius

            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=samotines+plytos");

            if (p == 1) {
                _globalDriver.findElement(By.id("onetrust-accept-btn-handler")).click(); //Sutinkame su slapukais

            }
            for (int i = 1; i <= 29; i++) { //29 produktu skaicius puslapyje
                try {                                              // /html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]/div[1]/a
                    _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]/div[" + (p+1) + "]/div[" + i + "]/a")).click(); //Pirmos prekes Xpath
                    count1++;
                }
                catch (Exception e) {
                    continue;
                }
            }                                                           // /html/body/div[2]/div/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[4]/div[1]
            String ID2 =  _globalDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[4]/div[1]")).getText();
            System.out.println(ID2);
            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?autocompleted=1&keywords=samotines+plytos");
        }
        System.out.println("Tikru skelbimu yra " + count1);
    }
}
