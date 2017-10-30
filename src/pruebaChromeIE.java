import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import analisisVisual.Imagen;
import analisisVisual.Manipulador;
import analisisVisual.Resultado;

/**
 * Prueba para Chrome y IE, con www.google.com
 */
public class pruebaChromeIE {

	public static void main(String[] args) {

		Manipulador manipulador = new Manipulador("Prueba Google - Chrome-InternetExplorer");

		System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver\\chromedriver.exe");
		
		//crea un options para chrome
		ChromeOptions options = new ChromeOptions();
		//para desactivar la barra "Chrome is being controlled by automated test software"
		options.addArguments("disable-infobars");
		
		//crea el WebDriver para chrome pasando como parametro el options creado anteriormente
		WebDriver chromeDriver= new ChromeDriver(options);
		
		chromeDriver.get("https://www.google.com");
		Imagen img1 = manipulador.capturarPantallaFullscreen(chromeDriver);
		chromeDriver.close();

		System.setProperty("webdriver.ie.driver","C:\\browser-drivers\\iedriver86\\IEDriverServer.exe");
		
		//crea el WebDriver para internet explorer
		WebDriver homeIE = new InternetExplorerDriver();
		
		homeIE.get("https://www.google.com");
		Imagen img2 = manipulador.capturarPantallaFullscreen(homeIE);
		
		Resultado resultado1 = manipulador.compararImagenes(img1, img2);
		manipulador.crearReporte(resultado1);
		
		homeIE.close();
		
	}

}
