
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FailedLogin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        WebElement usernameElement = wait.until(webDriver -> driver.findElement(By.cssSelector("#username")));
        usernameElement.sendKeys("wrong-student");

        WebElement passwordElement = driver.findElement(By.cssSelector("#password"));
        passwordElement.sendKeys("Password123");

        WebElement submitButtonElement = driver.findElement(By.cssSelector("#submit"));
        submitButtonElement.click();

        assert wait.until(webDriver -> driver.findElement(By.cssSelector("#error")).isDisplayed());

        driver.quit();
    }
}
