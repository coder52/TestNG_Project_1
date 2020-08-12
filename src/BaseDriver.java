package Homeworks.TestNG_Practice_POM_PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Random;

class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Random random;
    protected String email;
    protected String password;
    protected POM_Elements locators;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    void setup(@Optional("chrome") String browser) {

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }

        wait = new WebDriverWait(driver,10);
        js = (JavascriptExecutor) driver;
        random = new Random();
        locators = new POM_Elements(driver);

        email= "group2@gmail.com";
        password = "group2";

    }

    @AfterClass
    void quitDriver(){

        driver.quit();

    }

    void waitAndClick(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    void waitClickWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    String waitAndGetText(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    void clearTextBoxAndSendKeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
    }


}
