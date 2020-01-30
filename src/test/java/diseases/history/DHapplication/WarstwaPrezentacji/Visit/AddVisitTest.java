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
public class AddVisitTest extends BaseSeleniumTests {

    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/api/visit/add");
        super.setUp();
    }

    @Test
    public void addVisitExists() throws InterruptedException {

        driver.findElement(By.id("patient.individualNumber")).click();
        driver.findElement(By.id("patient.individualNumber")).sendKeys("112857234");
        driver.findElement(By.id("doctor.pzwNumber")).click();
        driver.findElement(By.id("doctor.pzwNumber")).sendKeys("1234567");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.id("visitDateString")).sendKeys("15-12-2019");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("This visit exists"));
    }


    @Test
    public void addVisitDoctorNotExists() throws InterruptedException {

        driver.findElement(By.id("patient.individualNumber")).click();
        driver.findElement(By.id("patient.individualNumber")).sendKeys("112857234");
        driver.findElement(By.id("doctor.pzwNumber")).click();
        driver.findElement(By.id("doctor.pzwNumber")).sendKeys("5648732");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.id("visitDateString")).sendKeys("15-12-2019");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Doctor doesn't exist"));
    }


    @Test
    public void addVisitPatientNotExists() throws InterruptedException {

        driver.findElement(By.id("patient.individualNumber")).click();
        driver.findElement(By.id("patient.individualNumber")).sendKeys("000000000");
        driver.findElement(By.id("doctor.pzwNumber")).click();
        driver.findElement(By.id("doctor.pzwNumber")).sendKeys("1234567");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.id("visitDateString")).sendKeys("15-12-2019");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Patient doesn't exist"));

    }
    @Test
    public void addVisitDoctorAndPatientNotExists() throws InterruptedException {

        driver.findElement(By.id("patient.individualNumber")).click();
        driver.findElement(By.id("patient.individualNumber")).sendKeys("000000000");
        driver.findElement(By.id("doctor.pzwNumber")).click();
        driver.findElement(By.id("doctor.pzwNumber")).sendKeys("5648732");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.id("visitDateString")).sendKeys("15-12-2019");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black:nth-child(3)")).getText(),
                is("Patient doesn't exist"));
        assertThat(driver.findElement(By.cssSelector(".w3-text-black:nth-child(2)")).getText(),
                is("Doctor doesn't exist"));

    }

    @Test
    public void addVisitCorrectly() throws InterruptedException {

        driver.findElement(By.id("patient.individualNumber")).click();
        driver.findElement(By.id("patient.individualNumber")).sendKeys("978448642");
        driver.findElement(By.id("doctor.pzwNumber")).click();
        driver.findElement(By.id("doctor.pzwNumber")).sendKeys("1234567");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.id("visitDateString")).sendKeys("18-02-2020");
        driver.findElement(By.id("visitDateString")).click();
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Visit added successfully"));

    }

}
