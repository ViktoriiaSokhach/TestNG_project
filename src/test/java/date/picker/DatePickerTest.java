package date.picker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DatePickerTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void datePickerTest() {
        String dateInPast = "06/21/2015";

        DatePicker datePicker = new DatePicker(driver);
        datePicker.openDatePicker();
        datePicker.setDate(dateInPast);

        String selectedDate = datePicker.getSelectedDate();

        assertEquals(selectedDate, dateInPast);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
