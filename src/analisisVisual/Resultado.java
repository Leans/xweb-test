package analisisVisual;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Clase resultado.
 */
public class Resultado {

	//variables de instancia
	private boolean resultado;
	private int cantPixDiferentes;
	private int cantPixTotal;
	private String navegador1;
	private String navegador2;
	private BufferedImage mapaDeCalor;
	private double PorcentajePxDiff;

	/**
	 * Constructor de Resultado. Recibe como parametros de entrada: un boolean, integer con la cantidad de pixeles diferentes,
	 * integer con la cantidad de pixeles totales, string con el navegador 1, string con el navegador 2, 
	 * un BufferedImage (con la imagen-mapa de calor)
	 */
	public Resultado(boolean resultado, int cantPixDiferentes, int cantPixTotal, String navegador1, String navegador2,
			BufferedImage mapaDeCalor) {
		this.resultado = resultado;
		this.cantPixDiferentes = cantPixDiferentes;
		this.cantPixTotal = cantPixTotal;
		this.navegador1 = navegador1;
		this.navegador2 = navegador2;
		this.mapaDeCalor = mapaDeCalor;
		System.out.println(mapaDeCalor);
		this.setPorcentajePxDiff(cantPixDiferentes*100/cantPixTotal);
	}
	
	/**
	 * Constructor de Resultado. Recibe como parametros de entrada: un boolean, integer con la cantidad de pixeles diferentes,
	 * integer con la cantidad de pixeles totales, string con el navegador 1, string con el navegador 2, 
	 * un BufferedImage (con la imagen-mapa de calor), un int con el porcentaje de pixeles diferentes
	 */
	public Resultado(boolean resultado, int cantPixDiferentes, int cantPixTotal, String navegador1, String navegador2,
			BufferedImage mapaDeCalor, double porcentajePixDiff) {
		this.resultado = resultado;
		this.cantPixDiferentes = cantPixDiferentes;
		this.cantPixTotal = cantPixTotal;
		this.navegador1 = navegador1;
		this.navegador2 = navegador2;
		this.mapaDeCalor = mapaDeCalor;
		System.out.println(mapaDeCalor);
		this.setPorcentajePxDiff(porcentajePixDiff);
	}

	/**
	 * Metodo que recibe un string con una ruta, donde se almacenara una imagen.
	 * Esta imagen es resultado de una comparacion. Puede haber resultado exitosa o haber fallado.
	 * En caso de haber fallado se produce una imagen con el mapa de calor de la comparacion.
	 */
	public void guardarResultado(String path) {
		try {
			//si la prueba ha sido exitosa
			if (this.resultado == true) {
				BufferedImage exito = ImageIO.read(new File("C:\\che\\utils\\exito.png"));
				ImageIO.write(exito, "png", new File(path));
				return;
			}

			//si la prueba ha fallado
			if ((this.resultado == false) && (this.mapaDeCalor == null)) {
				BufferedImage fallo = ImageIO.read(new File("C:\\che\\utils\\fallo.png"));
				ImageIO.write(fallo, "png", new File(path));
				return;
			}

			if ((this.resultado == false) && (this.mapaDeCalor != null)) {

				ImageIO.write(this.mapaDeCalor, "png", new File(path));

			}
		} catch (IOException ex) {
			System.out.println("Error de entrada/salida");
			System.out.println("No se puede guardar la imagen en la ruta especificada: " + path);
		}
	}
	
	//getters & setters

	/**@return the resultado
	 */
	public boolean isResultado() {
		return resultado;
	}
	/**@param resultado
	 *            the resultado to set
	 */
	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	/**@return the cantPixDiferentes
	 */
	public int getCantPixDiferentes() {
		return cantPixDiferentes;
	}
	/**@param cantPixDiferentes
	 *            the cantPixDiferentes to set
	 */
	public void setCantPixDiferentes(int cantPixDiferentes) {
		this.cantPixDiferentes = cantPixDiferentes;
	}

	/**@return the cantPixTotal
	 */
	public int getCantPixTotal() {
		return cantPixTotal;
	}
	/** @param cantPixTotal
	 *            the cantPixTotal to set
	 */
	public void setCantPixTotal(int cantPixTotal) {
		this.cantPixTotal = cantPixTotal;
	}

	/**@return the navegador1
	 */
	public String getNavegador1() {
		return navegador1;
	}
	/**@param navegador1
	 *            the navegador1 to set
	 */
	public void setNavegador1(String navegador1) {
		this.navegador1 = navegador1;
	}

	/**@return the navegador2
	 */
	public String getNavegador2() {
		return navegador2;
	}
	/**@param navegador2
	 *            the navegador2 to set
	 */
	public void setNavegador2(String navegador2) {
		this.navegador2 = navegador2;
	}

	/**@return the mapaDeCalor
	 */
	public BufferedImage getMapaDeCalor() {
		return mapaDeCalor;
	}
	/**@param mapaDeCalor
	 *            the mapaDeCalor to set
	 */
	public void setMapaDeCalor(BufferedImage mapaDeCalor) {
		this.mapaDeCalor = mapaDeCalor;
	}

	public double getPorcentajePxDiff() {
		return PorcentajePxDiff;
	}

	public void setPorcentajePxDiff(double porcentajePixDiff) {
		PorcentajePxDiff = porcentajePixDiff;
	}

}
