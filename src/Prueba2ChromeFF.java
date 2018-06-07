

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
public class Prueba2ChromeFF {
	public static void main(String[] args) {
		
		Manipulador manipulador = new Manipulador("Prueba 2 Google - Chrome-Firefox");

		//CHROME
		System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver\\chromedriver.exe");
		
		//crea un options para Chrome
		ChromeOptions options = new ChromeOptions();
		//para desactivar la barra "Chrome is being controlled by automated test software"
		options.addArguments("disable-infobars");
		
		//crea el WebDriver para Chrome pasando como parametro el options creado anteriormente
		WebDriver chromeDriver = new ChromeDriver(options);
		
		//abre la pagina en chrome
		chromeDriver.get("https://www.google.com");
		//realiza la captura de pantalla
		Imagen img1 = manipulador.capturarPantallaFullscreen(chromeDriver);
		chromeDriver.close();

		//FIREFOX
		System.setProperty("webdriver.gecko.driver","C:\\browser-drivers\\geckodriver\\geckodriver.exe");
		
		//crea el WebDriver para firefox
		WebDriver firefoxDriver= new FirefoxDriver();
		
		//abre la pagina en firefox
		firefoxDriver.get("https://www.google.com");
		//realiza la captura de pantalla
		Imagen img2 = manipulador.capturarPantallaFullscreen(firefoxDriver);
		firefoxDriver.close();
		
		//ejecuta la comparacion pixel a matriz de pixeles
		Resultado resultado1 = manipulador.compararImagenesPixAMatrizPix(img1, img2);
		//crea el reporte con los resultados
		manipulador.crearReporte(resultado1);		
	}
}
