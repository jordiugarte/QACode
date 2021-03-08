package ejercicioSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProjectDelete {
    ChromeDriver driver;
    String projectName;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginTodoLy() throws InterruptedException {
        driver.get("http://todo.ly/");
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("upbui@upbui.com");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxPassword']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$ButtonLogin']")).click();

        Assert.assertTrue("Error, nose pudo hacer login", driver.findElement(By.xpath("//a[contains(.,'Logout')]")).isDisplayed());

        driver.findElement(By.xpath("//td[contains(.,' " + projectName + " ') and @class='ProjItemContent']")).click();
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();
        driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Delete')]")).click();
        driver.switchTo().alert().accept();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}