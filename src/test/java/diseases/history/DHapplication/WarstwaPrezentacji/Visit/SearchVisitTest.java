package diseases.history.DHapplication.WarstwaPrezentacji.Visit;

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
public class SearchVisitTest extends BaseSeleniumTests {
    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/api/visit/getAllDoctorVisits/");
        super.setUp();
    }

    @Test
    public void searchVisitExists() throws InterruptedException {

        driver.findElement(By.id("patientIndividualNumber")).click();
        driver.findElement(By.id("patientIndividualNumber")).sendKeys("112857234");
        driver.findElement(By.name("visitDate")).click();
        driver.findElement(By.name("visitDate")).sendKeys("15-12-2019");
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        //Check dispatch sent to user
        assertThat(driver.findElement(By.cssSelector(".w3-text-teal")).getText(),
                is("Visit found successfully"));
    }

    @Test
    public void searchVisitNotExist() {

        driver.findElement(By.id("patientIndividualNumber")).click();
        driver.findElement(By.id("patientIndividualNumber")).sendKeys("112857234");
        driver.findElement(By.name("visitDate")).click();
        driver.findElement(By.name("visitDate")).sendKeys("12-01-2019");
        driver.findElement(By.name("selectedButton")).click();
        //Check dispatch sent to user
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Visit doesn't found"));
    }


}
