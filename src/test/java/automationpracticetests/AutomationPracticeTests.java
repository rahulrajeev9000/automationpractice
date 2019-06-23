package automationpracticetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverUtilities;

public class AutomationPracticeTests {

    static WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        driver = DriverUtilities.getInstanceOfDriverUtilities().getDriver();
    }

    @Before
    public void preCondition(){
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void buy() throws InterruptedException {
        WebElement dressesButton = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        dressesButton.click();
        WebElement printedDressfiftyquid = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
        printedDressfiftyquid.click();
        WebElement size1Select = driver.findElement(By.id("group_1"));
        Select size1OptionToSelect = new Select(size1Select);
        size1OptionToSelect.selectByVisibleText("M");
        WebElement FiftyQuidDressToCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        FiftyQuidDressToCart.click();
        driver.navigate().back();
        driver.navigate().back();
        WebElement twentyEightQuidDresstoCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
        twentyEightQuidDresstoCart.click();
        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        continueButton.click();
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        cartButton.click();
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        proceedToCheckout.click();
        WebElement enterEmail= driver.findElement(By.id("email_create"));
        enterEmail.sendKeys("rahul342@gmail.com");
        enterEmail.submit();
        Thread.sleep(3000);

        WebElement male =driver.findElement(By.id("id_gender1"));
        male.click();
        WebElement customerName= driver.findElement(By.name("customer_firstname"));
        customerName.sendKeys("rahul");
        driver.findElement(By.name("customer_lastname")).sendKeys("rajeev");
        driver.findElement(By.name("passwd")).sendKeys("password");
        driver.findElement(By.name("firstname")).sendKeys("rahul");
        driver.findElement(By.name("lastname")).sendKeys("rajeev");
        driver.findElement(By.name("company")).sendKeys("sparta");
        driver.findElement(By.name("address1")).sendKeys("sparta, 125 London wall");
        driver.findElement(By.name("city")).sendKeys("London");
        WebElement stateSelect = driver.findElement(By.id("id_state"));
        Select stateOptionToSelect = new Select(stateSelect);
        stateOptionToSelect.selectByVisibleText("Hawaii");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("phone_mobile")).sendKeys("0794314314");
        driver.findElement(By.name("alias")).sendKeys("sparta global");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();


    }

    public void assertPaymentSuccess(){
        WebElement confirmationBox = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        Assert.assertTrue(confirmationBox.getText().contains("complete"));
    }
    public void assertPaidByCheque(){
        WebElement confirmationBox = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h3"));
        Assert.assertTrue(confirmationBox.getText().contains("check"));
    }

}
