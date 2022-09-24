package adeola.defense;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KongaLoginTest {

    WebDriver driver;
    WebDriverWait wait;
    public void login_step(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        // launch the konga page
        driver.get("https://www.konga.com/");
        //maximize the page
        driver.manage().window().maximize();
        //Get the page title and verify that it is correct
        Assert.assertEquals(driver.getTitle(), "Buy Phones, Fashion, Electronics in Nigeria_Konga Online Shopping | Konga Online Shopping");
        // click the login link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._12e27_1r3kc > ._16536_xxIKG._7ad32_SD12Y")));
        driver.findElement(By.cssSelector("._12e27_1r3kc > ._16536_xxIKG._7ad32_SD12Y")).click();
        // Input Email address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#username")));
        driver.findElement(By.cssSelector("input#username")).sendKeys("shrewdruqqy@gmail.com");
        // Input Password
        driver.findElement(By.cssSelector("input#password")).sendKeys("github");
        //Click Login Button
        driver.findElement(By.cssSelector("._0a08a_3czMG._988cf_1aDdJ")).click();
        /*
         * In order to click the logout button, we need to over on the Accounts link
         * So that we can see the logout button
         * */
        // Hover on the Account Link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._12e27_1r3kc ._16536_xxIKG span")));
        WebElement account_link = driver.findElement(By.cssSelector("._12e27_1r3kc ._16536_xxIKG span"));
        actions.moveToElement(account_link).perform();
        // Click Logout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a2562_2y9Sv.de870_2eIHs > a")));
        driver.findElement(By.cssSelector(".a2562_2y9Sv.de870_2eIHs > a")).click();

        //Quit The Browser
        driver.quit();



    }

    public static void main(String [] args){
        KongaLoginTest kongaLogin = new KongaLoginTest();
        kongaLogin.login_step();
    }
}

