package basicSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ItemCreation {
    ChromeDriver driver;

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void loginTodoLy() throws InterruptedException {
        driver.get("http://todo.ly/");

        //------ Login ------
        //1) Click Login Button
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        //2) Set Email
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("upbui@upbui.com");
        //3) Set Password
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxPassword']")).sendKeys("1234");
        //4) Click Login Button
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$ButtonLogin']")).click();

        // *) Verificar si estoy logueado
        Assert.assertTrue("Error, nose pudo hacer login", driver.findElement(By.xpath("//a[contains(.,'Logout')]")).isDisplayed());

        driver.findElement(By.xpath("//td[contains(.,'sadasd') and @class='ItemContentDiv']")).click();
        //6) Set NombrProject
        // limpiar la caja de texto
        //driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).clear();
        driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).sendKeys("MyProjectSelenium");
        //7) Click Add button
        driver.findElement(By.xpath("//input[@id='NewProjNameButton']")).click();
        //*) //verificacion del nuevo project
        Thread.sleep(3000);
        String expectedResult = "MyProjectSelenium";
        String actualResult = driver.findElement(By.xpath("//div[@id='CurrentProjectTitle']")).getText();

        Assert.assertEquals("El projecto no fue creado", expectedResult, actualResult);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}