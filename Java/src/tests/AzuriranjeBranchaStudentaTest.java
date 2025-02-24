package tests;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AzuriranjeBranchaStudentaTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void azuriranjeStudenta() throws InterruptedException {
		driver.get("http://localhost:4200/");
		driver.manage().window().setSize(new Dimension(1057, 800));
		Thread.sleep(3000);

		WebElement branchFieldBefore = driver.findElement(
				By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[2]/td[3]"));
		String branchBefore = branchFieldBefore.getText();
		System.out.println("Before: " + branchBefore);
		Thread.sleep(2000);

		driver.findElement(By
				.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[2]/td[4]/button[2]"))
				.click();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[3]/select"))
				.click();
		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath(
				"/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[3]/select/option[4]"));
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn-danger")).click();
		Thread.sleep(2000);

		WebElement branchFieldAfter = driver.findElement(
				By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[1]/td[3]"));
		String branchAfter = branchFieldAfter.getText();
		System.out.println("After: " + branchAfter);

		assertEquals(branchAfter, "M-Tech");
	}

}
