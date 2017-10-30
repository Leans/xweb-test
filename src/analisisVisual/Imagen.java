package analisisVisual;

import java.awt.image.BufferedImage;

/**
 * Clase Imagen.
 * Variables de instancia: tipo de imagen, cantidad de pixeles, ancho, alto, 
 * nombre del navegador al que corresponde, BufferedImage (la imagen en si)
 */
public class Imagen {
    
	//variables de instancia
    private String tipoImagen;
    private int cantPixeles;
    private int ancho;
    private int alto;
    private String nombreNavegador;
    private BufferedImage bufferedImage;
    
    /**
    * Constructor de la clase Imagen. Recibe de parametros de entrada: tipo de la imagen, cantidad de pixeles,
    * ancho, alto, el nombre del navegador al que corresponde
    */
    public Imagen(String tipoImagen, int cantPixeles, int ancho, int alto, String nombreNavegador) {
        this.tipoImagen = tipoImagen;
        this.cantPixeles = cantPixeles;
        this.ancho = ancho;
        this.alto = alto;
        this.nombreNavegador = nombreNavegador;
        this.bufferedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
    }
    
    /**
     * Constructor de la clase Imagen. Recibe de parametros de entrada: el nombre del navegador al que corresponde,
     * un objeto BufferedImage (la imagen en si)
     */
    public Imagen(String nombreNavegador, BufferedImage bufferedImage) {
        this.nombreNavegador = nombreNavegador;
        this.bufferedImage = bufferedImage;
        this.tipoImagen = "RGB";
        this.alto = bufferedImage.getHeight();
        this.ancho = bufferedImage.getWidth();
        this.cantPixeles = bufferedImage.getHeight() * bufferedImage.getWidth();
    }     
    
    //getters & setters
    
    /**@return the tipoImagen
     */
    public String getTipoImagen() {
        return tipoImagen;
    }
    /**@param tipoImagen the tipoImagen to set
     */
    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    /** @return the cantPixeles
     */
    public int getCantPixeles() {
        return cantPixeles;
    }
    /**@param cantPixeles the cantPixeles to set
     */
    public void setCantPixeles(int cantPixeles) {
        this.cantPixeles = cantPixeles;
    }

    /**@return the ancho
     */
    public int getAncho() {
        return ancho;
    }
    /**@param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**@return the alto
     */
    public int getAlto() {
        return alto;
    }
    /**@param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**@return the nombreNavegador
     */
    public String getNombreNavegador() {
        return nombreNavegador;
    }
    /**@param nombreNavegador the nombreNavegador to set
     */
    public void setNombreNavegador(String nombreNavegador) {
        this.nombreNavegador = nombreNavegador;
    }

    /**@return the bufferedImage
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    /**@param bufferedImage the bufferedImage to set
     */
    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
}
