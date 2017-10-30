package analisisVisual;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *Clase Comparador.
 */
public class Comparador {    
    
	/**
	 * Metodo para ejecutar el algoritmo de comparacion de imagenes. Compara dos imagenes.
	 * Se recibe como parametros de entrada las dos imagenes, de tipo Imagen.
	 * Devuelve un resultado de tipo Resultado.
	 */
    public Resultado ejecutarAlgoritmoDeComparacion(Imagen img1, Imagen img2) {
    	
    	//se almacenan las dos imagenes recibidas como parametro de entrada en variables de tipo BufferedImage
        BufferedImage imagen1 = img1.getBufferedImage();
        BufferedImage imagen2 = img2.getBufferedImage();
        
        //se definen variables para usar en el algoritmo de comparacion de pixeles
        boolean resultado = true;
        Resultado resultadoFinal;
        //cont cuenta la cantidad de pixeles comparados por el algoritmo
        int cont = 0;
        //pxDiff cuenta la cantidad de pixeles diferentes encontrados en la comparacion de pixeles
        int pxDiff = 0;
        BufferedImage mapaDeCalor = null;
        
        //si el ancho y alto de las imagenes a comparar son iguales, se procede a realizar la comparacion
        if (imagen1.getWidth() == imagen2.getWidth() && imagen1.getHeight() == imagen2.getHeight()) {
            
        	//se crea un objeto mapaDeCalor de tipo BufferedImage, con el tamanio de las imagenes a comparar
        	mapaDeCalor = new BufferedImage(imagen1.getWidth(), imagen1.getHeight(), BufferedImage.TYPE_INT_RGB);
        	
        	//bucle que comparara los pixeles de las imagenes 1 y 2, de a pares
        	//recorre la imagen1 en ancho
            for (int x = 0; x < imagen1.getWidth(); x++) {
            	//recorre la imagen1 en alto
                for (int y = 0; y < imagen1.getHeight(); y++) {
                	
                	//si el pixel actual en la imagen1 es distinto del pixel en la misma coordenada en la imagen2
                    if (imagen1.getRGB(x, y) != imagen2.getRGB(x, y)) {
                    	
                    	//la comparacion ha fallado, existe al menos un pixel diferente entre las imagenes
                        resultado = false;
                        
                        //crea el mapa de calor, pinta el pixel con la coordenada que se comparo y resulto diferente
                        mapaDeCalor = this.crearMapaDeCalor(mapaDeCalor, x, y);
                        
                        //incrementa el contador de pixeles diferentes entre ambas imagenes
                        pxDiff++;
                    }
                    //incrementa el contador de pixeles comparados
                    cont++;
                }
            }
        //si no son iguales el ancho y alto de las imagenes a comparar, no puede llevarse a cabo el procesamiento
        } else {
            resultado = false;
        }
        
        //se crea un objeto resultadoFinal de tipo Resultado, 
        //con la informacion obtenida por el algoritmo de comparacion
        resultadoFinal = new Resultado(resultado, pxDiff, cont, img1.getNombreNavegador(), 
        		img2.getNombreNavegador(), mapaDeCalor);
        
        return resultadoFinal;
    }
    
    /**
	 * Metodo para crear el mapa de calor.
	 * Contiene todos los pixeles (pintados en naranja) que resultaron diferentes 
	 * en la comparacion realizada por el algoritmo.
	 * Recibe de parametro d eentrada:una imagen de tipo BufferedImage, dos integer, que representan las coordenadas
	 * del punto que resulto diferente en la comparacion de las dos imagenes.
	 * Devuelve una imagen de tipo BufferedImage (el mapa de calor propiamente dicho)
	 */
    public BufferedImage crearMapaDeCalor(BufferedImage imagen, int x, int y) {
    	
    	//pinta de naranja el pixel en la coordenada dada por (x, y) en la imagen recibida por parametro
        imagen.setRGB(x, y, Color.ORANGE.getRGB());
        
        return imagen;
    }
    
}