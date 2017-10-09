package xwebtest;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class IEScreenshot {
	
	public static void main(String[] args) {
		try {
		//String baseUrl = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
		String baseUrl = "http://google.com";
		System.setProperty("webdriver.ie.driver","C:\\browser-drivers\\iedriver86\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		//driver.manage().window().fullscreen(); //TIRA ERROR
		driver.get(baseUrl);
		
		//1 NO ANDA
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.F11);
		actions.perform();
		
		//2
		java.awt.Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		
		//3		
		BufferedImage image = new Robot().createScreenCapture(rectangle);
		ImageIO.write(image, "png", new File("E:\\screenshots\\ie_screenshot_4.png"));
		
        //close IE
        driver.close(); //Tira Excepcion en IE driver
        System.out.println("Operacion finalizada");
        
		}
		catch (Exception e) {
			System.out.println("Exception ;(");
			System.out.println(e.getMessage());
		}
	}

}