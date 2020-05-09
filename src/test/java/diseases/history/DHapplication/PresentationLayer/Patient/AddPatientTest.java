package diseases.history.DHapplication.PresentationLayer.Patient;

import diseases.history.DHapplication.PresentationLayer.BaseSeleniumTests;
import diseases.history.DHapplication.DHapplicationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DHapplicationApplication.class)
public class AddPatientTest extends BaseSeleniumTests {

    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/addPatient");
        super.setUp();
    }

    @Test
    public void addPatientWithIncorrectNumberPesel() throws InterruptedException {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Weronika");
        driver.findElement(By.id("secondName")).sendKeys("Anna");
        driver.findElement(By.id("surname")).sendKeys("Markowska");
        driver.findElement(By.id("numberPesel")).click();
        driver.findElement(By.id("numberPesel")).sendKeys("57080649323");
        Thread.sleep(4000);
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("109218372");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).sendKeys("Malinowa");
        driver.findElement(By.id("houseNumber")).sendKeys("12");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("72-998");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Wrocław");
        driver.findElement(By.cssSelector(".w3-teal")).click();
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Number PESEL is not correct."));
    }

    @Test
    public void addPatientWithNumberPeselExists() throws InterruptedException {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Weronika");
        driver.findElement(By.id("secondName")).sendKeys("Anna");
        driver.findElement(By.id("surname")).sendKeys("Markowska");
        driver.findElement(By.id("numberPesel")).click();
        driver.findElement(By.id("numberPesel")).sendKeys("57080649326");
        Thread.sleep(4000);
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("999999999");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).sendKeys("Malinowa");
        driver.findElement(By.id("houseNumber")).sendKeys("12");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("72-998");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Wrocław");
        driver.findElement(By.cssSelector(".w3-teal")).click();
        Thread.sleep(2000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Patient with this number PESEL exists in database. " +
                        "Please check and correct it."));
    }


    @Test
    public void addPatientWithIndividualNumberExists() throws InterruptedException {

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Weronika");
        driver.findElement(By.id("secondName")).sendKeys("Anna");
        driver.findElement(By.id("surname")).sendKeys("Markowska");
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("879887778");
        Thread.sleep(4000);
        driver.findElement(By.id("numberPesel")).click();
        driver.findElement(By.id("numberPesel")).sendKeys("78052779025");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).sendKeys("Malinowa");
        driver.findElement(By.id("houseNumber")).sendKeys("12");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("72-998");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Wrocław");
        driver.findElement(By.cssSelector(".w3-teal")).click();
        Thread.sleep(2000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(), is("Patient individual number exists in database. Please check and correct it."));
    }

    @Test
    public void addPatientExists() throws InterruptedException {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Weronika");
        driver.findElement(By.id("secondName")).sendKeys("Anna");
        driver.findElement(By.id("surname")).sendKeys("Markowska");
        driver.findElement(By.id("numberPesel")).click();
        driver.findElement(By.id("numberPesel")).sendKeys("57080649326");
        Thread.sleep(4000);
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("985417326");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).sendKeys("Malinowa");
        driver.findElement(By.id("houseNumber")).sendKeys("12");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("72-998");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Wrocław");
        driver.findElement(By.cssSelector(".w3-teal")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Patient individual number exists in database. " +
                        "Please check and correct it.Patient with this number PESEL exists in database. Please check and correct it."));
    }

    @Test
    public void addPatientCorrect() throws InterruptedException {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Maciej");
        driver.findElement(By.id("secondName")).sendKeys("Karol");
        driver.findElement(By.id("surname")).sendKeys("Czekaj");
        driver.findElement(By.id("gender")).click();
        {
            WebElement dropdown = driver.findElement(By.id("gender"));
            dropdown.findElement(By.xpath("//option[. = 'M']")).click();
        }
        driver.findElement(By.id("numberPesel")).click();
        driver.findElement(By.id("numberPesel")).sendKeys("90021513355");
        Thread.sleep(4000);
        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("981233472");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).sendKeys("Daszyńskiego");
        driver.findElement(By.id("houseNumber")).sendKeys("92");
        driver.findElement(By.id("flatNumber")).sendKeys("2");
        driver.findElement(By.id("zipCode")).sendKeys("39-923");
        driver.findElement(By.id("city")).sendKeys("Kielce");
        driver.findElement(By.cssSelector(".w3-teal")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("Patient added successfully"));
    }


}
