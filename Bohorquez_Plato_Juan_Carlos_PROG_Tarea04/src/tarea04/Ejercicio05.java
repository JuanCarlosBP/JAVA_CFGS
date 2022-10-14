package tarea04;
import java.util.Arrays;
/**
 * Ejercicio 5. Sopa de letras.
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio05 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la listra de palabras para buscar
        String[] busqueda={"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};
        // 2.- Declaración del array bidimensional que representa la sopa de letras
        String[][] sopa={{"H", "J", "S", "O", "L"}, {"O", "E", "C", "A", "U"}, {"L", "Y", "K", "D", "U"}, 
            {"A", "A", "M", "O", "R"}, {"V", "C", "A", "S", "A"}};
        // Variables de salida
        int contadorEncontradas=0;
        // 3.- Declaración del array unidimensional que almacena los resultados
        String[] resultado;
        // Variables auxiliares
        int contadorFilas;
        int contadorColumnas;
        String cadena;
        String cadena1;
        int valorResultado;
        int contadorBusqueda;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL\n----------------------------------\nSopa de letras:");
        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla
        for (contadorFilas=0; contadorFilas < sopa.length; contadorFilas++){
            for (contadorColumnas=0; contadorColumnas < sopa[contadorFilas].length; contadorColumnas++){
                System.out.print(sopa[contadorFilas][contadorColumnas]+" ");
                if (contadorColumnas == sopa[contadorFilas].length-1 && contadorFilas < sopa.length-1)
                    System.out.println();
            }
        }
        // 5.- Mostramos por pantalla la lista de palabras
        System.out.printf("\nLista de palabras de prueba:\n%s\n",Arrays.toString(busqueda));
        //----------------------------------------------
        //  Procesamiento (implementado por los alumnos)
        //----------------------------------------------
        // 5.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultado=new String[busqueda.length];
        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista
        // 7.1.- Recorremos la lista de palabras
        // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)  
        for (contadorBusqueda=0; contadorBusqueda < busqueda.length; contadorBusqueda++){
            valorResultado=-1;
            cadena1=(busqueda[contadorBusqueda]).toUpperCase();
            for (contadorFilas=0; contadorFilas < sopa.length; contadorFilas++){
                cadena="";
                for (contadorColumnas=0; contadorColumnas < sopa[contadorFilas].length; contadorColumnas++){
                    cadena=cadena+sopa[contadorFilas][contadorColumnas];
                    if (contadorColumnas == sopa[contadorFilas].length-1 && valorResultado<0){
                        valorResultado=cadena.indexOf(cadena1);
                        if (valorResultado > 0){
                            resultado[contadorBusqueda]= "fila "+contadorFilas+" columna "+valorResultado;
                            contadorEncontradas++;
                        }else if (contadorFilas == sopa.length-1 && contadorColumnas == sopa[contadorFilas].length-1){
                            resultado[contadorBusqueda]= "no";
                        }
                    }
                }
            }
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------\nResultado de la búsqueda horizontal:");
        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.printf("%s\nNúmero de palabras encontradas: %d\n",Arrays.toString(resultado),contadorEncontradas);
    }
}
