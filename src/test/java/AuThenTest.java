import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuThenTest {

    WebDriver driver;
    String url = "https://vitimex.com.vn/";
    String email = "test123@gmail.com";
    String password = "test123";

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test()
    public void dangKy() {
        driver.get(url + "account/register");

        driver.findElement(By.id("last_name")).sendKeys("Lanh");
        driver.findElement(By.id("first_name")).sendKeys("Minh Hieu");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        System.out.println("Đăng ký thành công");
    }

    @Test
    public void dangNhap() {
        driver.get(url + "account/login");

        driver.findElement(By.id("customer_email")).sendKeys(email);
        driver.findElement(By.id("customer_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        System.out.println("Đăng nhập thành công");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
