import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class fb {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @org.junit.jupiter.api.Test
    //sprawdzenie polskich znaków
    public  void polishSigns() throws InterruptedException {
        driver.navigate().to("https://facebook.com");
        Thread.sleep(2000);
        driver.findElement(By.id("u_0_h")).click();
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("email"))).click().keyDown(Keys.ALT).keyDown(Keys.CONTROL).sendKeys("enol").build().perform();

        WebElement aa = driver.findElement(By.id("email"));
        File file=aa.getScreenshotAs(OutputType.FILE);


    }


    @org.junit.jupiter.api.Test
    //sprawdzenie poprawnego logowania
    public void login() throws InterruptedException {
        driver.navigate().to("https://facebook.com");
        driver.findElement(By.id("u_0_k")).click();
        String mail = "e.wodniok@gmail.com";
        String password = "Drzewosandalowe7";
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.switchTo().alert().dismiss();


    }


    @org.junit.jupiter.api.Test
    //sprawdzenie komunikatu po wpisaniu błędnego hasła
    public void loginWrongPass() throws InterruptedException {
        driver.navigate().to("https://facebook.com");
        driver.findElement(By.id("u_0_k")).click();
        String mail = "e.wodniok@gmail.com";
        String password = "Drzewosandalowe";
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id='loginform']/div[2]/div[2]")).getText());
        driver.quit();
    }
    @org.junit.jupiter.api.Test
    //sprawdzenie komunikatów przy podaniu niepełnych danych/ Tesco
    public void wrongData(){
        driver.navigate().to("https://ezakupy.tesco.pl");
        String email="email@";
        String pass="asdasd";

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[4]/div/div/label")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[1]/div/div/ul/li")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div/ul/li[2]")).getText());
    }
    @org.junit.jupiter.api.Test
    public void Demo(){
        System.out.println(" wynik");
    }
}


