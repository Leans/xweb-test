package analisisVisual;

/**
 * Clase Pixel
 */
public class Pixel {
	
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Constructor de Pixel. Crea un pixel con valores RGB en cero, es decir un pixel negro.
	 */
	public Pixel() {
		this.setRed(0);
		this.setGreen(0);
		this.setBlue(0);
	}
	
	/**
	 * Constructor de Pixel. Crea un pixel con valores RGB recibidos como parametro de entrada.
	 */
	public Pixel(int p_red, int p_green, int p_blue) {
		this.setRed(p_red);
		this.setGreen(p_green);
		this.setBlue(p_blue);
	}
	
	/**
	 * Constructor de Pixel. Crea un pixel con valores RGB de un objeto Pixel recibido como parametro de entrada.
	 */
	public Pixel(Pixel p_pixel) {
		this.setRed(p_pixel.getRed());
		this.setGreen(p_pixel.getGreen());
		this.setBlue(p_pixel.getBlue());
	}
	
	/**
	 * Constructor de Pixel. Crea un pixel con valores RGB que se obtienen de un int recibido como parametro de entrada.
	 * Este valor numerico se obtiene mediante el metodo getRGB de un objeto BufferedImage.
	 */
	public Pixel(int p_rgb) {
		this.setRed((p_rgb & 0xff0000) >> 16);
		this.setGreen((p_rgb & 0xff00) >> 8);
		this.setBlue(p_rgb & 0xff);
	}

	public int getRed() {
		return this.red;
	}
	/**
	 * Define el valor para el canal rojo correspondiente al pixel.
	 * Los valores que puede tomar varian entre 0-255.
	 */
	public void setRed(int p_red) {
		if (p_red > 255) {
			this.red = 255;
		} else if (p_red < 0) {
			this.red = 0;
		} else {
			this.red = p_red;
		}
	}
	
	public int getGreen() {
		return this.green;
	}
	/**
	 * Define el valor para el canal verde correspondiente al pixel.
	 * Los valores que puede tomar varian entre 0-255.
	 */
	public void setGreen(int p_green) {
		if (p_green > 255) {
			this.green = 255;
		} else if (p_green < 0) {
			this.green = 0;
		} else {
			this.green = p_green;
		}
		
	}
	
	public int getBlue() {
		return this.blue;
	}
	/**
	 * Define el valor para el canal azul correspondiente al pixel.
	 * Los valores que puede tomar varian entre 0-255.
	 */
	public void setBlue(int p_blue) {
		if (p_blue > 255) {
			this.blue = 255;
		} else if (p_blue < 0) {
			this.blue = 0;
		} else {
			this.blue = p_blue;
		}
	}
	
	/**
	 * Metodo para comparar dos pixeles.
	 * Recibe un Pixel de entrada con el que se compara si mismo, y un int que sera un valor tolerancia en la comparacion.
	 * Devuelve un boolean segun si los pixeles resultan iguales dentro del valor de tolerancia.
	 */
    public boolean compararParPixeles(Pixel p_pixel, int p_toleranciaRGB) {
    	
    	boolean comparacion = false;
    	
    	//define un pixel con la minima desviacion de valores RGB segun el valor tolerancia
    	Pixel pixelMin = new Pixel(p_pixel);
    	pixelMin.ajustarDecremento(p_toleranciaRGB);
    	
    	//define un pixel con la maxima desviacion de valores RGB segun el valor tolerancia
    	Pixel pixelMax = new Pixel(p_pixel);
    	pixelMax.ajustarIncremento(p_toleranciaRGB);
    	
    	//si el valor del canal azul del pixel1 se encuentra dentro del valor tolerado de pixel2 
    	if (this.getRed() <= pixelMax.getRed() && this.getRed() >= pixelMin.getRed()) {
    		//si el valor del canal verde del pixel1 se encuentra dentro del valor tolerado de pixel2 
    		if (this.getGreen() <= pixelMax.getGreen() && this.getGreen() >= pixelMin.getGreen()) {
    			//si el valor del canal rojo del pixel1 se encuentra dentro del valor tolerado de pixel2 
    			if (this.getBlue() <= pixelMax.getBlue() && this.getBlue() >= pixelMin.getBlue()) {
    				//se considera los pixeles iguales
    				comparacion = true;
    			}
    		}
    	}
    	
    	return comparacion;
    }

    /**
	 * Metodo para incrementar los valores de cada canal RGB de un pixel.
	 */
	public void ajustarIncremento(int p_toleranciaRGB) {
		this.setRed(this.getRed() + p_toleranciaRGB);
		this.setGreen(this.getGreen() + p_toleranciaRGB);
		this.setBlue(this.getBlue() + p_toleranciaRGB);
	}
	
	/**
	 * Metodo para decrementar los valores de cada canal RGB de un pixel.
	 */
	public void ajustarDecremento(int p_toleranciaRGB) {
		this.setRed(this.getRed() - p_toleranciaRGB);
		this.setGreen(this.getGreen() - p_toleranciaRGB);
		this.setBlue(this.getBlue() - p_toleranciaRGB);
	}
	
	/**
	 * Metodo que muestra los valores de cada canal RGB por Terminal.
	 */
	public void mostrar() {
		System.out.println("RED: " + this.getRed() + " GREEN: " + this.getGreen() + " BLUE: " + this.getBlue());
	}

}
