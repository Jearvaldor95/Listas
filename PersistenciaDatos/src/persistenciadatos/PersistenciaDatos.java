package persistenciadatos;

import java.util.*;
import javafx.beans.binding.MapBinding;
import static persistenciadatos.ManejarArchivos.*;

/**
 *
 * @author USUARIO
 */
public class PersistenciaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* List lista1 = new ArrayList();
        lista1.add(1);
        lista1.add("Jesús Valeta");
        lista1.add(27);
        lista1.add(1.72);
        lista1.add(true);

        System.out.println(lista1);

        lista1.forEach(dato -> {
            System.out.println(dato);
        });
        System.out.println(lista1.get(1));
        
        lista1.remove(2);
        System.out.println(lista1);
        
        lista1.set(1, "Jesús Armando");
        System.out.println(lista1);
         
        lista1.clear();
        System.out.println(lista1);*/
       
       /*
       Map numeros = new HashMap();
       
       numeros.put(1, "UNO");
       numeros.put(2, "DOS");
       numeros.put(3, "TRES");
       numeros.put(4, "CUATRO");
       numeros.put(5, "CINCO");
       
        System.out.println(numeros);
        System.out.println(numeros.get(3));
        
        for(Object clave: numeros.keySet()){
            System.out.println(clave+" "+numeros.get(clave));
            
            
        }
        numeros.remove(4);
        System.out.println(numeros);*/
       
       //crearArchivo("Hola.txt");
       //escribirArchivo("Hola.txt","Hola desde java");
       //escribirArchivo("Hola.txt","Mundo");
       //leerArchivo("Hola.txt");
       eliminarArchivo("Hola.txt");
    }

}
