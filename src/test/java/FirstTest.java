
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.browserstack.com/users/sign_in");
        driver.manage().window().maximize();

        WebElement usernameElement = driver.findElement(By.cssSelector("#user_email_login"));
        usernameElement.sendKeys(System.getenv("LOGIN_USERNAME"));

        WebElement passwordElement = driver.findElement(By.cssSelector("#user_password"));
        passwordElement.sendKeys(System.getenv("LOGIN_PASSWORD"));

        WebElement submitButtonElement = driver.findElement(By.cssSelector("#user_submit"));
        submitButtonElement.click();

        Thread.sleep(5000);

        WebElement bellIconElement = driver.findElement(By.id("beamer-bell"));
        assert bellIconElement.isDisplayed();

        driver.quit();
    }

}
