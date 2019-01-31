package model.data_structures;

import java.util.ArrayList;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Generics.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable <T>> implements IArregloDinamico <T>  {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
	
		@SuppressWarnings("unchecked")
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new ArrayList[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    elementos = (T[]) new ArrayList[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darTamano() {
			// TODO implementar
			return tamanoAct;
		}

		public T darElemento(int i) {
			// TODO implementar
			T actual = null;
			for (int j = 0; j< elementos.length; j++)
				{
					if (i == j)
						{
							actual = elementos[j];
						}
				}
			return actual;
		}

		public T buscar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T buscado = null;
			for (int i = 0; i< elementos.length; i++)
			{
				T actual = elementos[i];
				if (dato.compareTo(actual) == 0)
				{
					buscado = actual;
				}
			}
			
			return buscado;
		}

		public T eliminar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T eliminado = null;
			for (int i = 0; i< elementos.length; i++)
			{
				T actual = elementos[i];
				if (dato.compareTo(actual) == 0)
				{
					elementos[i] = null;
				}
			}
			return eliminado;
		}
}
