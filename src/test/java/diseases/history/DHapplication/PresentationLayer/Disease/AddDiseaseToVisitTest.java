package diseases.history.DHapplication.PresentationLayer.Disease;

import diseases.history.DHapplication.PresentationLayer.BaseSeleniumTests;
import diseases.history.DHapplication.DHapplicationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DHapplicationApplication.class)
public class AddDiseaseToVisitTest extends BaseSeleniumTests {

    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/api/visit/searchVisit?patientIndividualNumber=112857234&visitDate=2019-12-15&selectedButton=");
        super.setUp();
    }

    @Test
    public void addExistingDiseaseToVisit() throws InterruptedException {

        driver.findElement(By.id("addDisease")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("102")).click();
        Thread.sleep(100);
        vars.put("selectedDisease", driver.findElement(By.id("diseaseName")).getAttribute("value"));
        Thread.sleep(10000);
        driver.findElement(By.name("accept")).click();
        vars.put("visitDisease", driver.findElement(By.cssSelector("td:nth-child(5)")).getText());
        assertEquals(vars.get("selectedDisease"), vars.get("visitDisease"));

    }

    @Test
    public void addNewDisease() throws InterruptedException {


        driver.findElement(By.id("addDisease")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".w3-teal")).click();
        driver.findElement(By.id("1")).click();
        Thread.sleep(2000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Choroby układu oddechowego']")).click();
        }
        driver.findElement(By.id("1")).click();
        driver.findElement(By.cssSelector(".w3-green")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(2000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));

            dropdown.findElement(By.xpath("//option[. = 'Inne choroby opłucnej']")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".w3-green")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Odma opłucnowa']")).click();
        }
        Thread.sleep(1000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".w3-green")).click();
        driver.findElement(By.id("1")).click();
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Inna odma opłucnowa']")).click();
        }
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        vars.put("newDisease", driver.findElement(By.id("1")).getAttribute("value"));
        driver.findElement(By.id("startDateString")).click();
        driver.findElement(By.id("startDateString")).sendKeys("02-08-2012");
        Thread.sleep(5000);
        driver.findElement(By.id("accept")).click();
        Thread.sleep(5000);
        vars.put("lastDisease", driver.findElement(By.cssSelector("#\\31 22 > td:nth-child(2)")).getText());
        assertEquals(vars.get("newDisease"), vars.get("lastDisease"));
    }

    @Test
    public void addNewDiseaseExists() throws InterruptedException {
        driver.findElement(By.id("addDisease")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".w3-teal")).click();
        driver.findElement(By.id("1")).click();
        Thread.sleep(2000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Choroby układu oddechowego']")).click();
        }
        driver.findElement(By.id("1")).click();
        driver.findElement(By.cssSelector(".w3-green")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(2000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));

            dropdown.findElement(By.xpath("//option[. = 'Inne choroby opłucnej']")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".w3-green")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Odma opłucnowa']")).click();
        }
        Thread.sleep(1000);
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".w3-green")).click();
        driver.findElement(By.id("1")).click();
        {
            WebElement dropdown = driver.findElement(By.id("1"));
            dropdown.findElement(By.xpath("//option[. = 'Inna odma opłucnowa']")).click();
        }
        driver.findElement(By.id("1")).click();
        Thread.sleep(1000);
        vars.put("newDisease", driver.findElement(By.id("1")).getAttribute("value"));
        driver.findElement(By.id("startDateString")).click();
        driver.findElement(By.id("startDateString")).sendKeys("02-08-2012");
        Thread.sleep(5000);
        driver.findElement(By.id("accept")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".w3-text-black")).getText(),
                is("This disease for this patient exists"));

    }
}
