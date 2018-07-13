package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.openqa.selenium.*;

public class CreateAccountTest {
    private EventFiringWebDriver driver;
    WebDriverWait wait;

    public static class MyListener extends AbstractWebDriverEventListener {

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println("element" + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + "found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void createAccountTest1() throws Exception {
        goToTheHomePage();
        createAccount();
        fillRegistrationForm("alonatst+1@gmail.com", "1106tests", "1106tests");

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));

        Thread.sleep(1000);
        submitRegistration();
        fillInformationForm();
    }

    public void fillInformationForm() {
        driver.findElement(By.id("inputFirstName")).click();
        driver.findElement(By.id("inputFirstName")).clear();
        driver.findElement(By.id("inputFirstName")).sendKeys("alona");
        driver.findElement(By.id("inputLastName")).click();
        driver.findElement(By.id("inputLastName")).clear();
        driver.findElement(By.id("inputLastName")).sendKeys("tst");
        driver.findElement(By.id("inputPhoneNumber")).click();
        driver.findElement(By.id("inputPhoneNumber")).clear();
        driver.findElement(By.id("inputPhoneNumber")).sendKeys("123456789");
        driver.findElement(By.xpath("//mat-select[@id='mat-select-0']/div/div[2]")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-0']/span")).click();
        driver.findElement(By.cssSelector("svg.mat-datepicker-toggle-default-icon.ng-star-inserted")).click();
        driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']/div/div/button/span")).click();
        driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']/div/div/button[2]")).click();
        driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']/div[2]/mat-multi-year-view/table/tbody/tr/td[3]/div")).click();
        driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']/div[2]/mat-year-view/table/tbody/tr[2]/td/div")).click();
        driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']/div[2]/mat-month-view/table/tbody/tr[3]/td[3]/div")).click();
        driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-6']/span")).click();

    /*driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div/div[2]/div[2]/mat-form-field/div/div/div")).click();
    driver.findElement(By.xpath("//mat-option[@id='mat-option-10']/mat-pseudo-checkbox")).click();*/

        driver.findElement(By.xpath("//mat-select[@id='mat-select-3']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-11']/span")).click();
        driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div/div[2]/div[4]/mat-form-field/div/div/div")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-13']/mat-pseudo-checkbox")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-14']/mat-pseudo-checkbox")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-16']/mat-pseudo-checkbox")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-17']/mat-pseudo-checkbox")).click();

   /* driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("Hey there!");*/

        /* driver.findElement(By.xpath("//div[@id='pictureTable']/div[2]/form/div[2]/button/span")).click();*/

    }

    public void submitRegistration() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public void fillRegistrationForm(String email, String psw, String psw2) {
        driver.findElement(By.id("mat-input-0")).click();
        driver.findElement(By.id("mat-input-0")).clear();
        driver.findElement(By.id("mat-input-0")).sendKeys(email);
        driver.findElement(By.id("mat-input-1")).click();
        driver.findElement(By.id("mat-input-1")).clear();
        driver.findElement(By.id("mat-input-1")).sendKeys(psw);
        driver.findElement(By.id("mat-input-2")).click();
        driver.findElement(By.id("mat-input-2")).clear();
        driver.findElement(By.id("mat-input-2")).sendKeys(psw2);
    }

    public void createAccount() {
        driver.findElement(By.xpath("//a[2]/span/span")).click();
    }

    public void goToTheHomePage() {
        driver.get("https://mish.sheygam.com/#/wellcome");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
