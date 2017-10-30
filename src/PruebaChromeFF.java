

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import analisisVisual.Imagen;
import analisisVisual.Manipulador;
import analisisVisual.Resultado;

/**
 * Prueba para Chrome y Firefox, con www.google.com
 */
public class PruebaChromeFF {

	public static void main(String[] args) {
		
		Manipulador manipulador = new Manipulador("Prueba Google - Chrome-Firefox");

		System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver\\chromedriver.exe");
		
		//crea un options para Chrome
		ChromeOptions options = new ChromeOptions();
		//para desactivar la barra "Chrome is being controlled by automated test software"
		options.addArguments("disable-infobars");
		//fullscreen=F11
		//options.addArguments("--start-fullscreen");
		
		//crea el WebDriver para Chrome pasando como parametro el options creado anteriormente
		WebDriver chromeDriver = new ChromeDriver(options);
		
		chromeDriver.get("https://www.google.com");
		Imagen img1 = manipulador.capturarPantallaFullscreen(chromeDriver);
		chromeDriver.close();

		System.setProperty("webdriver.gecko.driver","C:\\browser-drivers\\geckodriver\\geckodriver.exe");
		
		//crea el WebDriver para firefox
		WebDriver homeGoogleFF= new FirefoxDriver();
		
		homeGoogleFF.get("https://www.google.com");
		Imagen img2 = manipulador.capturarPantallaFullscreen(homeGoogleFF);
		
		Resultado resultado1 = manipulador.compararImagenes(img1, img2);
		manipulador.crearReporte(resultado1);
		
		homeGoogleFF.close();

	}

}
