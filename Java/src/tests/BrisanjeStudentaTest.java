// Generated by Selenium IDE
package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

public class BrisanjeStudentaTest {
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
	public void brisanjeStudenta() throws InterruptedException {
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		String studentNameXpath = "/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[4]/td[1]";
		String studentEmailXpath = "/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[4]/td[2]";
		String studentBranchXpath = "/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[4]/td[3]";
		String deleteButtonXpath = "/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[4]/td[4]/button[1]";

		String studentName = driver.findElement(By.xpath(studentNameXpath)).getText();
		String studentEmail = driver.findElement(By.xpath(studentEmailXpath)).getText();
		String studentBranch = driver.findElement(By.xpath(studentBranchXpath)).getText();

		driver.findElement(By.xpath(deleteButtonXpath)).click();

		Thread.sleep(2000);

		List<WebElement> rows = driver
				.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr"));

		boolean studentExists = false;

		for (WebElement row : rows) {
			List<WebElement> tds = row.findElements(By.tagName("td"));
			if (tds.size() >= 3) {
				String name = tds.get(0).getText();
				String email = tds.get(1).getText();
				String branch = tds.get(2).getText();

				if (name.equals(studentName) && email.equals(studentEmail) && branch.equals(studentBranch)) {
					studentExists = true;
					break;
				}
			}
		}

		assertFalse(studentExists, "Student i dalje postoji u tabeli!");
	}

}
