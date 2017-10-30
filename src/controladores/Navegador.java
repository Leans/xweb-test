package controladores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Clase Navegador.
 */
public class Navegador {
    
	/**
	 * Metodo que recibe un string de entrada con el nombre del navegador web.
	 * Devuelve un objeto WebDriver segun el parametro ingresado.
	 * Para Mozilla Firefox devuelve: FirefoxDriver.
	 * Para Google Chrome devuelve: ChromeDriver.
	 * Para Micrcosoft Internet Explorer devuelve: InternetExplorerDriver.
	 */
    public WebDriver getBrowser(String browserName) {

    	//si el string ingresado es FF
		if (browserName.equalsIgnoreCase(Navegadores.FF)) {
			//se define la ruta al geckodriver.exe, el webdriver de firefox
			System.setProperty("webdriver.gecko.driver","C:\\browser-drivers\\geckodriver\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
		//si el string ingresado es Chrome
		if (browserName.equalsIgnoreCase(Navegadores.CHROME)) {
			//se define la ruta al chromedriver.exe, el webdriver de chrome
			System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver\\chromedriver.exe");
			return new ChromeDriver();
		}
		
		//si el string ingresado es IE
		if (browserName.equalsIgnoreCase(Navegadores.IE)) {
			//se define la ruta al iedriver.exe, el webdrver de internet explorer
			System.setProperty("webdriver.ie.driver", "C:\\browser-drivers\\iedriver86\\IEDriverServer.exe");
			//creo un profile nuevo
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			//se indica que ignore la configuracion de modo protegido para el driver de ie
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			return new InternetExplorerDriver(dc);
		}
		
		//sino fue ninguno de los anteriores
		return new OperaDriver();
	}
}
