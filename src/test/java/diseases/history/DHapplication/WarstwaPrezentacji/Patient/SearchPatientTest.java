package diseases.history.DHapplication.WarstwaPrezentacji.Patient;

import diseases.history.DHapplication.WarstwaPrezentacji.BaseSeleniumTests;
import diseases.history.DHapplication.DHapplicationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DHapplicationApplication.class)
public class SearchPatientTest extends BaseSeleniumTests {

    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/api/patient/getAllPatients");
        super.setUp();
    }

    @Test
    public void searchPatientExists() {
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("112857234");
        driver.findElement(By.name("selectedButton")).click();
        assertThat(driver.findElement(By.cssSelector(".w3-text-teal:nth-child(1)")).getText(),
                is("Patient found successfully"));
    }

    @Test
    public void searchPatientNotExists() {
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("112857255");
        driver.findElement(By.name("selectedButton")).click();
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Patient doesn't found"));
    }
}
