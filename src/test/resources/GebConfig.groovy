import java.util.concurrent.TimeUnit
import org.openqa.selenium.chrome.ChromeDriver


driver = {
	System.setProperty('webdriver.chrome.driver', 'src/test/resources/chromedriver.exe')
	def chromeDriver = new ChromeDriver()
	chromeDriver.manage().window().maximize()
	chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
	chromeDriver
}

reportsDir = 'C:/Screenshots'