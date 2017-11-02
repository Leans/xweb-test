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
        //cont cuenta la cantidad de pixeles comparados por el algoritmo que resultaron iguales
        int cont = 0;
        //pxDiff cuenta la cantidad de pixeles diferentes encontrados en la comparacion de pixeles
        int pxDiff = 0;
        BufferedImage mapaDeCalor = null;
        
        //si el ancho y alto de las imagenes a comparar son iguales, se procede a realizar la comparacion
        if (imagen1.getWidth() == imagen2.getWidth() && imagen1.getHeight() == imagen2.getHeight()) {
            
        	//se crea un objeto mapaDeCalor de tipo BufferedImage, con el tamaño de las imagenes a comparar
        	mapaDeCalor = new BufferedImage(imagen1.getWidth(), imagen1.getHeight(), BufferedImage.TYPE_INT_RGB);
        	
        	//bucle que comparara los pixeles de las imagenes 1 y 2, de a pares
        	//recorre la imagen1 en ancho
        	int imagen1Ancho = imagen1.getWidth();
            for (int x = 0; x < imagen1Ancho; x++) {
            	//recorre la imagen1 en alto
            	int imagen1Alto = imagen1.getHeight();
                for (int y = 0; y < imagen1Alto; y++) {
                	
                	//si el pixel actual en la imagen1 es distinto del pixel en la misma coordenada en la imagen2
                    if (imagen1.getRGB(x, y) != imagen2.getRGB(x, y)) {
                    	
                    	//la comparacion ha fallado, existe al menos un pixel diferente entre las imagenes
                        resultado = false;
                        
                        //crea el mapa de calor, pinta el pixel con la coordenada que se comparo y resulto diferente
                        mapaDeCalor = this.crearMapaDeCalor(mapaDeCalor, x, y);
                        
                        //incrementa el contador de pixeles diferentes entre ambas imagenes
                        pxDiff++;
                    }
                    //incrementa el contador de pixeles iguales entre ambas imagenes
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
    
	/**
	 * Metodo para ejecutar el algoritmo de comparacion de imagenes. Compara dos imagenes.
	 * Se recibe como parametros de entrada las dos imagenes, de tipo Imagen.
	 * Devuelve un resultado de tipo Resultado.
	 */
    public Resultado comparacionPixAMatrizPix(Imagen img1, Imagen img2) {
    	
    	//se almacenan las dos imagenes recibidas como parametro de entrada en variables de tipo BufferedImage
        BufferedImage imagen1 = img1.getBufferedImage();
        BufferedImage imagen2 = img2.getBufferedImage();
        
        //se definen variables para usar en el algoritmo de comparacion de pixeles
        boolean resultado = true;
        Resultado resultadoFinal;
        //cont cuenta la cantidad de pixeles comparados por el algoritmo que resultaron iguales
        int cont = 0;
        //pxDiff cuenta la cantidad de pixeles diferentes encontrados en la comparacion de pixeles
        int pxDiff = 0;
        int pxIgual = 0;
        BufferedImage mapaDeCalor = null;
        
        //si el ancho y alto de las imagenes a comparar son iguales, se procede a realizar la comparacion
        if (imagen1.getWidth() == imagen2.getWidth() && imagen1.getHeight() == imagen2.getHeight()) {
            
        	//se crea un objeto mapaDeCalor de tipo BufferedImage, con el tamaño de las imagenes a comparar
        	mapaDeCalor = new BufferedImage(imagen1.getWidth(), imagen1.getHeight(), BufferedImage.TYPE_INT_RGB);
        	
        	//variables para el manejo del recorrido de la submatriz de imagen2
        	int i;
        	int j;
        	int delta = 0;
        	boolean exito;
        	
        	//bucle que comparara los pixeles de las imagenes 1 y 2, de a pares
        	//recorre la imagen1 en ancho
        	int imagen1Ancho = imagen1.getWidth();
            for (int x = 0; x < imagen1Ancho; x++) {
            	//recorre la imagen1 en alto
            	int imagen1Alto = imagen1.getHeight();
                for (int y = 0; y < imagen1Alto; y++) {
                	System.out.println("cont: " + cont + " | " + "PixDiff: " + pxDiff + " | " + "PxIgual: " + pxIgual);
                	i = x-4;
                	j = y-4;
                	exito = false;
                	//recorre la submatriz de imagen2, del punto inicial (i;j), mientras no se encuentre un punto igual
                	while (i<x+4) {
                		System.out.println("!");
                		while (j<y+4) {
                			System.out.println("!?");
                			//verifica que el punto (i;j) se encuentre dentro del indice de la matriz de la imagen
                			if ((i>=0 && i<imagen1Ancho)  && (j>=0 && j<imagen1Alto)) {
                				System.out.println("aaah");
                				//se hace la comparacion de pixel a pixel
                				//si el pixel actual en imagen1 es distinto del pixel en la submatriz de imagen2
                				if (imagen1.getRGB(x, y) == imagen2.getRGB(i, j)) {
                					//se ha encontrado un pixel igual al pixel (x;y) en la submatriz
                					exito = true;
                					pxIgual++;
                					System.out.println("safe");
                				}
                			}
                			
                			j++;
                		}
                		
                		i++;
                	}
                	
                	//NO se encontro ningun pixel igual al pixel de imagen1 en (x;y) en la submatriz
                	if (!exito) {
                		//la comparacion ha fallado, existe al menos un pixel diferente entre las imagenes
    					resultado = false;
    					//crea el mapa de calor, pinta el pixel con la coordenada (x;y)
    					mapaDeCalor = this.crearMapaDeCalor(mapaDeCalor, x, y);
    					//incrementa el contador de pixeles diferentes entre ambas imagenes
    					pxDiff++;
                	}
                	//incrementa el contador de pixeles comparados
                	cont++;
                } //for imagen1Alto
            } //for imagen1Ancho
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
    
    
}