import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest {

    WebDriver driver;

    private static final String GOOGLE_URL = "https://www.google.com/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkThatSearchWorksAndReturnsResults() {

        String searchQuery = "Selenium";
        int expectedResultsAmount = 9;
        driver.get(GOOGLE_URL);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery, Keys.ENTER);
        List<WebElement> searchQueriesList = driver.findElements(By.xpath("//a/h3"));

        assertEquals(expectedResultsAmount, searchQueriesList.size());
        assertTrue(searchQueriesList.get(0).getText().contains(searchQuery));

    }

    @Test
    public void verifyTheTitleOfTheFirstSearchResultPage() {
        String searchQuery = "Selenium";
        driver.get(GOOGLE_URL);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchQuery, Keys.ENTER);
        List<WebElement> searchQueriesList = driver.findElements(By.xpath("//a/h3"));
        searchQueriesList.get(0).click();

        String expectedTitle = "Что такое Selenium? / Хабр";

        assertEquals(expectedTitle, driver.getTitle());

    }


}
