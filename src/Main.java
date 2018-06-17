import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Main {
    private static WebDriver driver;

    public static void main(String[] args) throws Exception {
        //引用火狐浏览器驱动
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/index.php?tn=monline_3_dg");
        Thread.sleep(2000);
        driver.findElement(By.id("kw")).click();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("掘金网");
        Thread.sleep(100);
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='container']/div[2]/div")).click();
        driver.findElement(By.linkText("掘金- juejin.im - 一个帮助开发者成长的社区")).click();
        Thread.sleep(7000);
        Set<String> windowHandles = driver.getWindowHandles();
        String windowHandle = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        driver.findElement(By.xpath("//div[@id='juejin']/div[2]/div/header/div/nav/ul/li[2]/form/input")).click();
        driver.findElement(By.xpath("//div[@id='juejin']/div[2]/div/header/div/nav/ul/li[2]/form/input")).click();
        driver.findElement(By.xpath("//div[@id='juejin']/div[2]/div/header/div/nav/ul/li[2]/form/input")).clear();
        driver.findElement(By.xpath("//div[@id='juejin']/div[2]/div/header/div/nav/ul/li[2]/form/input")).sendKeys("我是如何重构整个研发项目，促进自动化运维DevOps的落地？");
        driver.findElement(By.xpath("//div[@id='juejin']/div[2]/div/header/div/nav/ul/li[2]/form/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.linkText("我是如何重构整个研发项目，促进自动化运维DevOps的落地？")).click();
    }
}
