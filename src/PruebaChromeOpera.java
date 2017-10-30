import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import analisisVisual.Imagen;
import analisisVisual.Manipulador;
import analisisVisual.Resultado;

/**
 * Prueba para Chrome y Opera, con www.google.com
 */
public class PruebaChromeOpera {

	public static void main(String[] args) {

		Manipulador manipulador = new Manipulador("Prueba Google - Chrome-Opera");

		System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver\\chromedriver.exe");
		
		//crea un options para Chrome
		ChromeOptions options = new ChromeOptions();
		//para desactivar la barra "Chrome is being controlled by automated test software"
		options.addArguments("disable-infobars");
		
		//crea el WebDriver para Chrome pasando como parametro el options creado anteriormente
		WebDriver chromeDriver= new ChromeDriver(options);
		
		chromeDriver.get("https://www.google.com");
		Imagen img1 = manipulador.capturarPantallaFullscreen(chromeDriver);
		chromeDriver.close();

		System.setProperty("webdriver.opera.driver","C:\\browser-drivers\\operadriver\\operadriver.exe");
		
		OperaOptions operaOptions = new OperaOptions();
		operaOptions.setBinary(new File("C:\\Program Files\\Opera\\48.0.2685.50\\opera.exe"));
		
		//crea el WebDriver para opera
		WebDriver operaDriver = new OperaDriver(operaOptions);
		
		operaDriver.get("https://www.google.com");
		Imagen img2 = manipulador.capturarPantallaFullscreen(operaDriver);
		
		Resultado resultado1 = manipulador.compararImagenes(img1, img2);
		manipulador.crearReporte(resultado1);
		
		operaDriver.close();
		
		System.out.println("prueba finalizada");
	}

}
