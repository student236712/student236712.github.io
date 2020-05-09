package diseases.history.DHapplication.PresentationLayer.Disease;

import diseases.history.DHapplication.PresentationLayer.BaseSeleniumTests;
import diseases.history.DHapplication.DHapplicationApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DHapplicationApplication.class)
public class ChangeDiseaseSpecification extends BaseSeleniumTests {
    @Override
    public void setUp() {
        super.setURL("https://localhost:8443/api/patient/getAllPatients");
        super.setUp();
    }

    @Test
    public void changeDiseaseSpecification() throws InterruptedException {

        driver.findElement(By.id("individualNumber")).click();
        driver.findElement(By.id("individualNumber")).sendKeys("112857234");
        driver.findElement(By.name("selectedButton")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(".w3-bar-item:nth-child(5)")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("99")).click();
        vars.put("selectedDisease", driver.findElement(By.id("99")).getAttribute("id"));
        Thread.sleep(1000);
        driver.findElement(By.id("diseaseStatus")).click();
        {
            WebElement dropdown = driver.findElement(By.id("diseaseStatus"));
            dropdown.findElement(By.xpath("//option[. = 'TERMINATED']")).click();
        }
        driver.findElement(By.id("diseaseStatus")).click();
        vars.put("selectedStatus", driver.findElement(By.id("diseaseStatus")).getAttribute("value"));
        driver.findElement(By.id("diseaseEndDate")).click();
        driver.findElement(By.id("diseaseEndDate")).sendKeys("27-03-2020");
        vars.put("selectedEndDate", driver.findElement(By.id("diseaseEndDate")).getAttribute("value"));
        Thread.sleep(4000);
        driver.findElement(By.id("accept")).click();
        Thread.sleep(4000);
        driver.navigate().to("https://localhost:8443/api/history/diseasesHistory?firstName=" +
                "Jan&secondName=Marek&surname=Konwa&gender=M&individualNumber=112857234&numberPesel" +
                "=58041551630&dateOfBirth=15.04.1958&id=1");
        Thread.sleep(4000);
        //end date
        vars.put("presentEndDate", driver.findElement(By.xpath("//tr[@id='99']/td[2]")).getText());
        //status
        vars.put("presentStatus", driver.findElement(By.xpath("//tr[@id='99']/td[5]")).getText());
        Assert.assertEquals(vars.get("presentEndDate"), vars.get("selectedEndDate"));
        Assert.assertEquals(vars.get("presentStatus"), vars.get("selectedStatus"));
    }
}
